/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robosim;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

/**
 *
 * @author karmakar_896187
 */
public class Team implements Comparable<Team>, Serializable {
    private String name;
    private int number;
    private double rp;
    private double tbp;
    
    private ArrayList<Integer> scores;
    private ArrayList<Integer> scores_simulated;
    private ArrayList<Integer> simRanks;
    private TreeSet<Integer> matchNumbers;

    public Team() {
        name = "";
        number = 0;
        rp = 0;
        tbp = 0;

        scores = new ArrayList<>();
        scores_simulated = new ArrayList<>();
        matchNumbers = new TreeSet<>();
    }

    public Team(String name, int number, ArrayList<Integer> scores) {
        this.rp = 0.0;
        this.tbp = 0.0;
        this.scores_simulated = new ArrayList<>();
        this.matchNumbers = new TreeSet<>();
        this.name = name;
        this.number = number;
        this.scores = scores;
    }
    
    public Team(String name, int number, double rp, double tbp, ArrayList<Integer> scores, ArrayList<Integer> scores_simulated, TreeSet<Integer> matchNumbers) {
        this.name = name;
        this.number = number;
        this.rp = rp;
        this.tbp = tbp;
        this.scores = scores;
        this.scores_simulated = scores_simulated;
        this.matchNumbers = matchNumbers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getRp() {
        return rp;
    }
    
    public void setRp(double rp) {
        this.rp = rp;
    }

    public double getTbp() {
        return tbp;
    }

    public void setTbp(double tbp) {
        this.tbp = tbp;
    }

    public ArrayList<Integer> getScores() {
        return scores;
    }

    public void setScores(ArrayList<Integer> scores) {
        this.scores = scores;
    }

    public ArrayList<Integer> getScores_simulated() {
        return scores_simulated;
    }

    public void setScores_simulated(ArrayList<Integer> scores_simulated) {
        this.scores_simulated = scores_simulated;
    }
    
    public TreeSet<Integer> getMatchNumbers() {
        return matchNumbers;
    }

    public void setMatchNumbers(TreeSet<Integer> matchNumbers) {
        this.matchNumbers = matchNumbers;
    }
    
    public void addTBP(int p){
        this.tbp += p;
    }
    
    public void addRP(int p){
        this.rp += p;
    }
    
    @Override
    public String toString(){
        String text = number + " - " + name + ", RP/TBP: " + rp + "/" + tbp + "\n";
        /*String text = "";
        text += number + " - " + name + ", RP/TBP: " + rp + "/" + tbp + "\n" + 
                "Historical Scores: "+ scores + 
                "\nSimulated Scores: " + scores_simulated + "\n" +
                "Match Numbers: " + matchNumbers;*/
        return text;
    }
    
    
    @Override
    public int compareTo(Team t) {
        //organize by RP first
        //then by TBP
        //then by high score
        //then by avg score
        
        if(this.rp > t.getRp()) return -1;
        if(this.rp < t.getRp()) return 1;
        
        if(this.tbp > t.getTbp()) return -1;
        if(this.tbp < t.getTbp()) return 1;
        
        if(Collections.max(this.scores_simulated) > Collections.max(t.getScores())) return -1;
        if(Collections.max(this.scores_simulated) < Collections.max(t.getScores())) return 1;
        
        if(ScoreMaker.getAverage(this.scores_simulated) > ScoreMaker.getAverage(this.scores_simulated)) return -1;
        if(ScoreMaker.getAverage(this.scores_simulated) < ScoreMaker.getAverage(this.scores_simulated)) return 1;
        
        return 0; 
    } 
    
    @Override
    public Team clone(){
        return new Team(name, number, rp, tbp, scores, scores_simulated, matchNumbers);
    }
    
    public void clear(){
        rp = 0;
        tbp = 0;
        scores_simulated = new ArrayList<>();
        matchNumbers = new TreeSet<>();
    }
}

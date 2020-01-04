/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robosim;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author karmakar_896187
 */
public class Simulator implements Serializable{

    private TreeSet<Team> rankedTeams;
    private TreeSet<Match> matches;
    private TreeMap<Integer,Team> teamList;
    private TreeMap<Integer, Double> oprs = new TreeMap<>();



    public Simulator() {
        this.rankedTeams = new TreeSet<>();
        this.matches = new TreeSet<>();
        this.teamList = new TreeMap<>();
    }
    
    public Simulator(TreeSet<Team> rankedTeams, TreeSet<Match> matches, TreeMap<Integer,Team> teamList, TreeMap<Integer,Double> oprs) {
        this.rankedTeams = rankedTeams;
        this.matches = matches;
        this.teamList = teamList;
        this.oprs = oprs;
    }   

    public TreeSet<Team> getRankedTeams() {
        return rankedTeams;
    }

    public TreeSet<Match> getMatches() {
        return matches;
    }

    public void setRankedTeams(TreeSet<Team> rankedTeams) {
        this.rankedTeams = rankedTeams;
    }

    public void setMatches(TreeSet<Match> matches) {
        this.matches = matches;
    }

    public TreeMap<Integer,Team> getTeamList() {
        return teamList;
    }

    public TreeMap<Integer, Double> getOprs() {
        return oprs;
    }

    public void setOprs(TreeMap<Integer, Double> oprs) {
        this.oprs = oprs;
    }

    public void setTeamList(TreeMap<Integer,Team> teamList) {
        this.teamList = teamList;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robosim;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 *
 * @author karmakar_896187
 */
class Match implements Comparable<Match>, Serializable {
    private String name;
    private int red1;
    private int red2;
    private int blue1;
    private int blue2;
    private int redScore;
    private int blueScore;
    private boolean[] surrogate; // identifies the surrogates for the matches {false, false, false, false}

    public String getName() {
        return name;
    }

    public int getRed1() {
        return red1;
    }

    public int getRed2() {
        return red2;
    }

    public int getBlue1() {
        return blue1;
    }

    public int getBlue2() {
        return blue2;
    }

    public int getRedScore() {
        return redScore;
    }

    public void setRedScore(int redScore) {
        this.redScore = redScore;
    }

    public void setBlueScore(int blueScore) {
        this.blueScore = blueScore;
    }

    public int getBlueScore() {
        return blueScore;
    }

    public boolean[] getSurrogate() {
        return surrogate;
    }

    public Match(){
        name = "";
        red1 = 0;
        red2 = 0;
        blue1 = 0;
        blue2 = 0;
        redScore = 0;
        blueScore = 0;
        surrogate = new boolean[4];
    }
    
    public Match(String name, int red1, int red2, int blue1, int blue2, boolean[] surrogate) {
        this.redScore = 0;
        this.blueScore = 0;
        this.surrogate = surrogate;
        this.name = name;
        this.red1 = red1;
        this.red2 = red2;
        this.blue1 = blue1;
        this.blue2 = blue2;
    }

    public Match(String name, int red1, int red2, int blue1, int blue2, int redScore, int blueScore, boolean[] surrogate) {
        this.name = name;
        this.red1 = red1;
        this.red2 = red2;
        this.blue1 = blue1;
        this.blue2 = blue2;
        this.redScore = redScore;
        this.blueScore = blueScore;
        this.surrogate = surrogate;
    }    
    
    public int getMatchNum(){
        String m = this.getName();
        int num = Integer.parseInt(m.substring(m.indexOf(" ")+1,m.length()));
        return num;
    }

    @Override
    public String toString() {
        return (name + ": " + redScore + " (" + red1 + " " + red2 + "), " + blueScore + " (" + blue1 + " " + blue2 + ")");
    }

    @Override
    public int compareTo(Match m) {        
        //return this.getName().compareTo(m.getName());
        String m1 = this.getName();
        int m1Score = Integer.parseInt(m1.substring(m1.indexOf(" ")+1,m1.length()));
        
        String m2 = m.getName();
        int m2Score = Integer.parseInt(m2.substring(m2.indexOf(" ")+1,m2.length()));
        
        if(m1Score < m2Score){
            return -1;
        }else if(m1Score > m2Score){
            return 1;
        }else{
            return 0;
        }
    }
    
    @Override
    public Match clone(){
        return new Match(name,red1,red2,blue1,blue2,redScore,blueScore,surrogate);
    }
    
    public void clear(){
        red1 = 0;
        red2 = 0;
        blue1 = 0;
        blue2 = 0;
        redScore = 0;
        blueScore = 0;
        surrogate = new boolean[4];
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robosim;

import java.util.ArrayList;
import java.util.TreeSet;
import org.apache.commons.math3.special.Erf;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

/**
 *
 * @author karmakar_896187
 */
public class ScoreMaker {
    public static double getAverage(ArrayList<Integer> scores){
        //returns the avg of the scores arraylist
        double total = 0.0;
        
        for(Integer score: scores){
            total += score;
        }
        return total/scores.size();        
    }
   
    
    public static double getSTD(ArrayList<Integer> scores){
        // returns the standard deviation
        StandardDeviation standDev = new StandardDeviation();
        //Convert Integer scores to a double[]
        double[] values = new double[scores.size()];
        int i=0;
        for (Integer score : scores) {
            values[i] = score;
            i++;
        }
        double std = standDev.evaluate(values);
        return std;
    }    
    
    public static int getScore(double opr, double std){
        //returns a randomized score based on a normal distribution of historical performance scores
        //score = (zScore * STD) + mean
        //zScore = sqrt(2) * (inverseErrorFunctionComplement of 2 * percentile) * -1
        //percentile = random value between 0 and 1
        //mean = OPR calculated using the standard formula from FTC Scores from most recent event.
        //Use OPR instead of mean to account for tighter score predictions of performance. 
        //Mean includes the opponents score, OPR reflects the individual perfomance and contribution
        
        double percentile = Math.random();
        
        double zScore = Math.sqrt(2) * Erf.erfcInv(2*percentile) * -1;
            
        int score = new Double(zScore*(std/2) + opr).intValue();
        
        if (score < 0)
            return 0;
        return score;
    }
}

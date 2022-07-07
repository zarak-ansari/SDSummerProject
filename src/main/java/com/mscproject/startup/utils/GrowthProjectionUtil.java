package com.mscproject.startup.utils;

import java.util.ArrayList;
import java.util.List;

public class GrowthProjectionUtil {
    
    public static void main(String[] args) {
        System.out.println(linearGrowth(100, 10, 0.1, 10));
        System.out.println(compoundingGrowth(100, 0.1, 10));
    }

    public static List<Long> linearGrowth(long startingNumber, long baseIncrement, double percentageGrowthInIncrement, int numberOfPeriods){

        ArrayList<Long> result = new ArrayList<Long>();
        
        for(int i = 0; i<numberOfPeriods; i++){
            result.add((long) (startingNumber + (baseIncrement * Math.pow((1 + percentageGrowthInIncrement),i)) * i ));
        }
        return result;
    }
    
    public static List<Long> compoundingGrowth(long startingNumber, double percentageGrowth, int numberOfPeriods){
        ArrayList<Long> result = new ArrayList<>();
        
        for(int i = 0; i< numberOfPeriods; i++){
            result.add((long) Math.round((startingNumber *  Math.pow(1+percentageGrowth, i))));
        }

        return result;
    }

}

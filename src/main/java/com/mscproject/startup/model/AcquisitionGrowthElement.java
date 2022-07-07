package com.mscproject.startup.model;

import java.util.ArrayList;
import java.util.List;

import com.mscproject.startup.utils.GrowthOption;
import com.mscproject.startup.utils.GrowthProjectionUtil;

public class AcquisitionGrowthElement {
    private String name;
    private String description;
    private long startingNumber;
    private int startingPeriod;
    private int endingPeriod;
    private GrowthOption growthOption;
    private long baseIncrement;
    private double percentageGrowth;

    
    public AcquisitionGrowthElement(){
        this.name = "Default Name";
        this.description = "Default Description";
        this.startingNumber = 1000;
        this.startingPeriod = 0;
        this.endingPeriod = 10;
        this.growthOption = GrowthOption.LINEAR;
        this.baseIncrement = 100;
        this.percentageGrowth = 0;
    }

    public AcquisitionGrowthElement(String name, String description, long startingNumber, int startingPeriod,
            int endingPeriod, GrowthOption growthOption, long baseIncrement, double percentageGrowth) {
        this.name = name;
        this.description = description;
        this.startingNumber = startingNumber;
        this.startingPeriod = startingPeriod;
        this.endingPeriod = endingPeriod;
        this.growthOption = growthOption;
        this.baseIncrement = baseIncrement;
        this.percentageGrowth = percentageGrowth;
    }


    public List<Long> calculateResultingGrowth(){
        
        List<Long> result = new ArrayList<>();
        
        if(growthOption == GrowthOption.LINEAR){
            result = GrowthProjectionUtil.linearGrowth(startingNumber, baseIncrement, percentageGrowth, endingPeriod);
        } else if(growthOption == GrowthOption.COMPOUNDING){
            result = GrowthProjectionUtil.compoundingGrowth(startingNumber, percentageGrowth, endingPeriod);
        }

        return result;
    }

    public String toString(){
        return this.name + this.description;
    }

    // Getters and Setters
    
    
    public long getStartingNumber() {
        return startingNumber;
    }
    public int getEndingPeriod() {
        return endingPeriod;
    }




    public void setEndingPeriod(int endingPeriod) {
        this.endingPeriod = endingPeriod;
    }




    public void setStartingNumber(long startingNumber) {
        this.startingNumber = startingNumber;
    }
    public int getStartingPeriod() {
        return startingPeriod;
    }
    public void setStartingPeriod(int startingPeriod) {
        this.startingPeriod = startingPeriod;
    }
    public GrowthOption getGrowthOption() {
        return growthOption;
    }
    public void setGrowthOption(GrowthOption growthOption) {
        this.growthOption = growthOption;
    }
    public long getBaseIncrement() {
        return baseIncrement;
    }
    public void setBaseIncrement(long baseIncrement) {
        this.baseIncrement = baseIncrement;
    }
    public double getPercentageGrowth() {
        return percentageGrowth;
    }
    public void setPercentageGrowth(double percentageGrowth) {
        this.percentageGrowth = percentageGrowth;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




    public String getName() {
        return name;
    }




    public void setName(String name) {
        this.name = name;
    }

    

}

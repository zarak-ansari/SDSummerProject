package com.mscproject.startup.model;

import java.util.ArrayList;
import java.util.List;


public class StartupProject {
    private String name;

    private int numberOfPeriods;

    private AcquisitionGrowthElementDto growthElements;

    private List<Long> acquisitions;
    
    public StartupProject(){
        this.acquisitions = new ArrayList<>();
    }

    public void updateAcquisitions(){
        for(AcquisitionGrowthElement acquisitionGrowthElement: growthElements.getElements()){

            List<Long> growthNumbersToBeAdded = acquisitionGrowthElement.calculateResultingGrowth();
                        
            for(int i = 0; i < acquisitionGrowthElement.getEndingPeriod(); i++){
                int period = acquisitionGrowthElement.getStartingPeriod() + i;
                long result = this.acquisitions.get(period) + growthNumbersToBeAdded.get(i);
                this.acquisitions.set(period, result);
            }
        }
    }

    public int getNumberOfPeriods() {
        return numberOfPeriods;
    }

    public void setNumberOfPeriods(int numberOfPeriods) {
        for(int i = 0; i < numberOfPeriods; i++){
            this.acquisitions.add((long)0);
        }
        this.numberOfPeriods = numberOfPeriods;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getAcquisitions() {
        return acquisitions;
    }

    public void setAcquisitions(List<Long> acquisition) {
        this.acquisitions = acquisition;
    }

    public AcquisitionGrowthElementDto getGrowthElements() {
        return growthElements;
    }

    public void setGrowthElements(AcquisitionGrowthElementDto growthElements) {
        this.growthElements = growthElements;
    }
}

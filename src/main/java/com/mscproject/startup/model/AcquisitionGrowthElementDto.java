package com.mscproject.startup.model;

import java.util.ArrayList;
import java.util.List;

public class AcquisitionGrowthElementDto {

    private List<AcquisitionGrowthElement> elements;

    public AcquisitionGrowthElementDto(){
        this.elements = new ArrayList<>();
    }

    public void addElement(AcquisitionGrowthElement element){
        this.elements.add(element);
    }

    public List<AcquisitionGrowthElement> getElements() {
        return elements;
    }
        
}

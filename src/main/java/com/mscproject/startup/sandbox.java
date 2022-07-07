package com.mscproject.startup;

import com.mscproject.startup.model.AcquisitionGrowthElement;
import com.mscproject.startup.model.AcquisitionGrowthElementDto;
import com.mscproject.startup.model.StartupProject;

public class sandbox {
    public static void main(String[] args) {
        StartupProject start = new StartupProject();
		start.setNumberOfPeriods(20);
        start.setName("ABC");
        
        AcquisitionGrowthElement element1 = new AcquisitionGrowthElement();
        AcquisitionGrowthElement element2 = new AcquisitionGrowthElement();
        AcquisitionGrowthElement element3 = new AcquisitionGrowthElement();

        AcquisitionGrowthElementDto dto = new AcquisitionGrowthElementDto();

        dto.addElement(element1);
        dto.addElement(element2);
        dto.addElement(element3);

        start.setGrowthElements(dto);

        start.updateAcquisitions();

        System.out.println(start.getAcquisitions());

    }
    
}

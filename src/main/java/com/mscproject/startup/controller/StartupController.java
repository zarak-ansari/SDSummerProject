package com.mscproject.startup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mscproject.startup.model.AcquisitionGrowthElement;
import com.mscproject.startup.model.AcquisitionGrowthElementDto;
import com.mscproject.startup.model.StartupProject;

@Controller
@SessionAttributes("startupProject")
public class StartupController {


    @GetMapping("/")
	public String index(Model model, @ModelAttribute("startupProject") StartupProject startupProject){
		
		model.addAttribute("startupProject", startupProject);
		return "home";
	} 

    @PostMapping("/acquisitionForm")
    public String acquisition(Model model, @ModelAttribute("startupProject") StartupProject startupProject){
        
        AcquisitionGrowthElementDto growthElements = new AcquisitionGrowthElementDto();
        for(int i = 0; i<5; i++) growthElements.addElement(new AcquisitionGrowthElement());
        startupProject.setGrowthElements(growthElements);

        model.addAttribute("startupProject",startupProject);
        model.addAttribute("acquisitionGrowthElements", growthElements);
        return "acquisition";
    }

    @PostMapping("/acquisitionFormResult")
    public String acquisitionResult(Model model, @ModelAttribute("startupProject") StartupProject startupProject){


        startupProject.updateAcquisitions();
        model.addAttribute("acquisitions",startupProject.getAcquisitions());
        return "acquisitionResult";
    }

    @ModelAttribute("startupProject")
    public StartupProject startupProject(){
        return new StartupProject();
    }
}

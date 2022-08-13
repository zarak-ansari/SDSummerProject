package com.mscproject.startup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mscproject.startup.service.StartupProjectService;
import com.mscproject.startup.model.*;

@RestController
@RequestMapping("api/startup_project")
@CrossOrigin
public class StartupProjectController {

    @Autowired
    private StartupProjectService userCategoryService;

    @PostMapping
    public void createStartupProject(@RequestBody StartupProject startupProject) {
        userCategoryService.createStartupProject(startupProject);
    }

    @GetMapping("/{id}")
    public StartupProject getStartupProject(@PathVariable Long id) {
        return userCategoryService.getStartupProjectById(id);
    }

    @PostMapping("/{projectId}/acquisition_elements")
    public void setAcquisitionElements(@RequestBody List<AcquisitionElement> acquisitionElements,
            @PathVariable Long projectId) {
        userCategoryService.setAcquisitionElements(projectId, acquisitionElements);
    }

    @PostMapping("/{projectId}/activation_elements")
    public void setActivationElements(@RequestBody List<ActivationElement> activationElements,
            @PathVariable Long projectId) {
        userCategoryService.setActivationElements(projectId, activationElements);
    }

    @PostMapping("/{projectId}/retention")
    public void setRetention(@RequestBody List<Float> retentionCurve,
            @PathVariable Long projectId) {
        userCategoryService.setRetentionCurve(projectId, retentionCurve);
    }

    @PostMapping("/{projectId}/referral")
    public void setMonetization(@RequestBody Referral referral,
            @PathVariable Long projectId) {
        userCategoryService.setReferral(projectId, referral);
    }

    @PostMapping("/{projectId}/monetization")
    public void setMonetization(@RequestBody Monetization monetization,
            @PathVariable Long projectId) {
        userCategoryService.setMonetization(projectId, monetization);
    }

}

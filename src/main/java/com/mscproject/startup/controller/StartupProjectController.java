package com.mscproject.startup.controller;

import java.util.List;

import com.mscproject.startup.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mscproject.startup.service.StartupProjectService;


@RestController
@RequestMapping("api/startup_project")
@CrossOrigin
public class StartupProjectController {

    @Autowired
    private StartupProjectService startupProjectService;

    @PostMapping
    public void createStartupProject(@RequestBody StartupProject startupProject) {
        startupProjectService.createStartupProject(startupProject);
    }

    @GetMapping("/{id}")
    public StartupProject getStartupProject(@PathVariable Long id) {
        return startupProjectService.getStartupProjectById(id);
    }

    @PostMapping("/{projectId}/acquisition_elements")
    public void setAcquisitionElements(@RequestBody List<AcquisitionElement> acquisitionElements,
            @PathVariable Long projectId) {
        startupProjectService.setAcquisitionElements(projectId, acquisitionElements);
    }

    @DeleteMapping("/{id}")
    public void deleteStartupProject(@PathVariable Long id) {
        startupProjectService.deleteStartupProjectById(id);
    }


    @PostMapping("/{projectId}/activation_elements")
    public void setActivationElements(@RequestBody List<ActivationElement> activationElements,
            @PathVariable Long projectId) {
        startupProjectService.setActivationElements(projectId, activationElements);
    }

    @PostMapping("/{projectId}/retention_curve")
    public void setRetention(@RequestBody List<Float> retentionCurve,
            @PathVariable Long projectId) {
        startupProjectService.setRetentionCurve(projectId, retentionCurve);
    }

    @PostMapping("/{projectId}/referrals")
    public void setMonetization(@RequestBody Referral referral,
            @PathVariable Long projectId) {
        startupProjectService.setReferral(projectId, referral);
    }

    @PostMapping("/{projectId}/monetization")
    public void setMonetization(@RequestBody Monetization monetization,
            @PathVariable Long projectId) {
        startupProjectService.setMonetization(projectId, monetization);
    }

}

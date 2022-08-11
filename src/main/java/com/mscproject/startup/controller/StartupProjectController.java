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
import com.mscproject.startup.model.AcquisitionElement;
import com.mscproject.startup.model.StartupProject;

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

    @GetMapping("/{projectId}/acquisition_elements")
    public List<AcquisitionElement> getAcquisitionElements(@PathVariable Long projectId) {
        return userCategoryService.getAcquisitionElements(projectId);
    }

}

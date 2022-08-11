package com.mscproject.startup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mscproject.startup.repository.StartupProjectRepository;
import com.mscproject.startup.model.AcquisitionElement;
import com.mscproject.startup.model.AppUser;
import com.mscproject.startup.model.StartupProject;

@Service
public class StartupProjectService {

    @Autowired
    private StartupProjectRepository startupProjectRepository;

    @Autowired
    private AppUserService userService;

    public void createStartupProject(StartupProject startupProject) {
        AppUser user = userService.getUser();
        startupProject.setUser(user);
        startupProjectRepository.save(startupProject);
    }

    public StartupProject getStartupProjectById(Long id) {
        return startupProjectRepository.findById(id).get();
    }

    public void setAcquisitionElements(Long projectId, List<AcquisitionElement> acquisitionElements) {
        StartupProject startupProject = startupProjectRepository.findById(projectId).get();
        startupProject.setAcquisitionElements(acquisitionElements);
        startupProjectRepository.save(startupProject);
    }

    public List<AcquisitionElement> getAcquisitionElements(Long projectId) {
        StartupProject startupProject = startupProjectRepository.findById(projectId).get();
        return startupProject.getAcquisitionElements();
    }

    public List<StartupProject> getStartupProjectsOfUser() {
        AppUser user = userService.getUser();
        return startupProjectRepository.findByUser(user);
    }

}

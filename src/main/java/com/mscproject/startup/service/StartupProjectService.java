package com.mscproject.startup.service;

import java.util.List;

import com.mscproject.startup.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mscproject.startup.repository.StartupProjectRepository;

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

    public void setActivationElements(Long projectId, List<ActivationElement> activationElements) {
        StartupProject startupProject = startupProjectRepository.findById(projectId).get();
        startupProject.setActivationElements(activationElements);
        startupProjectRepository.save(startupProject);
    }

    public void setRetentionCurve(Long projectId, List<Float> retentionCurve) {
        StartupProject startupProject = startupProjectRepository.findById(projectId).get();
        startupProject.setRetentionCurve(retentionCurve);
        startupProjectRepository.save(startupProject);
    }

    public void setReferral(Long projectId, Referral referral) {
        StartupProject startupProject = startupProjectRepository.findById(projectId).get();
        startupProject.setReferrals(referral);
        startupProjectRepository.save(startupProject);
    }

    public void setMonetization(Long projectId, Monetization monetization) {
        StartupProject startupProject = startupProjectRepository.findById(projectId).get();
        startupProject.setMonetization(monetization);
        startupProjectRepository.save(startupProject);
    }

    public void deleteStartupProjectById(Long id) {
        startupProjectRepository.deleteById(id);
    }
}

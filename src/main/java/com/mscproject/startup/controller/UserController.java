package com.mscproject.startup.controller;

import com.mscproject.startup.model.StartupProject;
import com.mscproject.startup.service.AppUserService;
import com.mscproject.startup.service.StartupProjectService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Marks the class a rest controller
@RequestMapping("/api/user") // Requests made to /api/auth/anything will be handles by this class
@CrossOrigin
public class UserController {

    // Injecting Dependencies
    @Autowired
    private AppUserService appUserService;

    @Autowired
    private StartupProjectService startupProjectService;

    // Defining the function to handle the GET route to fetch user information of
    // the authenticated user
    @GetMapping("/info")
    public String getUsername() {
        return appUserService.getUsername();
    }

    @GetMapping("/projects")
    public List<StartupProject> getStartupProjects() {
        return startupProjectService.getStartupProjectsOfUser();
    }

    @PostMapping("/add_project")
    public void add_project(@RequestBody StartupProject startupProject) {
        startupProjectService.createStartupProject(startupProject);
    }

}

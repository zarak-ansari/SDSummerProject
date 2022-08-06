package com.mscproject.startup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mscproject.startup.service.UserCategoryService;
import com.mscproject.startup.model.AcquisitionElement;
import com.mscproject.startup.model.UserCategory;

@RestController
@RequestMapping("api/user_category")
public class UserCategoryController {

    @Autowired
    private UserCategoryService userCategoryService;

    @PostMapping
    public void createUserCategory(@RequestBody UserCategory userCategory) {
        userCategoryService.createUserCategory(userCategory);
    }

    @GetMapping
    public UserCategory getUserCategory() {
        return userCategoryService.getUserCategory();
    }

    @PostMapping("/acquisition_elements")
    public void setAcquisitionElements(@RequestBody List<AcquisitionElement> acquisitionElements) {
        userCategoryService.setAcquisitionElements(acquisitionElements);
    }

    @GetMapping("/acquisition_elements")
    public List<AcquisitionElement> getAllAcquisitionElements() {
        return userCategoryService.getAllAcquisitionElements();
    }

}

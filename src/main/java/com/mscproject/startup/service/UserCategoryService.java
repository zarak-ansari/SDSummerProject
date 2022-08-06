package com.mscproject.startup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mscproject.startup.repository.UserCategoryRepository;
import com.mscproject.startup.model.AcquisitionElement;
import com.mscproject.startup.model.UserCategory;

@Service
public class UserCategoryService {

    @Autowired
    private UserCategoryRepository userCategoryRepository;

    public void setAcquisitionElements(List<AcquisitionElement> acquisitionElements) {
        UserCategory userCategory = userCategoryRepository.findAll().iterator().next();
        userCategory.setAcquisitionElements(acquisitionElements);
        userCategoryRepository.save(userCategory);
    }

    public List<AcquisitionElement> getAllAcquisitionElements() {
        return userCategoryRepository.findAll().iterator().next().getAcquisitionElements();

        // AcquisitionElement element0 = new AcquisitionElement(0L, "first element
        // name", "first description", 100,
        // 10, 1);
        // AcquisitionElement element1 = new AcquisitionElement(0L, "second element
        // name", "second description", 1000,
        // 100, 10);
        // return List.of(element0, element1);
    }

    public void createUserCategory(UserCategory userCategory) {
        userCategoryRepository.save(userCategory);
    }

    public UserCategory getUserCategory() {
        return userCategoryRepository.findAll().iterator().next();
    }

}

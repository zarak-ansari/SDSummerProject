package com.mscproject.startup.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mscproject.startup.model.UserCategory;

@Repository
public interface UserCategoryRepository extends PagingAndSortingRepository<UserCategory, Long> {

}

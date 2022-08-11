package com.mscproject.startup.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mscproject.startup.model.AppUser;
import com.mscproject.startup.model.StartupProject;

@Repository
public interface StartupProjectRepository extends JpaRepository<StartupProject, Long> {

    List<StartupProject> findByUser(AppUser user);

}

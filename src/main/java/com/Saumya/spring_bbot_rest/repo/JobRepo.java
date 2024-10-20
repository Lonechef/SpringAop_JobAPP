package com.Saumya.spring_bbot_rest.repo;

import com.Saumya.spring_bbot_rest.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<JobPost,Integer> {
    //Now creating for if you are searching by keyword
    List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile, String postDesc);


    }



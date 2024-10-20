package com.Saumya.spring_bbot_rest;

import com.Saumya.spring_bbot_rest.model.JobPost;
import com.Saumya.spring_bbot_rest.repo.JobRepo;
import com.Saumya.spring_bbot_rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping("jobPosts")

    public List<JobPost> getAllJons(){
    //So in this we just need to return all the jobs
        return jobService.getAllJobs();
    }
    @GetMapping("jobPost/{postId}")
    //Now in this we just need one JobPost according to it's id
    public JobPost getJob(@PathVariable int postId){
        return jobService.getJob(postId);
    }
    @PostMapping("jobPost")
    public JobPost addJob(@RequestBody JobPost jobPost){
        jobService.addJob(jobPost);
        return jobService.getJob(jobPost.getPostId());
    }
    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        jobService.updateJob(jobPost);
        return jobService.getJob(jobPost.getPostId());
    }
    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable int postId){
        jobService.deleteJob(postId);
        return "The Job for profile id: " + postId +" has been removed";
    }

    @GetMapping("load")
    public String LoadData(){
        jobService.load();
        return "Data added to DB successfully";
    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchbykeyword(@PathVariable("keyword") String keyword){
        return jobService.search(keyword);
    }
}

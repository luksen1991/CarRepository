package com.example.CarService.REST;

import com.example.CarService.Domain.Issue;
import com.example.CarService.Repository.IssueRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/issue")
public class IssueRESTController {


    @Autowired
    IssueRepositoryImpl issueRepository;

    @GetMapping("/findIssue/{id}")
    public Issue getIssueById(@PathVariable("id") int id){
        return issueRepository.findIssueById(id);
    }

    @GetMapping("/deleteIssue/{id}")
    public void deleteIssueById(@PathVariable("id") int id){
        issueRepository.deleteById(id);
    }

    @GetMapping("/getAllIssues")
    public List<Issue> gtAllIssues(){
        return issueRepository.findAll();
    }

    @PostMapping("/addIssue")
    public Issue addNewIssue(@RequestBody Issue issue){
        return issueRepository.addIssue(issue);
    }

}

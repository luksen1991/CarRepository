package com.example.CarService.Repository;

import com.example.CarService.CarServiceApplication;
import com.example.CarService.Domain.Issue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestBody;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CarServiceApplication.class)
public class IssueRepositoryImplTest {

    @Autowired
    IssueRepositoryImpl issueRepository;

    @Test
    @DirtiesContext
    public void addIssue() {

        Issue issue = issueRepository.findIssueById(6);
        issue.setCarModel("Audi Q8 2018 - UPDATES");

        issueRepository.addIssue(issue);

        Issue issueTemp = issueRepository.findIssueById(6);
        assertEquals("Audi Q8 2018 - UPDATES",issueTemp.getCarModel());

    }

    @Test
    public void findIssueById() {
        Issue issue = issueRepository.findIssueById(6);
        assertEquals("DKL123",issue.getRegisterNumber());
        assertEquals(6,issue.getId());
    }

    @Test
    public void updateIssue() {
    }

    @Test
    @DirtiesContext
    public void deleteById() {
        issueRepository.deleteById(5);
        assertNull(issueRepository.findIssueById(5));
    }

    @Test
    public void findAll() {
    }

    @Test
    public void playWithEntityManagerTest() {
        issueRepository.playWithEntityManager();

    }
}
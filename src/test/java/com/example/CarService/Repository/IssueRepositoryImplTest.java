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

        Issue issue1 = new Issue("Tytul","Audi A8","DKL123","Adam Adam","Zapsulo sie",null);
        Issue issue2 = new Issue("Tytul","Audi A8","DKL12","Adam Adam1","Zapsulo sie",null);
        Issue issue3 = new Issue("Tytul","Audi A8","DKL12345","Adam Adam2","Zapsulo sie",null);
        Issue issue4 = new Issue("Tytul","Audi A8","DKL1234","Adam Adam3","Zapsulo sie",null);

        issueRepository.addIssue(issue1);
        issueRepository.addIssue(issue2);
        issueRepository.addIssue(issue3);
        issueRepository.addIssue(issue4);

        Issue issue = issueRepository.findIssueById(9);
        issue.setCarModel("Audi Q8 2018 - UPDATES");

        issueRepository.addIssue(issue);

        Issue issueTemp = issueRepository.findIssueById(9);
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
    @DirtiesContext // Guarentee that data wil rollback. It's a very good option when more than one people work in one class.
    public void deleteById() {
        issueRepository.deleteById(14);
        assertNull(issueRepository.findIssueById(14));
    }

    @Test
    public void findAll() {
    }

    @Test
    public void playWithEntityManagerTest() {
        issueRepository.playWithEntityManager();

    }
}
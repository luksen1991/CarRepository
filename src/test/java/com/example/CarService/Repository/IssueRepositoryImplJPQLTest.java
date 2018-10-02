package com.example.CarService.Repository;

import com.example.CarService.CarServiceApplication;
import com.example.CarService.Domain.Issue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.NoResultException;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.intThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CarServiceApplication.class)
public class IssueRepositoryImplJPQLTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    IssueRepositoryImplJPQL issueRepositoryImplJPQL;

    @Test
    public void findIssueById_basicTest() {
        Issue issue = issueRepositoryImplJPQL.findIssueById(14);
        assertEquals(14,issue.getId());
        assertEquals("DKO123",issue.getRegisterNumber());
    }

    @Test
    public void findAllBasicTest(){
        List<Issue> issueList = issueRepositoryImplJPQL.findAll();
        Issue issue = issueList.get(issueList.size()-1);
        assertEquals(4,issueList.size());
        assertEquals(14,issue.getId());
    }

    @Test(expected = NoResultException.class)
    public void deleteRecordBasic(){
        int chosenRecord = 13 ;
        Issue issue = issueRepositoryImplJPQL.findIssueById(chosenRecord);
        assertEquals(chosenRecord,issue.getId());
        issueRepositoryImplJPQL.deleteById(chosenRecord);
        when(issueRepositoryImplJPQL.findIssueById(chosenRecord)).thenReturn(null);
        assertEquals(issueRepositoryImplJPQL.findIssueById(chosenRecord),null);
    }

}
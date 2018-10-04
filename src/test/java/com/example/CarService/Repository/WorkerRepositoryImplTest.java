package com.example.CarService.Repository;

import com.example.CarService.CarServiceApplication;
import com.example.CarService.Domain.Issue;
import com.example.CarService.Domain.Worker;
import com.example.CarService.Utils.HibernateUtil;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.exceptions.misusing.MissingMethodInvocationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CarServiceApplication.class)
public class WorkerRepositoryImplTest{

    @Autowired
    WorkerRepositoryImpl workerRepository;

    @Autowired
    IssueRepositoryImpl issueRepository;


    @Test
    @DirtiesContext
    public void addWorkerWithoutIssue(){

        Worker worker = new Worker();
        worker.setFirstName("Adam");
        worker.setSecondName("Pracownik333");
        worker.setPesl("1234567891");
        worker.setBirthDate(new Date());
        worker.setPosition("Szef");
        worker.setSex("M");

        workerRepository.addWorker(worker);
        assertEquals(2,workerRepository.findById(2).getId());

    }
    @Test
    @DirtiesContext
    public void addWorkerOneIssue() {

        int expectedNumberWorkerInIssue = 1;
        int numberWorkerInIssue = 1;
       Worker worker = new Worker();
       worker.setFirstName("Adam");
       worker.setSecondName("Pracownik");
       worker.setPesl("123456789");
       worker.setBirthDate(new Date());
       worker.setPosition("Pracownik");
       worker.setSex("M");

       Issue issue = new Issue();
       issue.setTitle("Wymiana sprzegla");
       issue.setCarModel("Audi A8");
       issue.setRegisterNumber("DLZ123");
       issue.setClientName("Adam Popowski");
       issue.setIssueDescription("Do wymiany cale sprzeglo");
       issue.setWorker(worker);

        List<Issue> listIssue = new ArrayList<>();
        listIssue.add(issue);
        worker.setIssueList(listIssue);
       workerRepository.addWorker(worker);
       issueRepository.addIssue(issue);
       assertEquals(expectedNumberWorkerInIssue,worker.getIssueList().size());
       assertEquals(numberWorkerInIssue,worker.getIssueList().get(worker.getIssueList().size()-1).getId());

     }

    @Test
    @DirtiesContext
    public void addWorkerMoreThanOneIssue() {

        int expectedNumberWorkerInIssue = 2;
        int numberWorkerInIssue =2;

        Worker worker = new Worker();
        worker.setFirstName("Adam");
        worker.setSecondName("Pracownik23");
        worker.setPesl("123456789");
        worker.setBirthDate(new Date());
        worker.setPosition("Pracownik");
        worker.setSex("M");

        Issue issue = new Issue();
        issue.setTitle("Wymiana sprzegla2");
        issue.setCarModel("Audi A8");
        issue.setRegisterNumber("DLZ123");
        issue.setClientName("Adam Popowski13");
        issue.setIssueDescription("Do wymiany cale sprzeglo");
        issue.setWorker(worker);

        Issue issue2 = new Issue();
        issue2.setTitle("Wymiana oleju2");
        issue2.setCarModel("Audi A8");
        issue2.setRegisterNumber("DLZ123");
        issue2.setClientName("Adam Popowski2");
        issue2.setIssueDescription("Do wymiany cale sprzeglo");
        issue2.setWorker(worker);

        List<Issue> listIssue = new ArrayList<>();
        listIssue.add(issue);
        listIssue.add(issue2);
        worker.setIssueList(listIssue);
        workerRepository.addWorker(worker);
        issueRepository.addIssue(issue);
        issueRepository.addIssue(issue2);
        assertEquals(expectedNumberWorkerInIssue,worker.getIssueList().size());
        assertEquals(numberWorkerInIssue,worker.getIssueList().get(worker.getIssueList().size()-1).getId());

    }

    @Test
    @DirtiesContext
    public void addIssueToWorker(){

        Issue issue = new Issue();
        issue = issueRepository.findIssueById(1);

        Issue issue2 = new Issue();
        issue2 = issueRepository.findIssueById(2);

        Worker worker = new Worker();
        worker= workerRepository.findById(2);

        assertEquals(2,worker.getId());
        assertEquals(1,issue.getId());
        assertEquals(2,issue2.getId());

        issue.setWorker(worker);
        issueRepository.addIssue(issue);

        issue2.setWorker(worker);
        issueRepository.addIssue(issue2);

        assertEquals(2,issue.getWorker().getId());
        assertEquals(2,issue2.getWorker().getId());
    }

    @Test
    public void getAllWorkers(){
        int expectedValue = 1;
        List<Worker> workerList = workerRepository.getAllWorkers();
        for (Worker worker:workerList) {
            System.out.println(worker.getId());
        }
        assertEquals(expectedValue,workerList.size());
    }

    @Test(expected = MissingMethodInvocationException.class)
    @DirtiesContext
    public void removeWorkerFromDatabase(){
        int expectedValue = 1;
        workerRepository.removeWorker(expectedValue);
        when(workerRepository.findById(expectedValue)).thenReturn(null);
        assertEquals(workerRepository.findById(expectedValue),null);

    }
}
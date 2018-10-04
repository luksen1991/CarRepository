package com.example.CarService.Repository;

import com.example.CarService.Domain.Issue;
import com.example.CarService.Domain.Worker;
import com.example.CarService.Utils.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class WorkerRepositoryImpl {

    @Autowired
    IssueRepositoryImpl issueRepository;

    public Worker addWorker(Worker worker) {
        HibernateUtil.initManager();
        if(worker.getId()==0){
            HibernateUtil.getEntityManager().persist(worker);
        }else{
            HibernateUtil.getEntityManager().merge(worker);
        }
        HibernateUtil.shutdown();

        return worker;
    }

    public Worker findById(int i) {
       return HibernateUtil.getEntityManager().find(Worker.class,i);
    }

    public List<Worker> getAllWorkers() {
        Query query = HibernateUtil.getEntityManager().createQuery("SELECT worker FROM Worker worker");
        return query.getResultList();
    }

    public void removeWorker(int i) {
        Worker worker = findById(i);
        List<Issue> issueList = worker.getIssueList();
        for (Issue issue:issueList) {
            issue.setWorker(null);
            issueRepository.addIssue(issue);
        }
        String id = Integer.toString(i);
        HibernateUtil.initManager();
        HibernateUtil.getEntityManager().clear();
        HibernateUtil.getEntityManager().createQuery("DELETE FROM Worker worker WHERE id= "+id).executeUpdate();
        HibernateUtil.shutdown();
    }
}

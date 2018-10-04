package com.example.CarService.Repository;

import com.example.CarService.Domain.Issue;
import com.example.CarService.Utils.HibernateUtil;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class IssueRepositoryImpl{

    public Issue addIssue(Issue issue) {
        HibernateUtil.initManager();
        if(issue.getId()==0){
            HibernateUtil.getEntityManager().persist(issue);
        }else{
            HibernateUtil.getEntityManager().merge(issue);
        }
        HibernateUtil.shutdown();
        return issue;
    }

    public Issue findIssueById(int id){
      return HibernateUtil.getEntityManager().find(Issue.class,id);
    }

    public Issue updateIssue(Issue issue){
        HibernateUtil.initManager();
        HibernateUtil.getEntityManager().merge(issue);
        HibernateUtil.shutdown();
        return issue;
    }

    public void deleteById(int id){
        String Id = Integer.toString(id);
        HibernateUtil.initManager();
        HibernateUtil.getEntityManager().createQuery("DELETE FROM Issue issue WHERE id=" + Id).executeUpdate();
        HibernateUtil.shutdown();
    }

    public List<Issue> findAll(){
        Query issues = HibernateUtil.getEntityManager().createQuery("SELECT issue FROM Issue issue",Issue.class);
        List<Issue> listIssues = issues.getResultList();
        return listIssues;
    }

    public void playWithEntityManager(){
//
//        HibernateUtil.initManager();
//        Issue issue = new Issue("Uszkodzony silnik","Audi Q11","DSD123","Adam Klaster", "Auto nie odpala");
//        Issue issue2 = new Issue("Uszkodzone drzwi","Audi A66", "DKO123","Adam Poter", "Drzwi nie otwieraja sie");
//        HibernateUtil.getEntityManager().persist(issue);
//        HibernateUtil.getEntityManager().persist(issue2);
//
//        HibernateUtil.getEntityManager().flush();
//        HibernateUtil.getEntityManager().clear();
//
//        issue.setCarModel("Audi Q3");
//        HibernateUtil.getEntityManager().flush();
//
//        issue2.setCarModel("Audi A8");
//        HibernateUtil.getEntityManager().flush();
//
//        HibernateUtil.shutdown();

    }
}

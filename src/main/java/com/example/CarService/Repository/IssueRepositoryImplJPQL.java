package com.example.CarService.Repository;

import com.example.CarService.Domain.Issue;
import com.example.CarService.Utils.HibernateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class IssueRepositoryImplJPQL {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

//    public Issue addIssue(Issue issue) {
//
//    }

    public Issue findIssueById(int id){
        TypedQuery<Issue> issueResult = HibernateUtil.getEntityManager().createQuery("SELECT issue FROM Issue issue WHERE issue.id= :id",Issue.class);
        logger.info("Select issue from Issue issue where issue.id=id: RESULT: ",issueResult);
        issueResult.setParameter("id",id);
        Issue issue = issueResult.getSingleResult();
        return issue;


    }

//    public Issue updateIssue(Issue issue){
//
//    }
//
    public void deleteById(int id){
        String Id = Integer.toString(id);
        HibernateUtil.initManager();
        HibernateUtil.getEntityManager().createQuery("DELETE FROM Issue issue WHERE id=" + Id).executeUpdate();
        HibernateUtil.shutdown();
    }
//
    public List<Issue> findAll(){
        Query issues = HibernateUtil.getEntityManager().createQuery("SELECT issue FROM Issue issue",Issue.class);
        List<Issue> listIssues = issues.getResultList();
        return listIssues;
    }
}

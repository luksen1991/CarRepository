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
        TypedQuery<Issue> issueResult = HibernateUtil.getEntityManager().createNamedQuery("get_by_id",Issue.class);
        logger.info("Select issue from Issue issue where issue.id=id: RESULT: ",issueResult);
        issueResult.setParameter("id",id);
        Issue issue = issueResult.getSingleResult();
        return issue;


    }

    public List<Issue> getIssueNativeQuery(String registrationNumber){

        Query query = HibernateUtil.getEntityManager().createNativeQuery("SELECT * FROM CarServic.issue WHERE CarServic.issue.RegisterNumber= :registerNumber",Issue.class);
        query.setParameter("registerNumber",registrationNumber);
        List<Issue> issueList = query.getResultList();
        return issueList;

    }
//
    public void deleteById(int id){
        String Id = Integer.toString(id);
        HibernateUtil.initManager();
        HibernateUtil.getEntityManager().createQuery("DELETE FROM Issue issue WHERE id=" + Id).executeUpdate();
        HibernateUtil.shutdown();
    }
//
    public List<Issue> findAll(){
        Query issues = HibernateUtil.getEntityManager().createNamedQuery("query_get_all",Issue.class);
        List<Issue> listIssues = issues.getResultList();
        return listIssues;
    }
}

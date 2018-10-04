package com.example.CarService.Domain;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.springframework.boot.jackson.JsonComponent;


@Entity
@Table(name="worker")
public class Worker {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="secondName")
	private String secondName;
	
	@Column(name="PESEL")
	private String pesl;
	
	@Column(name="Sex")
	private String sex;
	
	@Column(name="BithDate")
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	
	@Column(name="Position")
	private String position;

	@OneToMany(mappedBy = "worker",cascade = CascadeType.REMOVE,orphanRemoval = true)
	private List<Issue> issueList;



	public Worker(){}

	public Worker(String firstName, String secondName, String pesl, String sex, Date birthDate, String position, List<Issue> issueList) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.pesl = pesl;
		this.sex = sex;
		this.birthDate = birthDate;
		this.position = position;
		this.issueList = issueList;
	}

	public List<Issue> getIssueList() {
		return issueList;
	}

	public void setIssueList(List<Issue> issueList) {
		this.issueList = issueList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getPesl() {
		return pesl;
	}

	public void setPesl(String pesl) {
		this.pesl = pesl;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
}

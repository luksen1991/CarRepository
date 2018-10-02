package com.example.CarService.Domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	
//	@OneToMany(mappedBy="worker",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
//	private List<Issue> listIssues;
}

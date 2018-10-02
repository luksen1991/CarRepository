package com.example.CarService.Domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="issue")
public class Issue {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="Title")
	private String title;
	
	@Column(name="CarModel")
	private String carModel;
	
	@Column(name="RegisterNumber")
	private String registerNumber;
	
	@Column(name="ClientName")
	private String clientName;
	
	@Column(name="IssueDescription")
	private String issueDescription;
	
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="workerid")
//	private Worker worker;

	protected Issue(){};

	public Issue(String title, String carModel, String registerNumber, String clientName, String issueDescription) {
		this.title = title;
		this.carModel = carModel;
		this.registerNumber = registerNumber;
		this.clientName = clientName;
		this.issueDescription = issueDescription;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getRegisterNumber() {
		return registerNumber;
	}

	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getIssueDescription() {
		return issueDescription;
	}

	public void setIssueDescription(String issueDescription) {
		this.issueDescription = issueDescription;
	}
	
	
		
	
}

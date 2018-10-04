package com.example.CarService.Domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@NamedQueries(value = {
		@NamedQuery(name = "query_get_all",query = "SELECT issue FROM Issue issue"),
		@NamedQuery(name = "get_by_id", query = "SELECT issue FROM Issue issue WHERE issue.id= :id")
})
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

	@ManyToOne()
    private Worker worker;


    public Issue(){};

    public Issue(String title, String carModel, String registerNumber, String clientName, String issueDescription, Worker worker) {
        this.title = title;
        this.carModel = carModel;
        this.registerNumber = registerNumber;
        this.clientName = clientName;
        this.issueDescription = issueDescription;
        this.worker = worker;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
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

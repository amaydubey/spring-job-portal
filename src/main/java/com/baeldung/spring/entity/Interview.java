package com.baeldung.spring.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="interview")
public class Interview {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name ="ID", unique = true, nullable = false)
	private int ID;
//	
//	@Column(name ="jobId")
//	private int jobId;
	
	@Column(name ="company")
	private String company;
	
	@Column(name ="jobseekerid")
	private int jobseekerid;
	
	@Column(name ="location")
	private String location;
	
	
	public int getJobseekerid() {
		return jobseekerid;
	}

	public void setJobseekerid(int jobseekerid) {
		this.jobseekerid = jobseekerid;
	}

	@Column(name ="datetime")
	private String datetime;
	
	@Column(name ="flag")
	private String flag;
	
	public String isFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public int getId() {
		return ID;
	}

	public void setId(int id) {
		ID = id;
	}

//	public int getJobId() {
//		return jobId;
//	}
//
//	public void setJobId(int jobId) {
//		this.jobId = jobId;
//	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	

}

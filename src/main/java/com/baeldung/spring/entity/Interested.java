package com.baeldung.spring.entity;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="interested")
public class Interested{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name ="ID", unique = true, nullable = false)
	private int ID;
	
	@Column(name ="jobId")
	private int jobId;
	
	@Column(name ="jobSeekerId")
	private int jobSeekerId;
	
	public int getId() {
		return ID;
	}

	public void setId(int id) {
		ID = id;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public int getJobSeekerId() {
		return jobSeekerId;
	}

	public void setJobSeekerId(int jobSeekerId) {
		this.jobSeekerId = jobSeekerId;
	}

	
	
	
	
	
}

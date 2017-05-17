package com.baeldung.spring.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author amayd
 *
 */
@Entity
@Table(name = "jobposting")
public class JobPosting {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "jobId", unique = true, nullable = false)
	private int jobId;

	@ManyToOne
	@JoinColumn(name = "companyId")
	private Company company;

	@Column(name = "state")
	private int state;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "responsibilities")
	private String responsibilties;

	@Column(name = "location")
	private String location;

	@Column(name = "salary")
	private String salary;

	// @OneToMany(mappedBy="passenger", cascade = CascadeType.ALL)
	// @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,
	// property="orderId")
	// private List<Reservation> reservations;

	/**
	 * @return Jid of the job
	 */
	public int getJobId() {
		return jobId;
	}

	/**
	 * @param jobId
	 */
	public void setjobId(int jobId) {
		this.jobId = jobId;
	}

	/**
	 * @return Company
	 */
	public Company getCompany() {
		return company;
	}

	/**
	 * @param company
	 */
	public void setCompany(Company company) {
		this.company = company;
	}

	/**
	 * @return State of Job
	 */
	public int getState() {
		return state;
	}

	/**
	 * @param State
	 * 
	 */
	public void setState(int State) {
		this.state = State;
	}

	/**
	 * @return Title of the job
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param Title
	 * 
	 */
	public void setTitle(String Title) {
		this.title = Title;
	}

	/**
	 * @return Responsibilities on the job
	 */
	public String getResponsibilities() {
		return responsibilties;
	}

	/**
	 * @param Responsibilities
	 */
	public void setResponsibilities(String Responsibilities) {
		this.responsibilties = Responsibilities;
	}

	/**
	 * @return Description of the job
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param Description
	 * 
	 */
	public void setDescription(String Description) {
		this.description = Description;
	}

	/**
	 * @return Location of the job
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param Location
	 *            of the job
	 */
	public void setLocation(String Location) {
		this.location = Location;

	}

	/**
	 * @return Salary on the job
	 */
	public String getSalary() {
		return salary;
	}

	/**
	 * @param Salary
	 */
	public void setSalary(String Salary) {
		this.salary = Salary;
	}

}
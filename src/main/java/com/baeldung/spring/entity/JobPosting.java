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
	private int State;
	
	@Column(name = "title")
	private String Title;
	
	@Column(name = "description")
	private String Description;
	
	@Column(name = "responsibilities")
	private String Responsibilties;
	
	@Column(name = "location")
	private String Location;
	
	@Column(name = "salary")
	private String Salary;

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
		return State;
	}

	/**
	 * @param State
	 * 
	 */
	public void setState(int State) {
		this.State = State;
	}

	/**
	 * @return Title of the job
	 */
	public String getTitle() {
		return Title;
	}

	/**
	 * @param Title
	 * 
	 */
	public void setTitle(String Title) {
		this.Title = Title;
	}

	/**
	 * @return Responsibilities on the job
	 */
	public String getResponsibilities() {
		return Responsibilties;
	}

	/**
	 * @param Responsibilities
	 */
	public void setResponsibilities(String Responsibilities) {
		this.Responsibilties = Responsibilities;
	}

	/**
	 * @return Description of the job
	 */
	public String getDescription() {
		return Description;
	}

	/**
	 * @param Description
	 * 
	 */
	public void setDescription(String Description) {
		this.Description = Description;
	}

	/**
	 * @return Location of the job
	 */
	public String getLocation() {
		return Location;
	}

	/**
	 * @param Location
	 *            of the job
	 */
	public void setLocation(String Location) {
		this.Location = Location;

	}

	/**
	 * @return Salary on the job
	 */
	public String getSalary() {
		return Salary;
	}

	/**
	 * @param Salary
	 */
	public void setSalary(String Salary) {
		this.Salary = Salary;
	}
	
	
	
	

}
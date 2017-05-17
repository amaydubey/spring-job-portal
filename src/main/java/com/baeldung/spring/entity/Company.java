/**
 * 
 */
package com.baeldung.spring.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author amayd
 *
 */
@Entity
@Table(name = "company")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "companyId", unique = true, nullable = false)
	private int companyId;
	
	@Column(name="companyName")
	private String companyName;
	
	@Column(name="headquarters")
	private String headquarters;
	
	@Column(name="companyUser")
	private String companyUser;
	
	@Column(name="password")
	private String password;
	
	@Column(name="description")
	private String description;

	/**
	 * @return CompanyId
	 */
	public int getCompanyId() {
		return companyId;
	}

	/**
	 * @param companyId
	 */
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	/**
	 * @return Company Name
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return Headquarters of the company
	 */
	public String getHeadquarters() {
		return headquarters;
	}

	/**
	 * @param headquarters
	 */
	public void setHeadquarters(String headquarters) {
		this.headquarters = headquarters;
	}

	/**
	 * @return Company Username for accessing the application
	 */
	public String getCompanyUser() {
		return companyUser;
	}

	/**
	 * @param companyUser
	 */
	public void setCompanyUser(String companyUser) {
		this.companyUser = companyUser;
	}

	/**
	 * @return Password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return Description of the company
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            of the company
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}

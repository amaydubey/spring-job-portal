package com.baeldung.spring.dao;

import java.util.List;

import com.baeldung.spring.entity.Company;

/**
 * @author amayd
 *
 */
public interface CompanyDao {
	
	
	/**
	 * @param emailid
	 * @return password for the given emailId
	 */
	public List<String> PasswordLookUp(String emailid);
	
	/**
	 * @param com
	 * @return Created company
	 * @throws Exception
	 */
	public Company createCompany(Company com) throws Exception;

	/**
	 * @param js
	 * @return Updated company
	 */
	public Company updateCompany(Company js);

	/**
	 * @param id
	 * @return Company
	 */
	public Company getCompany(int id);
	
	/**
	 * @param c
	 */
	public void verify(Company c);
	
	/**
	 * @param companyId
	 * @param state
	 * @return List of jobs according to the state
	 */
	public List<?> getJobsByCompany(int companyId);

	/**
	 * @param emailid
	 * @return
	 */
	public List<Integer> getCompanyIdFromEmail(String emailid);
	
	

}

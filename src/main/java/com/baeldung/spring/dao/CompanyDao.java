package com.baeldung.spring.dao;

import java.util.List;

import com.baeldung.spring.entity.Company;

public interface CompanyDao {
	
	
	/**
	 * @param emailid
	 * @return
	 */
	public List<String> PasswordLookUp(String emailid);
	
	/**
	 * @param com
	 * @return
	 * @throws Exception
	 */
	public Company createCompany(Company com) throws Exception;

	/**
	 * @param js
	 * @return
	 */
	public Company updateCompany(Company js);

	/**
	 * @param id
	 * @return
	 */
	public Company getCompany(int id);
	
	/**
	 * @param c
	 * @return
	 */
	public void verify(Company c);
	
	

}

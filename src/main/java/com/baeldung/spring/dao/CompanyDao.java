package com.baeldung.spring.dao;

import java.util.List;

import com.baeldung.spring.entity.Company;

public interface CompanyDao {
	
	
	public List<String> PasswordLookUp(String emailid);
	
	public Company createCompany(Company com) throws Exception;
	
	

}

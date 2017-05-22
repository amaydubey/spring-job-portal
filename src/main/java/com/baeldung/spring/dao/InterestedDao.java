package com.baeldung.spring.dao;

import java.util.List;

import com.baeldung.spring.entity.Interested;

/**
 * @author amayd
 *
 */
public interface InterestedDao {
	
	
	/**
	 * @param com
	 * @return Created interest
	 * @throws Exception
	 */
	public Interested createInterest(Interested in) throws Exception;

	/**
	 * @param js
	 * @return Updated interest
	 */
	public boolean deleteInterest(int id);

	/**
	 * @param id
	 * @return Interest
	 */
	public Interested getInterest(int id);
	

	

}

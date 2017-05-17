/**
 * 
 */
package com.baeldung.spring.dao.impl;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baeldung.spring.dao.JobSeekerDao;

/**
 * @author amayd
 *
 */
@Repository
@Transactional
@Service
public class JobSeekerDaoImpl implements JobSeekerDao {
	
	@PersistenceContext
	private EntityManager entityManager;
}

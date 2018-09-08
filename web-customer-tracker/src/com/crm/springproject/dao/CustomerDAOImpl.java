package com.crm.springproject.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crm.springproject.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	//need to inject session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	// removed @Transactional annotation due to customer service implementation
	public List<Customer> getCustomers() {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName",
																Customer.class);
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		
		// return results
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save the customer
		currentSession.saveOrUpdate(theCustomer);	
	}

	@Override
	public Customer getCustomer(int theId) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//retrieve/read from the database using the primary key: intId
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		// return result
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete the customer with primary key: id
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();
		
	}

}

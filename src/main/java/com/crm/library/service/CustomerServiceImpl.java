package com.crm.library.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.crm.library.entity.Customer;



@Repository
public class CustomerServiceImpl implements CustomerService {
	
	
	
	private SessionFactory sessionFactory;
	private Session session;

	public CustomerServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = this.sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session= this.sessionFactory.openSession();

		}
	}
	
	@Transactional
	@Override
	public List<Customer> listAllCustomer() {
		List<Customer> customerList = session.createQuery("from Customer order by lastName").list();
		return customerList;
	}
	
	@Transactional
	@Override
	public Customer findCustomer(Integer customerId) {
		Customer customer = session.get(Customer.class,customerId);
		return customer;
	}

	@Transactional
	@Override
	public void saveCustomer(Customer customer) {
		Transaction tr = session.beginTransaction();
		session.saveOrUpdate(customer);
		tr.commit();
		
	}
	
	@Transactional
	@Override
	public void delete(Customer customer) {
		Transaction tr = session.beginTransaction();
		session.delete(customer);
		tr.commit();
	}

}

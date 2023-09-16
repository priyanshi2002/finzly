package com.finzly.fxTrading.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.finzly.fxTrading.CcyEntity.Ccy;
import com.finzly.fxTrading.CustomerEntity.Customer;

public class Dao {
	@Autowired
	SessionFactory sessionFactory;

	public String addingCcy(Ccy ccydata) {
		Session session = sessionFactory.openSession();
		session.save(ccydata);
		session.beginTransaction().commit();
		return "Ccy Added into the table.";
	}

	public List<Ccy> getAllCcyPairs() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Ccy.class);
		return criteria.list();
	}

	public String addExchanges(Customer customer) {
		Session session = sessionFactory.openSession();
		session.save(customer);
		session.beginTransaction().commit();
		return "The trade is successful.";
	}

	public List<Customer> getAllExchanges() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Customer.class);
		return criteria.list();
	}	

	
}

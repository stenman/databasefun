package com.example.databasefun;

import static org.junit.Assert.*;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCustomer extends AbstractTest {

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddCustomer() {
		EntityManager entityManager = Persistence.createEntityManagerFactory("tutorialPU").createEntityManager();

		entityManager.getTransaction().begin();

		Customer customer = new Customer();

		customer.setFirstName(Long.toString(new Date().getTime()));

		entityManager.persist(customer);

		entityManager.getTransaction().commit();

		// see that the ID of the customer was set by Hibernate
		System.out.println("user=" + customer + ", user.id=" + customer.getId());

		Customer foundCustomer = entityManager.find(Customer.class, customer.getId());

		// note that foundCustomer is the same instance as user and is a concrete class (not a proxy)
		System.out.println("foundCustomer=" + foundCustomer);

		assertEquals(customer.getFirstName(), foundCustomer.getFirstName());

		entityManager.close();
	}

}

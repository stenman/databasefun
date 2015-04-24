package com.example.databasefun;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.naming.java.javaURLContextFactory;
import org.hsqldb.jdbc.JDBCDataSource;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public abstract class AbstractTest {

	@BeforeClass
	public static void setUpClass() throws Exception {
		System.setProperty(Context.INITIAL_CONTEXT_FACTORY, javaURLContextFactory.class.getName());
		System.setProperty(Context.URL_PKG_PREFIXES, "org.apache.naming");
		InitialContext ic = new InitialContext();

		ic.createSubcontext("java:");
		ic.createSubcontext("java:comp");
		ic.createSubcontext("java:comp/env");
		ic.createSubcontext("java:comp/env/jdbc");

		JDBCDataSource ds = new JDBCDataSource();
		ds.setDatabaseName("embeddedDB");
		// create the database if it does not already exist
		// ds.setCreateDatabase("create");

		ic.bind("java:comp/env/jdbc/myDataSource", ds);
	}

	@AfterClass
	public static void tearDownClass() throws Exception {

		InitialContext ic = new InitialContext();

		ic.unbind("java:comp/env/jdbc/myDataSource");
	}
}

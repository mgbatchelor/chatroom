package com.mgbatchelor.nb.chatroom.services;

import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Contains all of the information to create a connection to the database. The
 * database information needs to be stored in a file name
 * 'datasource.properties' and must be present on the classpath. The connection
 * is initialized the first time it is needed (rather than at startup time).
 * 
 * @author michaelbatchelor
 * 
 */
public class ConnectionFactory {

	public static final ConnectionFactory instance = new ConnectionFactory();
	private static String JDBC_URL;
	private static String JDBC_USERNAME;
	private static String JDBC_PASSWORD;

	static {
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Could not load database driver.");
		}
		Properties dbProps = new Properties();
		try {
			dbProps.load(new InputStreamReader(ConnectionFactory.class
					.getClassLoader().getResourceAsStream(
							"datasource.properties")));
		} catch (IOException e) {
			throw new RuntimeException(
					"Could not load database connection properties.");
		}
		JDBC_URL = dbProps.getProperty("db.url");
		JDBC_USERNAME = dbProps.getProperty("db.username");
		JDBC_PASSWORD = dbProps.getProperty("db.password");
	}

	/**
	 * Get the instance of the factory.
	 * 
	 * @return
	 */
	public static ConnectionFactory getInstance() {
		return instance;
	}

	/**
	 * Get a new connection to the database.
	 * 
	 * @return
	 */
	public Connection getConnection() {
		Connection c = null;
		try {
			c = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME,
					JDBC_PASSWORD);
		} catch (SQLException e) {
			throw new RuntimeException(
					"Could not retreive database connection.", e);
		}
		return c;
	}

}

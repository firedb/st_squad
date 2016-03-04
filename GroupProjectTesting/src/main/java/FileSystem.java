package main.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FileSystem {

	// Grab list of Address Books in DB and return List of Names
	public static ArrayList<String> getAddressBooks() throws SQLException {
		ArrayList<String> books = new ArrayList<String>();
		Statement stmt;
		ResultSet rs = null;

		// Database Connection
		Connection conn = connectToDB();
		// if successful run statement
		if (connectToDB() != null) {
			stmt = conn.createStatement();
			rs = stmt
					.executeQuery("SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_TYPE = 'TABLE'");
		}

		// add table names to book list
		while (rs.next()) {
			books.add(rs.getString("TABLE_NAME"));
		}

		conn.close();
		return books;
	}

	// Get all the People and their IDs in an AddressBook
	public static ArrayList<Person> getPeople(String AddressBookName)
			throws SQLException {
		ArrayList<Person> people = new ArrayList<Person>();

		Statement stmt;
		ResultSet rs = null;
		// Database Connection
		Connection conn = connectToDB();
		// if successful run statement
		if (connectToDB() != null) {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM " + AddressBookName);
			// + " ORDER BY FIRSTNAME"
		}

		// add person to list
		while (rs.next()) {
			people.add(new Person(rs.getInt("ID"), rs.getString("firstName"),
					rs.getString("lastName"), rs.getString("address"), rs
							.getString("city"), rs.getString("state"), rs
							.getString("ZIP"), rs.getString("phone")));
		}
		conn.close();
		return people;

	}

	// Add a person to the Database
	public static boolean addPerson(String AddressBookName, String firstName,
			String lastName, String address, String city, String state,
			String ZIP, String phone) throws SQLException {
		PreparedStatement stmt;
		int rs = 0;
		// Database Connection
		Connection conn = connectToDB();
		// if successful run statement
		if (connectToDB() != null) {
			stmt = conn
					.prepareStatement("INSERT INTO "
							+ AddressBookName
							+ " "
							+ "(ID, FirstName, LastName, address, city, state, zip, phone) "
							+ "VALUES (NULL,?,?,?,?,?,?,?)");
			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			stmt.setString(3, address);
			stmt.setString(4, city);
			stmt.setString(5, state);
			stmt.setString(6, ZIP);
			stmt.setString(7, phone);
			rs = stmt.executeUpdate();
			// + " ORDER BY FIRSTNAME"
		}

		if (rs == 1) {
			return true;
		}
		return false;
	}

	// Add a person to the Database
	public static boolean updatePerson(String AddressBookName, int ID,
			String firstName, String lastName, String address, String city,
			String state, String ZIP, String phone) throws SQLException {
		Statement stmt;
		int rs = 0;
		// Database Connection
		Connection conn = connectToDB();
		// if successful run statement
		if (connectToDB() != null) {
			stmt = conn.createStatement();

			rs = stmt.executeUpdate("UPDATE " + AddressBookName
					+ " SET FirstName = '" + firstName + "', LastName = '"
					+ lastName + "', address = '" + address + "', city = '"
					+ city + "', state = '" + state + "', ZIP = '" + ZIP
					+ "', phone = '" + phone + "'  WHERE ID =" + ID);
			// + " ORDER BY FIRSTNAME"
		}

		if (rs == 1) {
			return true;
		}
		return false;
	}

	// Establish Connection to db
	public static Connection connectToDB() {

		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e1) {
			System.out.print("Missing org.h2.Driver!");
			e1.printStackTrace();
		}

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(
					"jdbc:h2:tcp://localhost/~/books", "sa", "");
		} catch (SQLException e) {
			System.out.print("URL to Database incorrect or not live");
			e.printStackTrace();
		}

		return conn;

	}

	public static boolean doesExist(String name) throws SQLException {
		Statement stmt;
		ResultSet rs = null;
		// Database Connection
		Connection conn = connectToDB();
		// if successful run statement
		if (connectToDB() != null) {
			stmt = conn.createStatement();
			rs = stmt
					.executeQuery(" SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_TYPE = 'TABLE' AND TABLE_NAME = '"
							+ name + "'");
		}

		rs.next();
		if (rs.getInt(1) > 0) {
			return true;
		}
		return false;
	}

	public static void createBook(String name) throws SQLException {
		Statement stmt;
		ResultSet rs = null;
		// Database Connection
		Connection conn = connectToDB();
		// if successful run statement
		if (connectToDB() != null) {
			stmt = conn.createStatement();
			rs = stmt
					.executeQuery("CREATE TABLE "
							+ name
							+ " (ID int NOT NULL AUTO_INCREMENT, FIRSTNAME VARCHAR(255), LASTNAME VARCHAR(255), ADDRESS VARCHAR(255), CITY VARCHAR(45), STATE VARCHAR(45), ZIP VARCHAR(10), PHONE VARCHAR(24), PRIMARY KEY (ID)");
		}
	}
}
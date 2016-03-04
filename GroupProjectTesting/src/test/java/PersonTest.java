package softwareTestingProject;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PersonTest {

	Person testPerson;
	
	@Before
	public void setUp() throws Exception {
		testPerson = new Person("John", "Smith", "123 fake street", "Town", "Florida", "33928", "555-555-5555");
		
	}

	@After
	public void tearDown() throws Exception {
		testPerson = null;
	}

	@Test
	public void testGetFirstName() {
		assertEquals("John", testPerson.getFirstName());
	}

	@Test
	public void testGetLastName() {
		assertEquals("Smith", testPerson.getLastName());
	}

	@Test
	public void testGetAddress() {
		assertEquals("123 fake street", testPerson.getAddress());
	}

	@Test
	public void testGetCity() {
		assertEquals("Town", testPerson.getCity());
	}

	@Test
	public void testGetState() {
		assertEquals("Florida", testPerson.getState());
	}

	@Test
	public void testGetZIP() {
		assertEquals("33928", testPerson.getZIP());
	}

	@Test
	public void testGetPhone() {
		assertEquals("555-555-5555", testPerson.getPhone());
	}

	//Test by creating a person and checking all values were saved properly
	@Test
	public void testPerson() {
		Person jane = new Person("Jane", "Snow", "456 fake street", "Town", "Florida", "33928", "111-111-1111");
		assertEquals("Jane", jane.getFirstName());
		assertEquals("Snow", jane.getLastName());
		assertEquals("456 fake street", jane.getAddress());
		assertEquals("Florida", jane.getState());
		assertEquals("33928", jane.getZIP());
		assertEquals("111-111-1111", jane.getPhone());
	
		
	}

}

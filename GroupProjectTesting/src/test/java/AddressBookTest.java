package test.java;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import main.java.*;


public class AddressBookTest {

	@Test
	public void testAdd() {
		AddressBook book= new AddressBook();
		Person jane = new Person("Jane", "Snow", "456 fake street", "Town", "Florida", "33928", "111-111-1111");
		book.Add(jane);
		Assert.assertEquals(book.getAddresses().contains(jane), true);
	}
	
	@Test
	public void testDelete() {
		AddressBook book= new AddressBook();
		Person jane = new Person("Jane", "Snow", "456 fake street", "Town", "Florida", "33928", "111-111-1111");
		book.Add(jane);
		book.Delete(jane);
		Assert.assertEquals(book.getAddresses().contains(jane), false);
	}
	
	@Test
	public void testSortZIP() {
		Person a= new Person("Carl","Carlson",null,null,null,"55555",null);
		Person b= new Person("Brian","Berriman",null,null,null,"00002",null);
		Person c= new Person("Adam","Adamson",null,null,null,"11111",null);
		AddressBook book= new AddressBook();
		
		//Sorted incorrectly
		book.Add(a);
		book.Add(b);
		book.Add(c);
		
		//Sorted correctly
		AddressBook book2= new AddressBook();
		book2.Add(b);
		book2.Add(c);
		book2.Add(a);
		
		//Sort the incorrect one and now they should be the same
		book.SortZip();
		
		Assert.assertEquals(book.getAddresses(), book2.getAddresses());
		
		
		
		
	}
	
	@Test
	public void testSortName() {
		Person a= new Person("Carl","Carlson",null,null,null,"55555",null);
		Person b= new Person("Brian","Berriman",null,null,null,"00002",null);
		Person c= new Person("Adam","Adamson",null,null,null,"11111",null);
		AddressBook book= new AddressBook();
		
		//Sorted incorrectly
		book.Add(a);
		book.Add(b);
		book.Add(c);
		
		//Sorted correctly
		AddressBook book2= new AddressBook();
		book2.Add(c);
		book2.Add(b);
		book2.Add(a);
		
		//Sort the incorrect one and now they should be the same
		book.SortName();
		
		Assert.assertEquals(book.getAddresses(), book2.getAddresses());
		
		
		
		
	}
	
	

}

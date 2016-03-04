package main.java;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AddressBook {
	private String name;
	private ArrayList<Person> addresses;
	
	static Comparator<Person> getZIPComparator() {
        return new Comparator<Person>() {
        	@Override
        	public int compare(Person a, Person b) {
            	return a.getZIP().compareTo( b.getZIP());
           }
        };
    };
    
    
    static Comparator<Person> getLastNameComparator() {
        return new Comparator<Person>() {
        	@Override
        	public int compare(Person a, Person b) {
            	return a.getLastName().compareTo( b.getLastName());
           }
        };
    };
	
	public AddressBook() {
		addresses= new ArrayList<Person>();
	}
	
	public AddressBook(String name) {
		//if addressBook already exist in DB grab Persons
		try {
			if(FileSystem.doesExist(name)){	
			this.name = name;
			addresses= FileSystem.getPeople(name);
			} else {
				FileSystem.createBook(name);
				this.name = name;
				addresses = new ArrayList<Person>();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//else create new one
	}
	
	public void Add(Person p) {
		addresses.add(p);
	}
	
	public void Delete(Person p) {
		addresses.remove(p);
	}
	
	public ArrayList<Person> getAddresses() {
		return addresses;
	}
	
	public void SortZip() {
		Collections.sort(addresses,getZIPComparator());
	}
	
	
	public void SortName() {
		Collections.sort(addresses,getLastNameComparator());
	}
	
}
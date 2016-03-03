

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;

public class AGUI extends JFrame {
	
	//private AddressBookController controller;
	private AddressBook addressBook;
	private AbstractListModel nameListModel;
	private JList nameList;
	private JButton addButton;
	private JButton editButton;
	private JButton deleteButton;
	private JButton sortByNameButton;
	private JButton sortByZipButton;
	private JMenuItem newItem;
	private JMenuItem openItem;
	private JMenuItem saveItem;
	private JMenuItem saveAsItem;
	private JMenuItem printItem;
	private JMenuItem quitItem;
	private JPanel ButtonConatainer;
	private Container ListContainer;
	private Container FieldContainer;
	private GridLayout gridLayout;
	private BorderLayout borderLayout;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField street;
	private JTextField streetField;
	private JTextField state;
	private JTextField stateField;
	private JTextField zip;
	private JTextField zipField;
	private JTextField phone;
	private JTextField phoneField;
	private JTextField city;
	private JTextField cityField;
	private GridLayout gridLayout2;
	private JPanel fieldConatiner;
	
	
	
	
	public AGUI(){
		super("Address Book");	
		
		//Getting Address Books to Display
		//String[] peopleObjects = {"FRed", "Tim", "Doug", "Sally", "mom"};
		
		/*ArrayList<String> books = null;
		try {
			books = FileSystem.getAddressBooks();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] peopleObjects = new String[books.size()];
		peopleObjects = books.toArray(peopleObjects);*/
		
		/*//Test Adding Person
		try {
			FileSystem.addPerson("tonysbook", "bob", "s", "125", "miami", "FL", "33915", "239-452-8787");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
		//Test updating a person
		/*try {
			FileSystem.updatePerson("tonysbook", 3, "bob", "s", "555", "St Pete", "FL", "33915", "239-452-8787");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
		//Need people to list
		// Check for AddressBook by creating an object
		//Will create new one if doesn't exist (Capitals matter)
		//If exists the address will be passed back and fill in the peopleObjects
		ArrayList<Person> people = null;
		
		AddressBook b = new AddressBook("TONYSBOOK2");
		people = b.getAddresses();
		
		String[] peopleObjects = new String[people.size()];
		for(int i = 0; i < people.size(); i++){
			peopleObjects[i] = people.get(i).getFirstName();
		}
		//peopleObjects = books.toArray(peopleObjects);
		
		
		
		gridLayout = new GridLayout(3,3);
		addButton = new JButton("add");
		editButton = new JButton("edit");
		deleteButton= new JButton("delete");
		sortByNameButton = new JButton("sort by name");
		sortByZipButton = new JButton("sort by zip");
		printItem = new JMenuItem("print");
		newItem = new JMenuItem("new");
		saveItem = new JMenuItem("save");
		saveAsItem = new JMenuItem("saveas/update");
		ButtonConatainer = new JPanel();
		ButtonConatainer.setLayout(gridLayout);
		add(ButtonConatainer, BorderLayout.SOUTH);
		ButtonConatainer.add(addButton);
		ButtonConatainer.add(editButton);
		ButtonConatainer.add(deleteButton);
		ButtonConatainer.add(sortByNameButton);
		ButtonConatainer.add(sortByZipButton);
		ButtonConatainer.add(printItem);
		ButtonConatainer.add(newItem);
		ButtonConatainer.add(saveItem);
		ButtonConatainer.add(saveAsItem);
		
		JList nameList = new JList(peopleObjects);
		nameList.setVisibleRowCount(10);
		add(nameList, BorderLayout.WEST);
		
		firstName = new JTextField("first name");
		lastName= new JTextField("last name");
		street = new JTextField("street");
		street.setEditable(false);
		streetField = new JTextField(" ", 20);
		city= new JTextField("city");
		city.setEditable(false);
		cityField = new JTextField(" ", 10);
		state = new JTextField("state");
		state.setEditable(false);
		stateField = new JTextField(" ", 2);
		zip = new JTextField("zip");
		zip.setEditable(false);
		zipField = new JTextField(" ", 5);
		phone = new JTextField("phone");
		phone.setEditable(false);
		phoneField = new JTextField(" ", 10);
		gridLayout2 = new GridLayout(6,2);
		fieldConatiner = new JPanel();
		fieldConatiner.setLayout(gridLayout2);
		add(fieldConatiner, BorderLayout.EAST);
		fieldConatiner.add(firstName);
		fieldConatiner.add(lastName);
		fieldConatiner.add(street);
		fieldConatiner.add(streetField);
		fieldConatiner.add(city);
		fieldConatiner.add(cityField);
		fieldConatiner.add(state);
		fieldConatiner.add(stateField);
		fieldConatiner.add(zip);
		fieldConatiner.add(zipField);
		fieldConatiner.add(phone);
		fieldConatiner.add(phoneField);
		
		
		
	}
	

}

package main.java;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



public class AGUI extends JFrame {
	
	//private AddressBookController controller;
	private JInternalFrame front;
	
	private JInternalFrame back;
	private AddressBook addressBook;
	private AbstractListModel nameListModel;
	private JList nameList;
	private JButton editButton;
	private JButton deleteButton;
	private JButton sortByNameButton;
	private JButton sortByZipButton;
	private JButton newItem;
	private JButton openItem;
	private JButton saveItem;
	private JButton saveAsItem;
	private JButton printItem;
	private JButton quitItem;
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
	private JPanel searchPanel;
	private JRadioButton searchLast;
	private JRadioButton searchFirst;
	private JRadioButton searchZip;
	private JRadioButton searchStreet;
	private JRadioButton searchPhone;
	private JRadioButton searchCity;
	private ButtonGroup radioGroup;
	private JTextField searchTextField;
	private JButton searchButton;
	private GridLayout serchLayout;
	private JPanel radioPanel;
	
	
	private JButton addButton;
	private JList bookList;
	private JTextField newNameField;
	private GridLayout bottomLayout;
	private JPanel panel;
	private JPanel bottomPanel;
	
	private JPanel cards;
	
	JDesktopPane desk;
	
	
	
	
	public AGUI(){
		super("Address Book");	
		
		//Getting Address Books to Display
		String[] peopleObjects = {"FRed", "Tim", "Doug", "Sally", "mom"};
		
		
		
		JInternalFrame front = new JInternalFrame("front",true,true,true,true);
		desk = new JDesktopPane();
		add(desk);
		front.setLayout(new BorderLayout());
		
		JInternalFrame back = new JInternalFrame();
		
		desk.add(front);
		desk.add(back);
		
		front.setSize(500,500);
		
		
		front.setVisible(true);
		back.setVisible(false);
		
		
		
		
		
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
		
	//	AddressBook b = new AddressBook("TONYSBOOK2");
//		people = b.getAddresses();
		
	//	String[] peopleObjects = new String[people.size()];
	//	for(int i = 0; i < people.size(); i++){
	//		peopleObjects[i] = people.get(i).getFirstName();
	//	}
		//peopleObjects = books.toArray(peopleObjects);
		
		
		
		gridLayout = new GridLayout(2,3);
		editButton = new JButton("edit");
		deleteButton= new JButton("delete");
		sortByNameButton = new JButton("sort by name");
		sortByZipButton = new JButton("sort by zip");
		printItem = new JButton("print");
		newItem = new JButton("new");
		saveItem = new JButton("save");
		saveAsItem = new JButton("saveas/update");
		ButtonConatainer = new JPanel();
		ButtonConatainer.setLayout(gridLayout);
		back.add(ButtonConatainer, BorderLayout.SOUTH);
	
		ButtonConatainer.add(newItem);
		ButtonConatainer.add(saveItem);
		ButtonConatainer.add(deleteButton);
		ButtonConatainer.add(sortByNameButton);
		ButtonConatainer.add(sortByZipButton);
		ButtonConatainer.add(printItem);
		
		
		JList nameList = new JList(peopleObjects);
		nameList.setVisibleRowCount(10);
		back.add(nameList, BorderLayout.WEST);
		
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
		back.add(fieldConatiner, BorderLayout.EAST);
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
		
		radioGroup = new ButtonGroup();
		
		searchPhone = new JRadioButton("phone",false);
		searchLast = new JRadioButton("last name", false);
		searchFirst = new JRadioButton("first name", true);
		searchZip = new JRadioButton("zip",false);
		searchCity = new JRadioButton("city", false);
		searchStreet = new JRadioButton("street", false);
		searchButton = new JButton("search");
		radioGroup.add(searchFirst);
		radioGroup.add(searchLast);
		radioGroup.add(searchZip);
		radioGroup.add(searchCity);
		radioGroup.add(searchStreet);
		radioGroup.add(searchPhone);
	
		searchPanel = new JPanel();
		radioPanel = new JPanel();
		serchLayout = new GridLayout(2,1);
		searchPanel.setLayout(serchLayout);
		radioPanel.add(searchFirst);
		radioPanel.add(searchLast);
		radioPanel.add(searchZip);
		radioPanel.add(searchCity);
		radioPanel.add(searchStreet);
		radioPanel.add(searchPhone);
		radioPanel.add(searchButton);
		
		searchTextField = new JTextField(10);
		
		
		
		searchPanel.add(radioPanel);
		searchPanel.add(searchTextField);
		back.add(searchPanel, BorderLayout.NORTH);
		
		searchFirst.addItemListener(new RadioButtonHandler());
		searchLast.addItemListener(new RadioButtonHandler());
		searchZip.addItemListener(new RadioButtonHandler());
		searchCity.addItemListener(new RadioButtonHandler());
		searchStreet.addItemListener(new RadioButtonHandler());
		searchPhone.addItemListener(new RadioButtonHandler());
		searchButton.addItemListener(new RadioButtonHandler());
		
		searchButton.addActionListener(new ButtonHandler());

		
		deleteButton.addActionListener(new ButtonHandler());
		sortByNameButton.addActionListener(new ButtonHandler());
		sortByZipButton.addActionListener(new ButtonHandler());
		newItem.addActionListener(new ButtonHandler());
		saveItem.addActionListener(new ButtonHandler());
		printItem.addActionListener(new ButtonHandler());
		
		
		
		
		String[] books = { "james", "Ted",  "Coolio", "wierd al", "Tim"};
		
		addButton = new JButton("add");
		bookList = new JList(books);
		newNameField = new JTextField(15);
		panel = new JPanel();
		//add(panel, BorderLayout.CENTER);
		bottomPanel = new JPanel();
		
		
		
		bottomLayout = new GridLayout(1,2);
		bottomPanel.setLayout(bottomLayout);
		
		bottomPanel.add(newNameField);
		bottomPanel.add(addButton);
		front.add(bottomPanel, BorderLayout.SOUTH);
		front.add(bookList, BorderLayout.CENTER);
		ButtonHandler handler = new ButtonHandler();
		addButton.addActionListener(handler);
		
		
		

	
		
	}
	private class RadioButtonHandler implements ItemListener{

		public void itemStateChanged(ItemEvent e) {
		//	searchTextField.searchx
			
		}
		
	}
	
	private class ButtonHandler implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==addButton){
				front.setVisible(false);
				back.setVisible(true);
			}
			
		}
		
	}
	
	private class textFieldListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
		//	if(e == searchTextField)
			
		}
		
	}
	
	private class listListener implements ListSelectionListener{

		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public static final void main(String[] args){
		
	}

}







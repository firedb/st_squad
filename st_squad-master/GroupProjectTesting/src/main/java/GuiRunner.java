package main.java;

import javax.swing.JFrame;

public class GuiRunner {
	public static void main(String[] agrs){
		AGUI gui = new AGUI();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(550,550);
		gui.setVisible(true);
		
		
	}
}

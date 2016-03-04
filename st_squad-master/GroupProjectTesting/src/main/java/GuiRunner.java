package main.java;

import javax.swing.JFrame;

public class GuiRunner {
	public static void main(String[] agrs){
		AGUI gui = new AGUI();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(500,500);
		gui.setVisible(true);
	}
}

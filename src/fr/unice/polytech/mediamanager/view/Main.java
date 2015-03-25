package fr.unice.polytech.mediamanager.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
	/**
	 * @param args
	 */
	 JFrame frame;
	 JPanel display;
	 JPanel menu;
	 JPanel research;
	 
	public Main() {
		frame = new JFrame("Mediatheque");
		Dimension d = new Dimension(800, 600);
		frame.setMinimumSize(d) ; 
		display = new Display(this);
		menu = new Menu(this);
		research = new Research(this);
	    frame.add(display,BorderLayout.CENTER);
	    frame.add(menu,BorderLayout.NORTH);
	    frame.add(research,BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public void refresh(){
		 frame.revalidate();
		 frame.repaint();
	}
	public void showMainPage(){
		frame.remove(display);
		refresh();	
	}
	
	public void showResultResearch(String researchType, String researchBy, String entry){
		frame.remove(display);
		display=new ResearchResult(this, researchType,  researchBy,  entry);
		frame.add(display);
		refresh();
	}
	
	
	public static void main(String[] args) {
		new Main();
	}

	public void addFilm() {
		frame.remove(display);
		display=new AddFilm(this);
		frame.add(display);
		refresh();		
	}

}

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
	 JPanel affichage;
	 JPanel menu;
	 JPanel recherche;
	 
	public Main() {
		frame = new JFrame("Mediatheque");
		Dimension d = new Dimension(800, 600);
		frame.setMinimumSize(d) ; 
		affichage = new Display(this);
		menu = new Menu(this);
		recherche = new Research(this);
	    frame.add(affichage,BorderLayout.CENTER);
	    frame.add(menu,BorderLayout.NORTH);
	    frame.add(recherche,BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public void refresh(){
		 frame.revalidate();
		 frame.repaint();
	}
	
	public static void main(String[] args) {
		new Main();
	}

}

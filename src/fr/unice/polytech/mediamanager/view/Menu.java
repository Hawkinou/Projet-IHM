package fr.unice.polytech.mediamanager.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class Menu extends JPanel {
	Main frame;
	public Menu(Main main){
		frame=main;
	JMenu films = new JMenu("Films");


	JMenuBar menuBar =new JMenuBar();
	JMenuItem ajout = new JMenuItem("Ajouter");
	 ajout.addActionListener(new MyActionListener());

	JMenuItem modif = new JMenuItem("Modifier");
	 modif.addActionListener(new MyActionListener2());

	JMenuItem suppr = new JMenuItem("Supprimer");
	 suppr.addActionListener(new MyActionListener3());
	 
	films.add(ajout);
	films.add(modif);
	films.add(suppr);
	
	menuBar.add(films);
	add(menuBar);
	}
	
	 private class MyActionListener implements ActionListener {
		 public void actionPerformed(ActionEvent event) {
			 frame.addFilm();
			 }
	 }
	 private class MyActionListener2 implements ActionListener {
		 public void actionPerformed(ActionEvent event) {
				System.out.println("modif");
		 }
	 }
	 private class MyActionListener3 implements ActionListener {
		 public void actionPerformed(ActionEvent event) {
				System.out.println("suppr");
		 }
	 }
}


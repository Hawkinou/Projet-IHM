package fr.unice.polytech.mediamanager.view;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextArea;



public class AddFilm extends Display {
	private JTextArea titleEntry;
	private JTextArea directorEntry;
	private JTextArea posterEntry;
	private JTextArea synopsisEntry;
	
	public AddFilm(Main main) {
		super(main);
		this.setLayout(new GridLayout(10,2));
		
	}
	/**
    private String title;
    private Director director;
    private ArrayList<Actor> actors;
    private ArrayList<Genre> genres;
    private int runtime;
    private String poster;
    private String synopsis;
	*/
}

package fr.unice.polytech.mediamanager.view;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;




public class AddFilm extends Display {

	private JTextField titre, director, actor, genre, runtime, affiche,synopsis;
	public AddFilm(Main main) {
		super(main);
		titre=new JTextField();
		director=new JTextField();
		actor=new JTextField();
		genre=new JTextField();
		runtime=new JTextField();
		affiche=new JTextField();
		synopsis=new JTextField();

		this.setLayout(new GridLayout(8,2));
		this.add(new JLabel("Titre :"));
		this.add(new JTextField());
		this.add(new JLabel("Directeur :"));
		this.add(director);
		this.add(new JLabel("Acteurs :"));
		this.add(actor);
		this.add(new JLabel("Genres :"));
		this.add(genre);
		this.add(new JLabel("Durée :"));
		this.add(runtime);
		this.add(new JLabel("Affiche :"));
		this.add(affiche);
		this.add(new JLabel("Synopsis :"));
		this.add(synopsis);
		JButton button = new JButton("Ajouter");
		button.addActionListener(new MyActionListener());
		this.add(button);
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
	 private class MyActionListener implements ActionListener {
		 public void actionPerformed(ActionEvent event) {
			 System.out.println("test");
			 }
	 }
}

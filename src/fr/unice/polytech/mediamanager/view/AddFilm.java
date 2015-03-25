package fr.unice.polytech.mediamanager.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import fr.unice.polytech.mediamanager.control.ModificationControl;
import fr.unice.polytech.mediamanager.control.ResearchControl;
import fr.unice.polytech.mediamanager.model.Actor;
import fr.unice.polytech.mediamanager.model.Director;




public class AddFilm extends Display {

	private JTextField title, genre, runtime, affiche,synopsis;
	JPanel actor;
	JComboBox director, actorBox;
	private JTextArea info;
	public AddFilm(Main main) {
		super(main);
		title=new JTextField();
		director=new JComboBox();
		ArrayList<Director> directors = ResearchControl.getInstance().getDirector();
		for (Director direct : directors){
			director.addItem(direct);
		}
		actor=new JPanel();
		actorBox=new JComboBox();
		ArrayList<Actor> actors = ResearchControl.getInstance().getActor();
		for (Actor act : actors){
			actorBox.addItem(act);
		}
		actor.add(actorBox);
		JButton buttonAddActor = new JButton("Ajout");
		actor.add(buttonAddActor);
		JTextField listActor=new JTextField();
		genre=new JTextField();
		runtime=new JTextField();
		affiche=new JTextField();
		synopsis=new JTextField();

		this.setLayout(new GridLayout(8,2));
		this.add(new JLabel("Titre :"));
		this.add(title);
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
		info =new JTextArea();
		info.setEnabled(false);
		info.setBackground(Color.LIGHT_GRAY);
		info.setDisabledTextColor(Color.BLACK);
		this.add(info);
		
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
			 System.out.println(director.getSelectedItem());
		 	info.setText(ModificationControl.getInstance().addFilm(title.getText(), (Director) director.getSelectedItem(), actor.getText(), genre.getText(), runtime.getText(), affiche.getText(), synopsis.getText()));
		}
	}
}

package fr.unice.polytech.mediamanager.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.unice.polytech.mediamanager.control.ResearchControl;
import fr.unice.polytech.mediamanager.model.*;

public class ResearchResult extends Display {
	JPanel returnButton;
	JPanel list;

	public ResearchResult(Main main,String researchType, String researchBy, String entry){
		super(main);
		returnButton = new JPanel();
		this.setLayout(new BorderLayout());
		createReturnButton();
		this.add(returnButton, BorderLayout.SOUTH);
		list = new JPanel();
		this.add(list,BorderLayout.CENTER);
		sendRequest(researchType, researchBy, entry);
	}

	private void createReturnButton() {
		JButton button = new JButton("Retour");
		button.addActionListener(new returnListener());
		returnButton.add(button);
	}

	private void sendRequest(String researchType, String researchBy, String entry) {
		if(researchType.equals("Film")){
			sendFilmRequest(researchBy,entry);
		}
		else if(researchType.equals("Actor")){
			sendActorRequest();
		}
		else if(researchType.equals("Director")){
			sendDirectorRequest();
		}
		else if(researchType.equals("Nationality")){
			sendNationnalityRequest();
		}
		else{
			sendGenreRequest();
		}		
	}

	private void sendGenreRequest() {
		ArrayList<Genre> genre =ResearchControl.getInstance().getGenre();
		list.setLayout(new GridLayout((int)(genre.size()/2),2));
		for (Genre genr : genre){
			list.add(new JLabel(genr.getLabelEn(),JLabel.CENTER));
		}
	}

	private void sendNationnalityRequest() {
		ArrayList<Nationality> nationality =ResearchControl.getInstance().getNationality();
		list.setLayout(new GridLayout((int)(nationality.size()/2),2));
		for (Nationality nation : nationality){
			
			list.add(new JLabel(nation.getLabelEn(),JLabel.CENTER));

		}
	}

	private void sendDirectorRequest() {
		ArrayList<Director> director =ResearchControl.getInstance().getDirector();
		list.setLayout(new GridLayout((int)(director.size()/2),2));
		for (Director direct : director){
			list.add(new JButton(direct.getFirstname()+" " +direct.getLastname()));
			//TODO Ajouter une action listener au button qui mene vers la fiche de chaques director
		}		

	}

	private void sendActorRequest() {
		ArrayList<Actor> actors =ResearchControl.getInstance().getActor();
		list.setLayout(new GridLayout((int)(actors.size()/2),2));
		for (Actor actor : actors){
			list.add(new JButton(actor.getFirstname()+" " +actor.getLastname()));
			//TODO Ajouter une action listener au button qui mene vers la fiche de chaques director
		}			
	}

	private void sendFilmRequest(String researchBy, String entry) {
		ArrayList<Film> films =ResearchControl.getInstance().getFilm(researchBy,entry);
		list.setLayout(new GridLayout((int)(films.size()/2),2));
		for (Film film : films){
			list.add(new JButton(film.getTitle()));
			//TODO Ajouter une action listener au button qui mene vers la fiche de chaques director
		}
	}
	
	 private class returnListener implements ActionListener {
		 public void actionPerformed(ActionEvent event) {
			frame.showMainPage();
		 }
	 }
}

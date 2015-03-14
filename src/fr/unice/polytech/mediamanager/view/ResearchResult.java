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
import fr.unice.polytech.mediamanager.model.Genre;
import fr.unice.polytech.mediamanager.model.Nationality;

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
		// TODO Auto-generated method stub
		
	}

	private void sendActorRequest() {
		// TODO Auto-generated method stub
		
	}

	private void sendFilmRequest(String researchBy, String entry) {
		ResearchControl.getInstance().getFilm();

	}
	
	 private class returnListener implements ActionListener {
		 public void actionPerformed(ActionEvent event) {
			frame.showMainPage();
		 }
	 }
}

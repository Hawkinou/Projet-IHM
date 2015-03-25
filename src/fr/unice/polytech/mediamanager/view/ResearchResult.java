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
		button.addActionListener(new ReturnListener());
		returnButton.add(button);
	}

	private void sendRequest(String researchType, String researchBy, String entry) {
		if(researchType.equals("Film")){
			sendFilmRequest(researchBy,entry,1);
		}
		else if(researchType.equals("Actor")){
			sendActorRequest(1);
		}
		else if(researchType.equals("Director")){
			sendDirectorRequest(1);
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
		list.setLayout(new GridLayout((int)(nationality.size()/2),1));
		for (Nationality nation : nationality){
			
			list.add(new JLabel(nation.getLabelEn(),JLabel.CENTER));

		}
	}

	private void sendDirectorRequest(int numPage) {
		list.removeAll();
		ArrayList<Director> director =ResearchControl.getInstance().getDirector();
		list.setLayout(new GridLayout(6,2));
		for (int i=10*(numPage-1);i<10*numPage&&i<director.size();i++){
			JButton button = new JButton(director.get(i).getFirstname()+" " +director.get(i).getLastname());
			button.addActionListener(new DirectorListener());
			list.add(button);
		}
		if (numPage!=1){
			JButton button = new JButton("Page "+ (numPage-1));
			button.addActionListener(new GetNextRangeD());
			list.add(button);			
		}
		if (director.size()>10*numPage){
			JButton button = new JButton("Page "+(numPage+1));
			button.addActionListener(new GetNextRangeD());
			list.add(button);			
		}
		//TODO Ajouter une action listener au button qui mene vers la fiche de chaques director
		list.updateUI();
	}
	private void sendActorRequest(int numPage) {
		list.removeAll();
		ArrayList<Actor> actors =ResearchControl.getInstance().getActor();
		list.setLayout(new GridLayout(6,2));
		for (int i=10*(numPage-1);i<10*numPage&&i<actors.size();i++){
			JButton button = new JButton(actors.get(i).getFirstname()+" " +actors.get(i).getLastname());
			button.addActionListener(new ActorListener());
			list.add(button);
		}
		if (numPage!=1){
			JButton button = new JButton("Page "+ (numPage-1));
			button.addActionListener(new GetNextRangeA());
			list.add(button);			
		}
		if (actors.size()>10*numPage){
			JButton button = new JButton("Page "+(numPage+1));
			button.addActionListener(new GetNextRangeA());
			list.add(button);			
		}
		list.updateUI();
			//TODO Ajouter une action listener au button qui mene vers la fiche de chaques director
	}

	private void sendFilmRequest(String researchBy, String entry,int numPage) {
		list.removeAll();
		ArrayList<Film> films =ResearchControl.getInstance().getFilm(researchBy,entry);
		list.setLayout(new GridLayout(6,2));
		for (int i=10*(numPage-1);i<10*numPage&&i<films.size();i++){
			JButton button = new JButton(films.get(i).getTitle());
			button.addActionListener(new FilmListener());
			list.add(button);
		}
		if (numPage!=1){
			JButton button = new JButton("Page "+ (numPage-1));
			button.addActionListener(new GetNextRangeF());
			list.add(button);			
		}
		if (films.size()>10*numPage){
			JButton button = new JButton("Page "+(numPage+1));
			button.addActionListener(new GetNextRangeF());
			list.add(button);			
		}
		list.updateUI();
	}
	
	 private class ReturnListener implements ActionListener {
		 public void actionPerformed(ActionEvent event) {
			frame.showMainPage();
		 }
	 }
	 private class FilmListener implements ActionListener {
		 public void actionPerformed(ActionEvent event) {
			new FicheFilm(event.getActionCommand());
		 }
	 }
	 
	 private class ActorListener implements ActionListener {
		 public void actionPerformed(ActionEvent event) {
			new FicheActor(event.getActionCommand());
		 }
	 }	 
	 private class DirectorListener implements ActionListener {
		 public void actionPerformed(ActionEvent event) {
			new FicheDirector(event.getActionCommand());
		 }
	 }	 	 
	 private class GetNextRangeD implements ActionListener {

		 public void actionPerformed(ActionEvent event) {
			 String eventRecu =event.getActionCommand();
			 sendDirectorRequest( Integer.parseInt(eventRecu.substring(5, eventRecu.length())));
		 }
	 }
	 private class GetNextRangeA implements ActionListener {

		 public void actionPerformed(ActionEvent event) {
			 String eventRecu =event.getActionCommand();
			 sendActorRequest( Integer.parseInt(eventRecu.substring(5, eventRecu.length())));
		 }
	 }
	 private class GetNextRangeF implements ActionListener {

		 public void actionPerformed(ActionEvent event) {
			 String eventRecu =event.getActionCommand();
			 sendActorRequest( Integer.parseInt(eventRecu.substring(5, eventRecu.length())));
		 }
	 }
}

package fr.unice.polytech.mediamanager.view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import fr.unice.polytech.mediamanager.model.Actor;
import fr.unice.polytech.mediamanager.model.Film;
import fr.unice.polytech.mediamanager.model.Genre;
import fr.unice.polytech.mediamanager.model.Manager;

public class Fiche {
	Film film;

	public Fiche(String titreFilm){
		ArrayList<Film> films = Manager.getInstance().searchByTitle(titreFilm);
		film =films.get(0);
		
		JFrame frame = new JFrame(film.getTitle());
		frame.setLayout(new BorderLayout());
		JPanel titre = new JPanel();
		frame.setSize(200,200);
		frame.setMinimumSize(new Dimension(800, 600));
		Affiche affiche = new Affiche();
		frame.add(affiche, BorderLayout.CENTER);
		JPanel boutons = new JPanel();

		boutons.setLayout(new GridLayout(5,0));
		ArrayList<Actor> listActor = film.getActors();
        JPanel acteur = new JPanel(new GridLayout(listActor.size(),0));
        acteur.add(new JLabel("Acteurs :"));
        for (Actor actor : listActor){
            acteur.add(new JLabel(actor.getFirstname()+" "+ actor.getLastname()));

        }
        JPanel directeur = new JPanel(new GridLayout(2,0));

        directeur.add(new JLabel("Directeur :"));
        directeur.add(new JLabel(film.getDirector().getFirstname()+" "+ film.getDirector().getLastname()));
        
        JPanel runtime = new JPanel(new GridLayout(2,0));
        runtime.add(new JLabel("Duree :"));
        runtime.add(new JLabel(""+film.getRuntime()));

		ArrayList<Genre> listGenre = film.getGenres();

        JPanel genre = new JPanel(new GridLayout(5,0));
        genre.add(new JLabel("Genre :"));

        for (Genre genr : listGenre){
        	genre.add(new JLabel(genr.getLabelFr()));
        }
        
        JTextArea synopsis = new JTextArea(addaptString(film.getSynopsis()));
        synopsis.setWrapStyleWord(true);
        synopsis.setColumns(30);
        synopsis.setEnabled(false);
        synopsis.setDisabledTextColor(Color.BLACK);
		
		boutons.add(acteur);
		boutons.add(directeur);
        boutons.add(runtime);
		boutons.add(genre);
		boutons.add(synopsis);

		frame.add(boutons, BorderLayout.EAST);
		frame.add(titre, BorderLayout.PAGE_START);
		frame.pack();
	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private String addaptString(String synopsis) {
		if (synopsis.length()>80){
			int numberOfReturn=synopsis.length()/80;
			for (int j = 1;j<=numberOfReturn;j++){
				for (int i = 80*j ; i>1+80*(j-1); i--){
					if (synopsis.charAt(i)==' '){
						synopsis=synopsis.substring(0, i)+"\n"+synopsis.substring(i+1, synopsis.length());
						break;
					}
				}
			}
		}
		return synopsis;
	}
	
	private class Affiche extends JPanel{
		 public void paintComponent(Graphics g){                
        
           
		    Image img;
			try {
				img = ImageIO.read(new File(film.getPoster()));
			    g.drawImage(img, 0,0, getWidth(),getHeight(), this);

			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	}
}



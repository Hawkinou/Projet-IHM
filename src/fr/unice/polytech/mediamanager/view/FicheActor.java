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
import java.util.StringTokenizer;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import fr.unice.polytech.mediamanager.model.Actor;
import fr.unice.polytech.mediamanager.model.Film;
import fr.unice.polytech.mediamanager.model.Genre;
import fr.unice.polytech.mediamanager.model.Manager;

public class FicheActor {
	Actor actor;

	public FicheActor(String actorName){
		String firstName;
		String lastName;

	    StringTokenizer st = new StringTokenizer(actorName);
	    firstName=st.nextToken();
	    lastName=st.nextToken();
	    //TODO : nom a plusieurs nom non gerer
	    
		ArrayList<Actor> actors = Manager.getInstance().getAllActors();
		for (Actor act : actors){
			if (act.getFirstname().equals(firstName)&&act.getLastname().equals(lastName))
				actor=act;
		}
        /*this.firstname = firstname;
        this.lastname = lastname;
        this.nationality = nationality;
        this.birth = birth;
        this.death = death;
        this.photo = photo;	*/
		JFrame frame = new JFrame(actor.getFirstname()+" "+actor.getLastname());
		frame.setLayout(new BorderLayout());
		frame.setMinimumSize(new Dimension(800, 600));
		Affiche affiche = new Affiche();
		frame.add(affiche, BorderLayout.CENTER);
		JPanel boutons = new JPanel();
		boutons.setLayout(new GridLayout(3,0));
		
        JPanel nationality = new JPanel(new GridLayout(2,0));
        nationality.add(new JLabel("Nationalite :"));
        nationality.add(new JLabel(actor.getNationality().getLabelFr()));
        JPanel birth = new JPanel(new GridLayout(2,0));
        birth.add(new JLabel("Date de naissance :"));
        birth.add(new JLabel("" +actor.getBirth()));
        JPanel death = new JPanel(new GridLayout(2,0));
        death.add(new JLabel("Mort :"));
        death.add(new JLabel(""+actor.getDeath()));

		boutons.add(nationality);
		boutons.add(birth);
        boutons.add(death);


		frame.add(boutons, BorderLayout.EAST);
		frame.pack();
	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
	
	
	private class Affiche extends JPanel{
		 public void paintComponent(Graphics g){                
        
           
		    Image img;
			try {
				img = ImageIO.read(new File(actor.getPhoto()));
			    g.drawImage(img, 0,0, getWidth(),getHeight(), this);

			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	}
}



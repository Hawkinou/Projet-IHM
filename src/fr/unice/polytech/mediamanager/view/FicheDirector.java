package fr.unice.polytech.mediamanager.view;

import java.awt.BorderLayout;
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

import fr.unice.polytech.mediamanager.model.Director;
import fr.unice.polytech.mediamanager.model.Manager;

public class FicheDirector {
	Director director;

	public FicheDirector(String directorName){
		String firstName;
		String lastName;

	    StringTokenizer st = new StringTokenizer(directorName);
	    firstName=st.nextToken();
	    lastName=st.nextToken();
	    //TODO : nom a plusieurs nom non gerer
	    
		ArrayList<Director> directors = Manager.getInstance().getAllDirectors();
		for (Director direct : directors){
			if (direct.getFirstname().equals(firstName)&&direct.getLastname().equals(lastName))
				director=direct;
		}
        /*this.firstname = firstname;
        this.lastname = lastname;
        this.nationality = nationality;
        this.birth = birth;
        this.death = death;
        this.photo = photo;	*/
		JFrame frame = new JFrame(director.getFirstname()+" "+director.getLastname());
		frame.setLayout(new BorderLayout());
		frame.setMinimumSize(new Dimension(800, 600));
		Affiche affiche = new Affiche();
		frame.add(affiche, BorderLayout.CENTER);
		JPanel boutons = new JPanel();
		boutons.setLayout(new GridLayout(3,0));
		
        JPanel nationality = new JPanel(new GridLayout(2,0));
        nationality.add(new JLabel("Nationalite :"));
        nationality.add(new JLabel(director.getNationality().getLabelFr()));
        JPanel birth = new JPanel(new GridLayout(2,0));
        birth.add(new JLabel("Date de naissance :"));
        birth.add(new JLabel("" +director.getBirth()));
        JPanel death = new JPanel(new GridLayout(2,0));
        death.add(new JLabel("Mort :"));
        death.add(new JLabel(""+director.getDeath()));

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
				img = ImageIO.read(new File(director.getPhoto()));
			    g.drawImage(img, 0,0, getWidth(),getHeight(), this);

			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	}
}

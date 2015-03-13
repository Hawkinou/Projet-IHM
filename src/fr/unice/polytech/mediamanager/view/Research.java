package fr.unice.polytech.mediamanager.view;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class Research extends JPanel {
	Main frame;
	JComboBox recherchePossible;
	JComboBox typeRecherche;
	JTextArea zoneText;
	
	public Research(Main main){
		frame=main;
	    setLayout(new GridLayout(1,4));
	    String[] nomRecherchePossible = {"Film", "Genre", "Acteur", "Directeur", "Nationnalite"};
	    String[] nomTypeRecherchePossible = {"Titre de film", "Genre", "Acteur", "Directeur"};

	  //Create the combo box, select item at index 4.
	  //Indices start at 0, so 4 specifies the pig.
	  recherchePossible = new JComboBox(nomRecherchePossible);
	  recherchePossible.addActionListener(new MyActionListener());
	  add(recherchePossible);
      typeRecherche = new JComboBox(nomTypeRecherchePossible);
	  recherchePossible.addActionListener(new MyActionListener2());

	  add(typeRecherche);

	  zoneText = new JTextArea();
	  add(zoneText);
	  JButton bouton= new JButton("Rechercher");
	  add(bouton);
	}
	
	 private class MyActionListener implements ActionListener {
		 public void actionPerformed(ActionEvent event) {
				if(recherchePossible.getSelectedItem().equals("Film")){
					typeRecherche.setEnabled(true);
					zoneText.setEnabled(true);
				}
				else if(recherchePossible.getSelectedItem().equals("Nationnalite")){
					typeRecherche.setEnabled(false);
					zoneText.setEnabled(false);
				}
				else{
					typeRecherche.setEnabled(false); 
					zoneText.setEnabled(true);
				}
		 }
	 }
	 private class MyActionListener2 implements ActionListener {
		 public void actionPerformed(ActionEvent event) {
			
		 }
	 }
}

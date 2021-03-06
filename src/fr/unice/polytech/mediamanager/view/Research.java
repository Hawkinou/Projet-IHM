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
	JComboBox researchAvailable;
	JComboBox researchType;
	JTextArea textZone;
	
	public Research(Main main){
		frame=main;
	    setLayout(new GridLayout(1,4));
	    String[] nameResearchAvailable = {"Film", "Genre", "Actor", "Director", "Nationality"};
	    String[] nameResearchType = {"Titre de film", "Genre", "Actor", "Director"};

	  researchAvailable = new JComboBox(nameResearchAvailable);
	  researchAvailable.addActionListener(new MyActionListener());
	  add(researchAvailable);
	  researchType = new JComboBox(nameResearchType);

	  add(researchType);

	  textZone = new JTextArea();
	  add(textZone);
	  JButton bouton= new JButton("Rechercher");
	  bouton.addActionListener(new researchListener());
	  add(bouton);
	}
	 private class researchListener implements ActionListener {
		 public void actionPerformed(ActionEvent event) {
			 frame.showResultResearch((String)researchAvailable.getSelectedItem(),
					 (String)researchType.getSelectedItem(),
					 textZone.getText());
		 }
	 }
	 private class MyActionListener implements ActionListener {
		 public void actionPerformed(ActionEvent event) {
				if(researchAvailable.getSelectedItem().equals("Film")){
					researchType.setEnabled(true);
					textZone.setEnabled(true);
				}
				else{
					researchType.setEnabled(false); 
					textZone.setEnabled(false);
				}
				textZone.setText("");
		 }
	 }

}

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class TD2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Films");
		frame.setLayout(new BorderLayout());
		JPanel titre = new JPanel();
		frame.setSize(200,200);
		frame.setMinimumSize(new Dimension(200, 200));
		JLabel tavu = new JLabel("Pocahontas");
		titre.add(tavu);
		Affiche affiche = new Affiche();
		frame.add(affiche, BorderLayout.CENTER);
		JPanel boutons = new JPanel();

		boutons.setLayout(new GridLayout(3,0));
        JPanel acteur = new JPanel(new GridLayout(5,0));
        acteur.add(new JLabel("Acteurs :"));
        acteur.add(new JLabel("Jean-Claude Vandame"));
        acteur.add(new JLabel("Achille Talon"));
        acteur.add(new JLabel("Josephine Gardien"));

        JPanel genre = new JPanel(new GridLayout(5,0));
        genre.add(new JLabel("Genre :"));
        genre.add(new JLabel("Romance"));
        genre.add(new JLabel("Action"));
        genre.add(new JLabel("Guerre"));


        JLabel durée = new JLabel("   Durée : 2h30    ");
		boutons.add(acteur);
		boutons.add(genre);
		boutons.add(durée);

		frame.add(boutons, BorderLayout.EAST);
		frame.add(titre, BorderLayout.PAGE_START);
		frame.pack();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.*;

public class TD1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* EXERCIE 1
		JFrame frame = new JFrame("exercice 1");
		JButton button = new JButton("un bouton");
		JLabel label = new JLabel("un petit texte");
		JPanel pane = new JPanel();
		pane.add(button);
		pane.add(label);
		frame.setContentPane(pane);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setMinimumSize(new Dimension(300, 200));*/
		
		// Exercice 2 il faiut changer le layout du content pane
		/*JFrame frame = new JFrame("Hello World");
		Container contentPane = frame.getContentPane();
		JLabel label = new JLabel("Nom");
		contentPane.add(label);
		JTextField text = new JTextField("a remplir");
		contentPane.add(text);
		JButton button = new JButton("ok");
		contentPane.add(button);
		frame.pack();
		frame.setVisible(true);
		*/
		//EXO 3
		
		JFrame frame = new JFrame("");
		frame.setSize(200,200);
		frame.setMinimumSize(new Dimension(200, 200));
		frame.setMaximumSize(new Dimension(200, 200));
		JMenu menu = new JMenu("Fichier");
		JMenu menu2 = new JMenu("Edition");

		JMenuBar menuBar =new JMenuBar();
		JMenuItem creer = new JMenuItem("Créer");
		JMenuItem creer2 = new JMenuItem("Edition");
		JMenuItem creer3 = new JMenuItem("Sauvegarder");
		JMenuItem creer4 = new JMenuItem("Fermer");
		JMenuItem creer5 = new JMenuItem("Quitter");
		JMenuItem edi = new JMenuItem("Couper");
		JMenuItem edi2 = new JMenuItem("Copier");
		JMenuItem edi3 = new JMenuItem("Coller");

		menu.add(creer);
		menu.add(creer2);
		menu.add(creer3);
		menu.add(creer4);
		menu.add(creer5);
		menu2.add(edi);
		menu2.add(edi2);
		menu2.add(edi3);

		menuBar.add(menu);
		menuBar.add(menu2);

		TextArea text = new TextArea("zone de txt");
		JPanel pane = new JPanel();
		pane.setLayout(new GridLayout(1,0));
		frame.setJMenuBar(menuBar);
		frame.setContentPane(pane);
		//pane.add(menuBar);
		pane.add(text);
		frame.setVisible(true);
		/*
		JFrame frame = new JFrame("");
		frame.setSize(200,200);
		frame.setMinimumSize(new Dimension(200, 200));
		JButton creer = new JButton("Créer");
		JButton sauvegarder = new JButton("Sauvegarder");
		JButton quitter = new JButton("Quitter");
		JPanel image = new JPanel();
		image.setLayout(new BoxLayout(image, BoxLayout.Y_AXIS));
		JPanel boutons = new JPanel();
		boutons.add(creer);
		boutons.add(sauvegarder);
		boutons.add(quitter);
		boutons.setLayout(new GridLayout(3,0));
		JLabel monPaint = new JLabel("Mon Paint",SwingConstants.CENTER);
		JLabel tavu = new JLabel("tavu");

		JLabel imagee=new JLabel(new ImageIcon("draco.jpg"));
		image.add(monPaint);
		image.add(imagee);
		image.add(tavu);
		
		//frame.setContentPane(image);
		frame.add(boutons, BorderLayout.EAST);
		//frame.add(image, BorderLayout.WEST);
		frame.add(new Fenetre());

		frame.setVisible(true);*/
	}

}

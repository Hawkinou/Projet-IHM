import javax.swing.*;


import java.awt.*;
import java.awt.event.*;


public class TD3EXO2 {
	TextArea text;
	JFrame frame;
	 public TD3EXO2() {

			frame = new JFrame("");
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
			creer.addActionListener(new MyActionListener());
			creer2.addActionListener(new MyActionListener());
			creer3.addActionListener(new MyActionListener());
			creer4.addActionListener(new MyActionListener());
			creer5.addActionListener(new MyActionListener());
			edi.addActionListener(new MyActionListener());
			edi3.addActionListener(new MyActionListener());
			edi2.addActionListener(new MyActionListener());

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

			text = new TextArea("");
			JPanel pane = new JPanel();
			pane.setLayout(new GridLayout(1,0));
			frame.setJMenuBar(menuBar);
			frame.setContentPane(pane);
			//pane.add(menuBar);
			pane.add(text);
			frame.addWindowListener(new WindowListener(){

				@Override
				public void windowActivated(WindowEvent arg0) {
					// TODO Auto-generated method stub
					System.out.println("acti");

				}

				@Override
				public void windowClosed(WindowEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void windowClosing(WindowEvent arg0) {
					// TODO Auto-generated method stub
					new TD3EXO2();
				}

				@Override
				public void windowDeactivated(WindowEvent arg0) {
					// TODO Auto-generated method stub
					System.out.println("Deacti");
				}

				@Override
				public void windowDeiconified(WindowEvent arg0) {
					// TODO Auto-generated method stub
					System.out.println("Deiconi");

				}

				@Override
				public void windowIconified(WindowEvent arg0) {
					// TODO Auto-generated method stub
					System.out.println("icon");

				}

				@Override
				public void windowOpened(WindowEvent arg0) {
					// TODO Auto-generated method stub
					System.out.println("opened");

				}

			});
			frame.setVisible(true);
//			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	 }
	/**
	 * @param args
	 */
	private class MyActionListener implements ActionListener {
		 public void actionPerformed(ActionEvent event) {
			 String texte=text.getText();
			 texte +=  ((JMenuItem)event.getSource()).getText() +" ";
			 text.setText(texte);

		 }
	}
	public static void main(String[] args) {

	TD3EXO2 td= new TD3EXO2();
	}

}

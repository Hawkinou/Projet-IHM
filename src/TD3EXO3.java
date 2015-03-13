import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class TD3EXO3 {
 JPanel panel;
 int increment=0;
 JTextArea text;
 JFrame frame;
 int i=0;

 public TD3EXO3() {
	 frame = new JFrame("exercice 3");
	 Dimension d = new Dimension(240, 100);
	 frame.setMinimumSize(d) ; 
	 JButton button = new JButton("add");
	 button.addActionListener(new MyActionListener());
	 text = new JTextArea();
	 JPanel pane = new JPanel();
	 panel = new JPanel();
	 pane.setLayout(new GridLayout(1,2));

	 pane.add(text);
	 pane.add(button);
	 panel.setLayout(new GridLayout(0,1));
	 frame.getContentPane().add(panel,BorderLayout.CENTER);
	 frame.getContentPane().add(pane,BorderLayout.SOUTH);
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	 frame.setVisible(true);
 }
 private class MyActionListener2 implements ActionListener {
	 public void actionPerformed(ActionEvent event) {
		 i--;
		panel.remove((Component) event.getSource());
		 panel.setLayout(new GridLayout(i,1));

		 frame.revalidate();
		 frame.repaint();
		 
	 }
 }
 private class MyActionListener implements ActionListener {
	 public void actionPerformed(ActionEvent event) {
		 i++;
		 
		 JButton buto= new JButton(text.getText());
		 text.setText("");
		 panel.add(buto);
		 panel.setLayout(new GridLayout(i,1));

		 buto.addActionListener(new MyActionListener2());
		 frame.revalidate();
		 frame.repaint();
	 }
 }
 public static void main(String[] args) {
	 new TD3EXO3();
 }
}
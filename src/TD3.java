import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class TD3 {
 private JLabel label;
 int increment=0;

 public TD3() {
	 JFrame frame = new JFrame("exercice 1");
	 Dimension d = new Dimension(240, 100);
	 frame.setMinimumSize(d) ; 
	 JButton button = new JButton("incremente");
	 JButton button2 = new JButton("decremente");
	 button.addActionListener(new MyActionListener());

	 button2.addActionListener(new MyActionListener2());
	 label = new JLabel("0");
	 JPanel pane = new JPanel();
	 JPanel panel = new JPanel();
	 panel.setLayout(new GridLayout(2,1));
	 panel.add(button);
	 panel.add(button2);
	 frame.getContentPane().add(panel,BorderLayout.WEST);

	 pane.add(label);
	 frame.getContentPane().add(pane, BorderLayout.CENTER);
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	 frame.setVisible(true);
 }
 private class MyActionListener2 implements ActionListener {
	 public void actionPerformed(ActionEvent event) {
		 increment--;
		 label.setText(""+increment);
	 }
 }
 private class MyActionListener implements ActionListener {
	 public void actionPerformed(ActionEvent event) {
		 increment = (int) (Math.random()*100);
		 label.setText(""+increment);
	 }
 }
 public static void main(String[] args) {
	 new TD3();
 }
}
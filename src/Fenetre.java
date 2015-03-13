import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class Fenetre extends JPanel{

	/**
	 * @param args
	 */
	  public void paintComponent(Graphics g){                
        
		    g.drawString("Mon Paint", getWidth()/2, getHeight()/4-8);   
		    g.drawString("tavu", getWidth()/2, 3*getHeight()/4+8);                
		    Image img;
			try {
				img = ImageIO.read(new File("draco.jpg"));
			    g.drawImage(img, getWidth()/4, getHeight()/4, getWidth()/2,getHeight()/2, this);

			} catch (IOException e) {
				e.printStackTrace();
			}
		  }   

}

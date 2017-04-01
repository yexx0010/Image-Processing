package project;

import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.io.*;


public class imageFilter extends JPanel
 {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public static void main(String[] argv) throws Exception
  	 {
    JFrame frame = new JFrame("blur Image");
    frame.add(new imageFilter());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400,400);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
  	  public void paint(Graphics g)
  {
    try
    	{
     BufferedImage myImage=null;
        myImage = ImageIO.read(new File("C:\\467\\readImage.jpg"));
      BufferedImage filteredImage = new BufferedImage(myImage.getWidth(null), myImage
          .getHeight(null), BufferedImage.TYPE_BYTE_GRAY);
      Graphics gs = filteredImage.getGraphics();
      gs.drawImage(myImage, 400, 200, null);
     Kernel kernel = new Kernel(3, 3, new float[] { 1f / 9f, 1f / 9f, 1f / 9f,
        1f / 9f, 1f / 9f, 1f / 9f, 1f / 9f, 1f / 9f, 1f / 9f });
      BufferedImageOp fuzzyImage = new ConvolveOp(kernel);
      myImage = fuzzyImage.filter(myImage, null);
      gs.dispose();
      Graphics2D g2d = (Graphics2D) g;
      g2d.drawImage(myImage, null, 3, 3);
    } catch (Exception ex)
    {
      ex.printStackTrace();
    }
  }
}


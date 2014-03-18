import java.awt.Container;

import javax.swing.JApplet;
import javax.swing.JFrame;



  public class GameRun extends JApplet{
	  
  public static void main(String[] args) {

	  CharacterTest ct = new CharacterTest();
	  ct.init();
	  
	    JFrame f = new JFrame("Ryu will take it all ...");
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.getContentPane().add(ct);
	    f.setContentPane(ct);
	    f.setVisible(true);
  }
  

  }
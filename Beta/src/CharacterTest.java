import java.applet.Applet;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;

import engine.GameCharacter;

public class CharacterTest extends Applet implements MouseMotionListener, Runnable, KeyListener {

	private JApplet gameApp;
	private final int DELAY =34;
	private int mX, mY;
	private int gameTime =0;

	private int pos =0;
	private int actionAnimation =0;
  private Image dbImage;
  private Graphics dbg;
  private    Thread t;
  
  private  GameCharacter character;

  
 

  
  public void init(){
	  
	  
	  dbImage = createImage(700,700);
	  dbg = dbImage.getGraphics();
	  
	  this.setName("Ryu will take all...");
	  this.setSize(700, 700);
      character = new GameCharacter();
            
      int[] width   = {65,65,60,68,67,70,60};
      int[] height  = {100,100,100,100,100,100,100};
      int row       = 7;
      int[] columns = {5,5,3,4,5,5,3};
      
      character.buildCharacterSprite("/Ryu.gif", width, height,row, columns);
      
      addMouseMotionListener(this);
      addKeyListener(this);
      setVisible(true);
      t = new Thread(this);
      t.start();
	  
	  
	  
  }
  
  public void run(){
	  
	  int i=0;
	
	  while(true){
		
		  pos = i;
		  if(i<4){i++;}
		  else{i=0;}
		  
		  actionAnimation = character.getAnimationIndex();

		  
		  this.repaint();
		   try {
			   
			   if(gameTime < (60)){t.sleep(60);}
			   else if(gameTime < (100)) {t.sleep(100);}
			   else if(gameTime < (140)){t.sleep(200);}
			   else{gameTime =0;}
	            
	            gameTime++;
	        }
	        catch (InterruptedException ex){
	        }
	  }
	  
  }

  public void mouseMoved(MouseEvent me) {
    mX = (int) me.getPoint().getX();
    mY = (int) me.getPoint().getY();
    repaint();
  }

  public void mouseDragged(MouseEvent me) {
    mouseMoved(me);
  }


  public void paint(Graphics g) {
    
     


	  character.animation(g,actionAnimation,pos);
	  g.drawString("Game Time :"+gameTime, 100, 500);
    
  }
  

  
  public void update(Graphics g) {

	  
	  dbg.clearRect(0,0,700,700);
	  paint(dbg);
	  
	  g.drawImage(dbImage, 0, 0, this);
  }

@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	if(e.getKeyCode() == KeyEvent.VK_SPACE){
		
		if(actionAnimation<4){character.increaseAnimationIndex();}
		else{character.setAnimationIndex(0);}
		System.out.println("count "+actionAnimation);
	}
	System.out.println("key: "+e.getKeyCode());
}

@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub

	
	
}


}
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

import spiritUtility.Spirit;
import spiritUtility.SpiritActionType;


public class CharacterTest extends Applet implements MouseMotionListener, Runnable, KeyListener {

	private JApplet gameApp;
	private final int DELAY =34;
	private int mX, mY;
	private int gameTime =0;

	private int posOne =0;
	private int posTwo =0;
	private SpiritActionType actionAnimation = null;
  private Image dbImage;
  private Graphics dbg;
  private    Thread t;
  
    private  Spirit character;
    private  Spirit characterTwo;


  
 

  
  public void init(){
	  
	  
	  dbImage = createImage(700,700);
	  dbg = dbImage.getGraphics();
	  
	  this.setName("Ryu will take all...");
	  this.setSize(700, 700);
	  
	  SpiritActionType defaultAction = SpiritActionType.IDLE;	  
	  this.actionAnimation = defaultAction; 
	  
      character = new Spirit("/Ryu.gif");
      
      
      int[] x_Pos  = {0,(65),(2*65),(3*65)};
      int[] y_Pos  = {0, 0, 0, 0};
      int[] width  = {65, 65, 65, 65};
      int[] height = {100,100,100,100};
      
      character.buildSpiritAction(SpiritActionType.IDLE, 4, x_Pos, y_Pos, width, height);
      
      int[] x__Pos  = {0,(65),(2*65)};
      int[] y__Pos  = {(2*100), (2*100), (2*100)};
      int[] width_  = {63, 65, 65};
      int[] height_ = {100,100,100};
      
      character.buildSpiritAction(SpiritActionType.LEFT_PUNCH, 3, x__Pos, y__Pos, width_, height_);
      int[] x___Pos  = {0,(65),(2*65), (3*65)};
      int[] y___Pos  = {(3*100), (3*100), (3*100), (3*100)};
      int[] width__  = {65, 65, 65, 65};
      int[] height__ = {100,100,100, 100};
      
      character.buildSpiritAction(SpiritActionType.LEFT_KICK, 4, x___Pos, y___Pos, width__, height__);
      
      characterTwo = new Spirit("/Ryu4.gif");
      
      
//      x_Pos  = {0,(65),(2*65),(3*65)};
//      y_Pos  = {0, 0, 0, 0};
//      width  = {65, 65, 65, 65};
//      height = {100,100,100,100};
//      
      characterTwo.buildSpiritAction(SpiritActionType.IDLE, 4, x_Pos, y_Pos, width, height);
            
/*      width   = {65,65,60,68,67,70,60};
      height  = {100,100,100,100,100,100,100};
      int row       = 7;
      int[] columns = {5,5,3,4,5,5,3};
      
      character.buildCharacterSprite("/Ryu.gif", width, height,row, columns);*/
      
      addMouseMotionListener(this);
      addKeyListener(this);
      setVisible(true);
      t = new Thread(this);
      t.start();
	  
	  
	  
  }
  
  public void run(){
	  
	  int i=0, j=0;
	
	  while(true){
		
		  

		  posOne = i;
		  posTwo = j;
		  if(character.hasActionType(actionAnimation) && i<character.getAnimationLenght(actionAnimation)){i++;}
		  else{i=0;}
		  
		  if(characterTwo.hasActionType(actionAnimation) && j<characterTwo.getAnimationLenght(actionAnimation)){j++;}
		  else{j=0;}
		  

		  
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
	  
	  if(character.hasActionType(actionAnimation)){ character.animation(g, actionAnimation, posOne, 100, 100);}
	  if(characterTwo.hasActionType(actionAnimation)){ characterTwo.animation(g, actionAnimation, posTwo, 500, 500);}
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
		actionAnimation =SpiritActionType.IDLE;
	}
	else if(e.getKeyCode() == KeyEvent.VK_CONTROL){		
		actionAnimation =SpiritActionType.LEFT_PUNCH;
	}
	else if(e.getKeyCode() == KeyEvent.VK_UP){		
		actionAnimation =SpiritActionType.LEFT_KICK;
	}
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
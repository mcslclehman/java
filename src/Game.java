import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
 
public class Game extends JFrame {
 
	public static void main(String[] args) {
		new Game();
	}
 
	public Game() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.setSize(800,600);
		this.setVisible(true);
 
		this.createBufferStrategy(2);
 
		gameLoop();
	}
 
	private void gameLoop() {
		// Your game logic goes here.
 
		drawStuff();
		
        try {
            Thread.sleep(20);
        }
        catch (InterruptedException ex){
        }
	}
 
/*	private void drawStuff() {
		// Code for the drawing goes here.
	}*/
	
	private void drawStuff() {
		BufferStrategy bf = this.getBufferStrategy();
		Graphics g = null;
	 
		try {
			g = bf.getDrawGraphics();
	 
			// It is assumed that mySprite is created somewhere else.
			// This is just an example for passing off the Graphics object.
			//mySprite.draw(g);
	 
		} finally {
			// It is best to dispose() a Graphics object when done with it.
			g.dispose();
		}
	 
		// Shows the contents of the backbuffer on the screen.
		bf.show();
	 
	        //Tell the System to do the Drawing now, otherwise it can take a few extra ms until 
	        //Drawing is done which looks very jerky
	       // Toolkit.getDefaultToolkit().sync();	
	}
 
}
import java.applet.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AppletThreads extends Applet implements Runnable, KeyListener {

   int width, height;
   int i = 0;
   Thread t = null;
   boolean threadSuspended;
   int on_off = KeyEvent.VK_SPACE;
   boolean changeContent = false;

 
   public void init() {
      System.out.println("init(): begin");
      width = getSize().width;
      height = getSize().height;
      setBackground( Color.black );
      System.out.println("init(): end");
      addKeyListener(this);
   }

 
   public void destroy() {
      System.out.println("destroy()");
   }
 
   public void start() {
      System.out.println("start(): begin");
      if ( t == null ) {
         System.out.println("start(): creating thread");
         t = new Thread( this );
         System.out.println("start(): starting thread");
         threadSuspended = false;
         t.start();
      }
      else {
         if ( threadSuspended ) {
            threadSuspended = false;
            System.out.println("start(): notifying thread");
            synchronized( this ) {
               notify();
            }
         }
      }
      System.out.println("start(): end");
   }

 
   public void stop() {
      System.out.println("stop(): begin");
      threadSuspended = true;
   }

 
   public void run() {
      System.out.println("run(): begin");
      try {
         while (true) {
            System.out.println("run(): awake");
            
            
            
            if(changeContent){
          	  
          	  setBackground( Color.yellow);
                System.out.println("its yellow now");
            }
            else{
          	  setBackground( Color.black );
                System.out.println("its black now");
            }

          
            ++i;   
            if ( i == 10 ) {
               i = 0;
            }
            showStatus( "i is " + i );

        
            if ( threadSuspended ) {
               synchronized( this ) {
                  while ( threadSuspended ) {
                     System.out.println("run(): waiting");
                     wait();
                  }
               }
            }
            System.out.println("run(): requesting repaint");
            repaint();
            System.out.println("run(): sleeping");
            t.sleep( 1000 );   
         }
      }
      catch (InterruptedException e) { }
      System.out.println("run(): end");
   }

 
   public void paint( Graphics g ) {
      System.out.println("paint()");
      g.setColor( Color.green );
      g.drawLine( width, height, i * width / 10, 0 );
      

   }

@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub

	
}

@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	if (e.getKeyCode() == on_off){
        changeContent = !changeContent;
		
	}
	else{
        System.out.println("Try pressing the space bar");
    }
	
}

@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub

	
}
}
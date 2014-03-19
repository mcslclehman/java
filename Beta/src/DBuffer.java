import java.applet.*;
import java.awt.*;

public class DBuffer extends Applet{
    public static final int WIDTH = 250;
    public static final int HEIGHT = 250;
    Graphics backBuffer;
    Image frontBuffer;
    Image background;
    Image ball;
    int ballX = 36;
    int ballY = 50;
    int ballSpeedX = 5;
    int ballSpeedY = 10;
    int ballWidth = 50;
    Dimension appletSize;
    public void init(){
        this.setSize(WIDTH, HEIGHT);
        appletSize = getSize();
        frontBuffer = createImage(appletSize.width,appletSize.height);
        backBuffer = frontBuffer.getGraphics();
        background = getImage(getDocumentBase(), "wood.png");
        ball = getImage(getDocumentBase(),"ball.png");
        Thread t = new Thread(new MainLoop());
        t.start();
    }
    public class MainLoop implements Runnable{
        public MainLoop(){
        }
        public void run(){
            while(true){
                ballX+=ballSpeedX;
                ballY+=ballSpeedY;
                if(ballX < 0 || ballX > 250-ballWidth){
                    ballSpeedX = -ballSpeedX;
                }
                if(ballY < 0 || ballY > 250-ballWidth){
                    ballSpeedY = -ballSpeedY;
                }
                repaint();
                try {
                    Thread.sleep(20);
                }
                catch (InterruptedException ex){
                }
            }
        }
    }
    public void drawScreen(Graphics display){
        backBuffer.drawImage(background,0,0,null);
        backBuffer.drawImage(ball, ballX, ballY, null);
        backBuffer.drawString("Nice and Smooth",0,240);
        display.drawImage(frontBuffer,0,0,this);
    }
    public void update(Graphics display){
        drawScreen(display);
    }
} 
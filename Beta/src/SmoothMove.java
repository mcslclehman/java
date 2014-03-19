import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SmoothMove extends JPanel implements MouseMotionListener {

  private int mX, mY;

  private Image mImage;


  public static void main(String[] args) {
    JFrame f = new JFrame();
    f.getContentPane().add(new SmoothMove());
    f.setSize(200, 200);
    f.show();
  }
  public SmoothMove() {
    addMouseMotionListener(this);
    setVisible(true);
  }

  public void mouseMoved(MouseEvent me) {
    mX = (int) me.getPoint().getX();
    mY = (int) me.getPoint().getY();
    repaint();
  }

  public void mouseDragged(MouseEvent me) {
    mouseMoved(me);
  }

  public void update(Graphics g) {
    paint(g);
  }

  public void paint(Graphics g) {
    // Clear the offscreen image.
    Dimension d = getSize();
    checkOffscreenImage();
    Graphics offG = mImage.getGraphics();
    offG.setColor(getBackground());
    offG.fillRect(0, 0, d.width, d.height);
    // Draw into the offscreen image.
    paintOffscreen(mImage.getGraphics());
    // Put the offscreen image on the screen.
    g.drawImage(mImage, 0, 0, null);
  }

  private void checkOffscreenImage() {
    Dimension d = getSize();
    if (mImage == null || mImage.getWidth(null) != d.width
        || mImage.getHeight(null) != d.height) {
      mImage = createImage(d.width, d.height);
    }
  }

  public void paintOffscreen(Graphics g) {
    int s = 100;
    g.setColor(Color.blue);
    g.fillRect(mX - s / 2, mY - s / 2, s, s);
  }
}
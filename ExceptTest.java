import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ExceptTest extends JFrame implements ActionListener {
    private double[] a;
  private JRadioButton divideByZeroButton;

  private JRadioButton badCastButton;

  private JRadioButton arrayBoundsButton;

  private JRadioButton nullPointerButton;

  private JRadioButton negSqrtButton;

  private JRadioButton overflowButton;

  private JRadioButton noSuchFileButton;

  private JRadioButton throwUnknownButton;

  public ExceptTest() {
    JPanel p = new JPanel();
    ButtonGroup g = new ButtonGroup();
    p.setLayout(new GridLayout(8, 1));
    divideByZeroButton = addRadioButton("Divide by zero", g, p);
    badCastButton = addRadioButton("Bad cast", g, p);
    arrayBoundsButton = addRadioButton("Array bounds", g, p);
    nullPointerButton = addRadioButton("Null pointer", g, p);
    negSqrtButton = addRadioButton("sqrt(-1)", g, p);
    overflowButton = addRadioButton("Overflow", g, p);
    noSuchFileButton = addRadioButton("No such file", g, p);
    throwUnknownButton = addRadioButton("Throw unknown", g, p);
    getContentPane().add(p);
  }

  private JRadioButton addRadioButton(String s, ButtonGroup g, JPanel p) {
    JRadioButton button = new JRadioButton(s, false);
    button.addActionListener(this);
    g.add(button);
    p.add(button);
    return button;
  }

  public void actionPerformed(ActionEvent evt) {
    try {
      Object source = evt.getSource();
      if (source == divideByZeroButton) {
        a[1] = a[1] / a[1] - a[1];
      } else if (source == badCastButton) {
        Frame f = (Frame) evt.getSource();
      } else if (source == arrayBoundsButton) {
        a[1] = a[10];
      } else if (source == nullPointerButton) {
        Frame f = null;
        f.setSize(200, 200);
      } else if (source == negSqrtButton) {
        a[1] = Math.sqrt(-1);
      } else if (source == overflowButton) {
        a[1] = 1000 * 1000 * 1000 * 1000;
        int n = (int) a[1];
      } else if (source == noSuchFileButton) {
        FileInputStream is = new FileInputStream("Java Source and Support");
      } else if (source == throwUnknownButton) {
        throw new UnknownError();
      }
    } catch (RuntimeException e) {
      System.out.println("Caught RuntimeException: " + e);
    } catch (Exception e) {
      System.out.println("Caught Exception: " + e);
    }
  }

  public static void main(String[] args) {
    JFrame frame = new ExceptTest();
    frame.setSize(150, 200);
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    frame.show();
  }
}
           
         
    
    

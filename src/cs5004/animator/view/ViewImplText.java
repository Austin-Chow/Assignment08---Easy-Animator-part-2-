package cs5004.animator.view;

import java.awt.*;

import javax.swing.*;

public class ViewImplText extends JFrame implements IView {
  private JLabel display;
  private JPanel panel;

  public ViewImplText(String caption) {
    super(caption);

    setSize(500, 300);
    setLocation(200, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //this.setResizable(false);
//		this.setMinimumSize(new Dimension(300,300));


    this.setLayout(new FlowLayout());

    panel = new JPanel();

    this.add(panel);
    pack();
  }

  //@Override
  public void display() {
    setVisible(true);
  }
}

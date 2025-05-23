package main;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;

public class GWin {
    private JFrame jframe;
    public GWin(Gpanel gpanel)
    {
        jframe= new JFrame();
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.add(gpanel);
        jframe.setLocationRelativeTo(null);
        jframe.setResizable(false);
        jframe.pack();
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
        jframe.addWindowFocusListener(new WindowFocusListener() {

            @Override
            public void windowLostFocus(WindowEvent e) {
                gpanel.getGeme().windowFocusLost();
            }

            @Override
            public void windowGainedFocus(WindowEvent e) {

            }
        });
    }
}

package lean.swing;

import javax.swing.*;

public class LeanSwing extends JFrame {
    public static void  leanSwing() {
        JFrame jf = new JFrame();
        jf.setBounds(100,100,400,400);
        JButton button = new JButton();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}

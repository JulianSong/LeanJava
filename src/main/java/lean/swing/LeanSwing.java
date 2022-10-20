package lean.swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeanSwing extends JFrame implements ActionListener {
    public static void  leanSwing() {
        LeanSwing jf = new LeanSwing();
        jf.setBounds(100,100,400,400);

        JPanel jp = new JPanel();
        jf.getContentPane().add(jp);
        JButton button = new JButton("Ok");
        button.setBounds(0,0,40,10);
        button.addActionListener(jf);
        jp.add(button);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getSource());
    }
}

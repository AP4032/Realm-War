package View;

import Controller.Merge;

import javax.swing.*;
import java.awt.*;

public class MenuPanel {
    private JFrame frame ;
    private JPanel panel;
    private JPanel userpanel;
    public JButton[][] button = new JButton[12][12];

    public MenuPanel() {
        frame = new JFrame("Realm-War");
        panel = new JPanel(new GridLayout(12,12,5,5));
        userpanel = new JPanel(new BorderLayout());
    createmap();
    }

    public  static void main(String[] args) {
        MenuPanel panel = new MenuPanel();
    }
public void createmap(){
    Merge merge  = new Merge(this);
        frame.setLayout(new BorderLayout());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    frame.setUndecorated(false);
    frame.setLocationRelativeTo(null);
    frame.setResizable(true);
    JLabel label = new JLabel("userpanel");
        for(int i = 0; i < 12; i++){
            for(int j = 0; j < 12; j++){
button[i][j] = new JButton();
                button[i][j].setPreferredSize(new Dimension(5,5));
                if(i == 0 || i == 11 ||  j == 0 || j == 11){
                    button[i][j].setBackground(Color.BLACK);
                }else {
                    button[i][j].setBackground(Color.GRAY);
                }



            }



        }
    merge.test();

for (int i = 0; i < 12; i++) {
    for (int j = 0; j < 12; j++) {
        panel.add(button[i][j]);
    }
}

        userpanel.add(label);
        userpanel.setPreferredSize(new Dimension(100,100));
        frame.add(panel, BorderLayout.CENTER);
        frame.add(userpanel, BorderLayout.SOUTH);
    frame.setVisible(true);
}

}

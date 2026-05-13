import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    Timer updateTimer;
    ActionListener guiUpdate;
    JFrame frame;
    JPanel panel;
    JLabel numCookies;
    JButton cookiesButton;
    JButton buyButton;
    JButton buyButton2;
    Game game;


    public GUI(Game game) {
        this.game = game;
        frame = new JFrame();
        guiUpdate = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                numCookies.setText("Cookies:" + game.cookies);
            }
        };
        updateTimer = new Timer(500,guiUpdate);
        updateTimer.start();

        cookiesButton = new JButton("Cookies");
        cookiesButton.setPreferredSize(new Dimension(200, 200));
        cookiesButton.addActionListener(e -> buttonClick("cookie"));
        buyButton = new JButton("Cursor Upgrade");
        buyButton.setPreferredSize(new Dimension(200, 200));
        buyButton.addActionListener(e -> buttonClick("buy"));
        buyButton2 = new JButton("Autoclick");
        buyButton2.setPreferredSize(new Dimension(200, 200));
        buyButton2.addActionListener(e -> buttonClick("buy2"));

        numCookies = new JLabel("Cookies:");
        numCookies.setPreferredSize(new Dimension(200, 200));


        panel = new JPanel();
        panel.add(numCookies);
        panel.add(cookiesButton);
        panel.add(buyButton);
        panel.add(buyButton2);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setLayout(new GridLayout(1,5));
        panel.setSize(600,200);

        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(panel, BorderLayout.NORTH);
        frame.setVisible(true);




    }

    public void buttonClick(@NotNull String button) {
        if (button.equals("cookie")) {
            game.click();
            numCookies.setText("Cookies:" + game.cookies);
        } else if (button.equals("buy")) {
            if (!game.buyBuilding("bdlg1")) {
                //create error box
                JOptionPane.showMessageDialog(frame, "Not enough cookies");
            }
        } else if (button.equals("buy2")) {
            if (!game.buyBuilding("bdlg2")) {
                //create error box
                JOptionPane.showMessageDialog(frame, "Not enough cookies");
            }
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {



    }





}

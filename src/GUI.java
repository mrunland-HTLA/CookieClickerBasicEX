import org.jetbrains.annotations.NotNull;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    Timer updateTimer;
    ActionListener guiUpdate;
    JFrame frame;
    JPanel panel;
    JPanel stats;
    JLabel buildCost;
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
                buildCost.setText("Build Cost: " + game.multiplier.getPrice());
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

        numCookies = new JLabel("Cookies:" + game.cookies);
        numCookies.setPreferredSize(new Dimension(200, 200));
        buildCost = new JLabel("Build Cost: "+ (int) game.multiplier.getPrice());
        buildCost.setPreferredSize(new Dimension(200, 200));


        try {
            Image img = ImageIO.read(getClass().getResource("cookie_640_629.png"));
            ImageIcon cookieIcon = new ImageIcon(img);
            ImageIcon icon = new ImageIcon("cookie_640_629.png");
            cookiesButton.setIcon(cookieIcon);
        } catch (Exception ex) {
            System.out.println(ex);
        }




        panel = new JPanel();
        stats = new JPanel();
        stats.setLayout(new BoxLayout(stats,BoxLayout.Y_AXIS));
        stats.add(buildCost);
        stats.add(numCookies);
        stats.setSize(200, 200);
        panel.add(stats);
        panel.add(cookiesButton);
        panel.add(buyButton);
        panel.add(buyButton2);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setLayout(new GridLayout(1,5));
        panel.setSize(800,200);

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
            buildCost.setText("Build Cost:" + game.multiplier.getPrice());
            if (!game.buyBuilding("bdlg1")) {
                //create error box
                JOptionPane.showMessageDialog(frame, "Not enough cookies");
            }
        } else if (button.equals("buy2")) {
            buildCost.setText("Build Cost:" + game.multiplier.getPrice());
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

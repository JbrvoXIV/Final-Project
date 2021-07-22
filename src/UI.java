import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI{

    JFrame gameWindow;
    JPanel startQuitPanel, titlePanel, dungeonTextPanel,choicePanel, hudPanel, enemyHPPanel;
    JLabel titleLabel, hpLabel, hpNumLabel, potionLabel, potionNumLabel, levelLabel, levelNumLabel, enemyHPLabel,
            enemyHPNumLabel;
    JButton startButton, quitButton, choiceAttack = new JButton("Attack"),
            choicePotion = new JButton("Potion"), choiceFlee = new JButton("Flee");
    JTextArea dungeonText = new JTextArea();
    Font titleFont = new Font("Serif", Font.ITALIC, 90);
    Font regFont = new Font("Serif", Font.PLAIN, 25);
    Container container;

    // START MENU
    public UI() {
        gameWindow = new JFrame();
        startQuitPanel = new JPanel();
        startButton = new JButton("Start!");
        quitButton = new JButton("Quit...");
        titlePanel = new JPanel();
        titleLabel = new JLabel("-DUNGEON DIVE-");
        container = new Container();

        // MAIN MENU WINDOW
        gameWindow.setVisible(true);
        gameWindow.setSize(800, 600);
        gameWindow.getContentPane().setBackground(Color.black);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setLayout(null);
        gameWindow.setResizable(false);
        container = gameWindow.getContentPane();

        // TITLE OF GAME
        titlePanel.setVisible(true);
        titlePanel.setBounds(0, 150, 800, 200);
        titlePanel.setBackground(Color.black);
        titleLabel.setFont(titleFont);
        titleLabel.setForeground(Color.white);
        titlePanel.add(titleLabel);
        container.add(titlePanel);

        // START AND QUIT BUTTON
        startQuitPanel.setBounds(250, 400, 300, 150);
        startQuitPanel.setBackground(Color.black);
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(regFont);
        startButton.addActionListener(new StartHandler());
        startButton.setFocusPainted(false);

        quitButton.setBackground(Color.black);
        quitButton.setForeground(Color.white);
        quitButton.setFont(regFont);
        quitButton.addActionListener(new QuitHandler());
        quitButton.setFocusPainted(false);

        startQuitPanel.add(startButton);
        startQuitPanel.add(quitButton);
        container.add(startQuitPanel);

    }

    // MAIN GAME SCREEN
    public void gameScreen(){
        dungeonTextPanel = new JPanel();
        choicePanel = new JPanel();
        hudPanel = new JPanel();
        enemyHPPanel = new JPanel();
        hpLabel = new JLabel("Health:");
        potionLabel = new JLabel("Potions:");
        levelLabel = new JLabel("Level:");
        enemyHPLabel = new JLabel("Enemy Health: ");
        hpNumLabel = new JLabel("150");
        potionNumLabel = new JLabel("3");
        levelNumLabel = new JLabel("1");
        enemyHPNumLabel = new JLabel("100");

        // MOVE FROM MAIN SCREEN TO MAIN SCREEN
        titlePanel.setVisible(false);
        startQuitPanel.setVisible(false);

        // MAIN TEXT PANEL FOR GAME
        dungeonTextPanel.setBounds(100, 100, 600, 200);
        dungeonTextPanel.setBackground(Color.black);
        dungeonTextPanel.setLayout(new GridBagLayout());
        dungeonText.setBounds(100, 50, 500, 300);
        dungeonText.setBackground(Color.black);
        dungeonText.setForeground(Color.white);
        dungeonText.setFont(regFont);
        dungeonText.setLineWrap(true);
        dungeonText.setEditable(false);
        dungeonTextPanel.add(dungeonText);
        container.add(dungeonTextPanel);

        // CHOICE BUTTONS AND PANEL
        choicePanel.setBounds(300, 400, 200, 150);
        choicePanel.setBackground(Color.black);
        choicePanel.setLayout(new GridLayout(4, 1, 0, 5));
        container.add(choicePanel);

        choiceAttack.setBackground(Color.black);
        choiceAttack.setForeground(Color.white);
        choiceAttack.setFont(regFont);
        choiceAttack.setFocusPainted(false);
        choicePanel.add(choiceAttack);

        choicePotion.setBackground(Color.black);
        choicePotion.setForeground(Color.white);
        choicePotion.setFont(regFont);
        choicePotion.setFocusPainted(false);
        choicePanel.add(choicePotion);

        choiceFlee.setBackground(Color.black);
        choiceFlee.setForeground(Color.white);
        choiceFlee.setFont(regFont);
        choiceFlee.setFocusPainted(false);
        choicePanel.add(choiceFlee);

        // PLAYER HUD
        hudPanel.setBounds(20, 10, 750, 60);
        hudPanel.setBackground(Color.black);
        hudPanel.setLayout(new GridLayout(1, 6));
        container.add(hudPanel);

        hpLabel.setForeground(Color.white);
        hpLabel.setFont(regFont);
        hpNumLabel.setForeground(Color.white);
        hpNumLabel.setFont(regFont);
        hudPanel.add(hpLabel);
        hudPanel.add(hpNumLabel);

        potionLabel.setForeground(Color.white);
        potionLabel.setFont(regFont);
        potionNumLabel.setForeground(Color.white);
        potionNumLabel.setFont(regFont);
        hudPanel.add(potionLabel);
        hudPanel.add(potionNumLabel);

        levelLabel.setForeground(Color.white);
        levelLabel.setFont(regFont);
        levelNumLabel.setForeground(Color.white);
        levelNumLabel.setFont(regFont);
        hudPanel.add(levelLabel);
        hudPanel.add(levelNumLabel);

        // ENEMY HUD
        enemyHPPanel.setBounds(200, 300, 400, 80);
        enemyHPPanel.setBackground(Color.black);
        enemyHPLabel.setForeground(Color.white);
        enemyHPLabel.setFont(regFont);
        enemyHPNumLabel.setForeground(Color.white);
        enemyHPNumLabel.setFont(regFont);
        enemyHPPanel.add(enemyHPLabel);
        enemyHPPanel.add(enemyHPNumLabel);
        container.add(enemyHPPanel);
    }

    // GAME LOST EXIT
    public void endGameLoss(){
        hpNumLabel.setText("0");
        int okButton = JOptionPane.showConfirmDialog(null, "You died! " +
                "Press 'OK' to exit.", "GAME OVER", JOptionPane.DEFAULT_OPTION);
        if (okButton == 0) {
            System.exit(0);
        }
    }

    // GAME WON EXIT
    public void endGameWin(){
        enemyHPNumLabel.setText("0");
        int okButton = JOptionPane.showConfirmDialog(null, "Congrats, you've conquered the dungeon!"
                + " Press 'OK' to exit.", "GAME OVER", JOptionPane.DEFAULT_OPTION);
        if (okButton == 0) {
            System.exit(0);
        }
    }

    // START BUTTON ACTION
    public class StartHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            gameScreen();
        }
    }

    // QUIT BUTTON ACTION
    public static class QuitHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}

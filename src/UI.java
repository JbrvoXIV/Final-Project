import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI{

    JFrame gameWindow;
    JPanel startQuitPanel, titlePanel, dungeonTextPanel, choicePanel;
    JLabel titleLabel;
    JButton startButton, quitButton, choiceAttack, choicePotion, choiceFlee;
    JTextArea dungeonText;
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
        startButton.addActionListener(new ActionHandler());
        quitButton.setBackground(Color.black);
        quitButton.setForeground(Color.white);
        quitButton.setFont(regFont);
        quitButton.addActionListener(new QuitHandler());
        startQuitPanel.add(startButton);
        startQuitPanel.add(quitButton);
        container.add(startQuitPanel);

    }

    // MAIN GAME SCREEN
    public void gameScreen(){
        GridLayout layout = new GridLayout(4,1);
        dungeonTextPanel = new JPanel();
        dungeonText = new JTextArea("This is the main text area. Placeholder text @@@@@@@@@@@@@@@@@@@@@@@@");
        choicePanel = new JPanel();
        choiceAttack = new JButton("Attack");
        choicePotion = new JButton("Potion");
        choiceFlee = new JButton("Flee");

        // MOVE FROM MAIN SCREEN TO MAIN SCREEN
        titlePanel.setVisible(false);
        startQuitPanel.setVisible(false);

        // MAIN TEXT PANEL FOR GAME
        dungeonTextPanel.setBounds(100, 100, 600, 300);
        dungeonTextPanel.setBackground(Color.black);
        dungeonText.setBounds(0, 100, 450, 300);
        dungeonText.setBackground(Color.black);
        dungeonText.setForeground(Color.white);
        dungeonText.setFont(regFont);
        dungeonText.setLineWrap(true);
        dungeonTextPanel.add(dungeonText);
        container.add(dungeonTextPanel);

        // CHOICE BUTTONS AND PANEL
        layout.setVgap(5);
        choicePanel.setBounds(300, 400, 200, 150);
        choicePanel.setBackground(Color.black);
        choicePanel.setLayout(layout);
        container.add(choicePanel);

        choiceAttack.setBackground(Color.black);
        choiceAttack.setForeground(Color.white);
        choiceAttack.setFont(regFont);
        choicePanel.add(choiceAttack);
        choicePotion.setBackground(Color.black);
        choicePotion.setForeground(Color.white);
        choicePotion.setFont(regFont);
        choicePanel.add(choicePotion);
        choiceFlee.setBackground(Color.black);
        choiceFlee.setForeground(Color.white);
        choiceFlee.setFont(regFont);
        choicePanel.add(choiceFlee);
    }

    // START BUTTON ACTION
    public class ActionHandler implements ActionListener{

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

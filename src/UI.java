import javax.swing.*;
import java.awt.*;

public class UI{

    JFrame gameWindow;
    JPanel startQuitPanel, titlePanel;
    JLabel titleLabel;
    JButton startButton, quitButton;
    Font titleFont = new Font("Serif", Font.ITALIC, 90);
    Font startFont = new Font("Serif", Font.PLAIN, 25);
    Font quitFont = new Font("Serif", Font.PLAIN, 25);
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
        startButton.setFont(startFont);
        quitButton.setBackground(Color.black);
        quitButton.setForeground(Color.white);
        quitButton.setFont(quitFont);
        startQuitPanel.add(startButton);
        startQuitPanel.add(quitButton);
        container.add(startQuitPanel);

    }
}

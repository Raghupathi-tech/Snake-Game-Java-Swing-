import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements ActionListener {

    final int WIDTH = 600;
    final int HEIGHT = 600;
    int x = 100, y = 100;
    int foodX = 300, foodY = 300;
    int score = 0;

    Timer timer;

    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);

        timer = new Timer(100, this);
        timer.start();

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT -> x -= 20;
                    case KeyEvent.VK_RIGHT -> x += 20;
                    case KeyEvent.VK_UP -> y -= 20;
                    case KeyEvent.VK_DOWN -> y += 20;
                }
                repaint();
            }
        });

        setFocusable(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.GREEN);
        g.fillRect(x, y, 20, 20);

        g.setColor(Color.RED);
        g.fillOval(foodX, foodY, 20, 20);

        g.setColor(Color.WHITE);
        g.drawString("Score: " + score, 20, 20);
    }

    public void actionPerformed(ActionEvent e) {
        if (x == foodX && y == foodY) {
            score++;
            foodX = (int)(Math.random() * 500);
            foodY = (int)(Math.random() * 500);
        }
        repaint();
    }
}

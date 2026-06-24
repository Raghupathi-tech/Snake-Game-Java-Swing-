import javax.swing.JFrame;

public class SnakeGame {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Snake Game");
        GamePanel panel = new GamePanel();

        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
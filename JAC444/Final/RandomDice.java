package Final;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RandomDice extends JFrame {

    private DiceDrawing diceDrawing = new DiceDrawing();
    private JButton rollDice = new JButton("Roll Dice");

    public RandomDice() {
        JPanel panelButton = new JPanel();
        rollDice.setSize(40, 40);
        panelButton.add(rollDice);
        this.add(diceDrawing, BorderLayout.CENTER);
        this.add(panelButton, BorderLayout.SOUTH);

        rollDice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                diceDrawing.rollDice();
                diceDrawing.repaint();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new RandomDice();
        frame.setTitle("Random Dice");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    class DiceDrawing extends JPanel {

        private Random random = new Random();
        private int dice1Value = 1; // Initialize to 1 dot
        private int dice2Value = 1; // Initialize to 1 dot

        public void rollDice() {
            dice1Value = random.nextInt(6) + 1;
            dice2Value = random.nextInt(6) + 1;
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // left
            g.drawRect(40, 20, 100, 100);
            drawDiceDots(g, dice1Value, 100, 40, 20);

            // right
            g.drawRect(160, 20, 100, 100);
            drawDiceDots(g, dice2Value, 100, 160, 20);
        }

        private void drawDiceDots(Graphics g, int dots, int size, int x, int y) {
            g.setColor(Color.BLACK);
            int dotSize = size / 7;
            int offset = dotSize / 2;
            int middle = size / 2;

            int dot1X = x + middle - offset;
            int dot1Y = y + middle - offset;

            int dot2X = dot1X - 2 * dotSize;
            int dot2Y = dot1Y - 2 * dotSize;

            int dot3X = dot1X + 2 * dotSize;
            int dot3Y = dot1Y + 2 * dotSize;

            int dot4X = dot1X + 2 * dotSize;
            int dot4Y = dot1Y - 2 * dotSize;

            int dot5X = dot1X - 2 * dotSize;
            int dot5Y = dot1Y + 2 * dotSize;

            int dot6X = dot1X - 2 * dotSize;
            int dot6Y = dot1Y - 2 * dotSize;

            if (dots == 1) {
                g.fillOval(dot1X, dot1Y, dotSize, dotSize);
            } else if (dots == 2) {
                g.fillOval(dot2X, dot2Y, dotSize, dotSize);
                g.fillOval(dot3X, dot3Y, dotSize, dotSize);
            } else if (dots == 3) {
                g.fillOval(dot2X, dot2Y, dotSize, dotSize);
                g.fillOval(dot3X, dot3Y, dotSize, dotSize);
                g.fillOval(dot1X, dot1Y, dotSize, dotSize);
            } else if (dots == 4) {
                g.fillOval(dot2X, dot2Y, dotSize, dotSize);
                g.fillOval(dot3X, dot3Y, dotSize, dotSize);
                g.fillOval(dot4X, dot4Y, dotSize, dotSize);
                g.fillOval(dot5X, dot5Y, dotSize, dotSize);
            } else if (dots == 5) {
                g.fillOval(dot2X, dot2Y, dotSize, dotSize);
                g.fillOval(dot3X, dot3Y, dotSize, dotSize);
                g.fillOval(dot4X, dot4Y, dotSize, dotSize);
                g.fillOval(dot5X, dot5Y, dotSize, dotSize);
                g.fillOval(dot1X, dot1Y, dotSize, dotSize);
            } else if (dots == 6) {
                g.fillOval(dot2X, dot2Y, dotSize, dotSize);
                g.fillOval(dot3X, dot3Y, dotSize, dotSize);
                g.fillOval(dot4X, dot4Y, dotSize, dotSize);
                g.fillOval(dot5X, dot5Y, dotSize, dotSize);
                g.fillOval(dot6X, dot6Y, dotSize, dotSize);
                g.fillOval(dot1X, dot1Y, dotSize, dotSize);
            }
        }
    }
}

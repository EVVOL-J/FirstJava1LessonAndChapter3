package java1.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WindowTicTacToe extends JFrame {
    private final TicTacToe ticTacToe;
    private final int OFFSET_X = 15;
    private final int OFFSET_Y = 31;



    WindowTicTacToe(TicTacToe ticTacToe) {
        this.ticTacToe = ticTacToe;
        setTitle("TicTacToe");
        setBounds(700, 300, 500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int sizeCube = Math.min(getContentPane().getWidth(), getLayeredPane().getHeight()) / TicTacToe.SIZE_FILED;
                int x = (int) Math.floor((e.getX() - OFFSET_X) /  (sizeCube));
                int y = (int) Math.floor((e.getY() - OFFSET_Y) / (sizeCube));
                if (x < TicTacToe.SIZE_FILED && y < TicTacToe.SIZE_FILED)
                    if (ticTacToe.humanTry(x, y)) {
                        checkWinAndDraw(TicTacToe.CHAR_X);
                        ticTacToe.computerTry();
                        checkWinAndDraw(TicTacToe.CHAR_O);
                    }
                repaint();
            }
        });


    }


    private void checkWinAndDraw(char c) {
        if (ticTacToe.checkWin(c)) {
            repaint();
            if (c == TicTacToe.CHAR_X) showMessage("Вы выиграли");
            else showMessage("Вы проиграли");
            this.getContentPane().removeAll();
            ticTacToe.clearArray();
            return;

        }
        if (ticTacToe.chekDraw()) {
            repaint();
            showMessage("Ничья");
            this.getContentPane().removeAll();
            ticTacToe.clearArray();
        }
    }

    public static void showMessage(String message) {
        JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
                JOptionPane.WARNING_MESSAGE);
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);


        printArray(g);


    }

    private void printArray(Graphics g2d) {

        char[][] array = ticTacToe.getArray();
        int sizeCube = Math.min(this.getContentPane().getWidth(), this.getLayeredPane().getHeight()) / TicTacToe.SIZE_FILED;
        int radius = sizeCube / 2;
        int innerRadius = sizeCube / 2 - 10;
        int xOffset = sizeCube / 5;

        for (int i = 0; i < TicTacToe.SIZE_FILED; i++) {
            printGrid(g2d, sizeCube);
            for (int j = 0; j < TicTacToe.SIZE_FILED; j++) {

                if (array[i][j] == TicTacToe.CHAR_X) {
                    g2d.setColor(Color.BLUE);
                    g2d.drawLine(sizeCube * i + OFFSET_X + xOffset, sizeCube * j + OFFSET_Y + xOffset, sizeCube * i + sizeCube + OFFSET_X - xOffset, sizeCube * j + sizeCube + OFFSET_Y - xOffset);
                    g2d.drawLine(sizeCube * i + OFFSET_X + xOffset, sizeCube * j + sizeCube + OFFSET_Y - xOffset, sizeCube * i + sizeCube + OFFSET_X - xOffset, sizeCube * j + OFFSET_Y + xOffset);
                } else if (array[i][j] == TicTacToe.CHAR_O) {

                    g2d.setColor(Color.GREEN);
                    g2d.fillOval((int) ((i + 0.5) * sizeCube + OFFSET_X - radius / 2), (int) ((j + 0.5) * sizeCube + OFFSET_Y - radius / 2), radius, radius);
                    g2d.setColor(Color.WHITE);
                    g2d.fillOval((int) ((i + 0.5) * sizeCube + OFFSET_X - (innerRadius) / 2), (int) ((j + 0.5) * sizeCube + OFFSET_Y - innerRadius / 2), innerRadius, innerRadius);

                }

            }
        }
    }

    private void printGrid(Graphics g2d, int sizeCube) {
        g2d.setColor(Color.BLACK);
        int size = TicTacToe.SIZE_FILED;
        for (int i = 0; i <= size; i++) {
            g2d.drawLine(OFFSET_X + sizeCube * i, OFFSET_Y, OFFSET_X + sizeCube * i, sizeCube * size + OFFSET_Y);
            g2d.drawLine(OFFSET_X, OFFSET_Y + sizeCube * i, OFFSET_X + sizeCube * size, OFFSET_Y + sizeCube * i);

        }


    }
}


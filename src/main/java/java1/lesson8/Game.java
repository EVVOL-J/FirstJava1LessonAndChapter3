package java1.lesson8;

import java.awt.*;

public class Game {

    public static void main(String[] args) {
        TicTacToe ticTacToe=new TicTacToe();

        EventQueue.invokeLater(() -> new WindowTicTacToe(ticTacToe));

    }

}

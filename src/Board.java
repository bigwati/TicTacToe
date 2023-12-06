import java.util.Arrays;
import java.util.Scanner;

public class Board {
    String[][] board;

    public Board(String[][] board){
        this.board = board;
        Arrays.stream(this.board).forEach(a -> Arrays.fill(a, "[ ]"));
    }

    public void printBoard(){
        for (String[] row : this.board) {
            for (String value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public void xMove(){
        System.out.println("X it's your turn");
        Scanner input = new Scanner(System.in);
        String xMove = input.next();

        int i = Character.getNumericValue(xMove.charAt(0)) - 1;
        int j = Character.getNumericValue(xMove.charAt(1)) - 1;
        this.board[i][j] = "[x]";
    }
}

import java.util.Arrays;

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
}

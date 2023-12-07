import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

public class Board {
    String[][] board;

    public Board(String[][] board){
        this.board = board;
        Arrays.stream(this.board).forEach(a -> Arrays.fill(a, "[ ]"));

        this.board[0][0] = "  ";
        for (int i = 1; i < this.board.length; i++){
            this.board[i][0] = String.valueOf(i);
        }
        for (int i = 1; i < this.board.length; i++){
            //this.board[i][0] = String.valueOf(i);
            int l = 1;
            for (int k = 'A' ; k < 'D'; k++){
                this.board[0][l] = (char)k + "  ";
                l++;
            }
        }
    }

    public void printBoard(){
        for (String[] row : this.board) {
            for (String value : row) {
                System.out.print(value + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void xMove(){
        System.out.println("X it's your turn");
        Scanner input = new Scanner(System.in);
        String xMove = input.next();

        while(Character.getNumericValue(xMove.charAt(0))-9 > 3
                || Character.getNumericValue(xMove.charAt(0))-9 < 1
                || Character.getNumericValue(xMove.charAt(1)) < 1
                || Character.getNumericValue(xMove.charAt(1)) > 3
                || xMove.length() != 2){
            System.out.println(wrongInput());
            xMove = input.next();
        }

        int i = Character.getNumericValue(xMove.charAt(0))-9;
        int j = Character.getNumericValue(xMove.charAt(1));
        this.board[j][i] = "[x]";
    }
    public void oMove(){
        System.out.println("O it's your turn");
        Scanner input = new Scanner(System.in);
        String oMove = input.next();

        while(Character.getNumericValue(oMove.charAt(0))-9 > 3
                || Character.getNumericValue(oMove.charAt(0))-9 < 1
                || Character.getNumericValue(oMove.charAt(1)) < 1
                || Character.getNumericValue(oMove.charAt(1)) > 3
                || oMove.length() != 2){
            System.out.println(wrongInput());
            oMove = input.next();
        }

        int i = Character.getNumericValue(oMove.charAt(0))-9;
        int j = Character.getNumericValue(oMove.charAt(1));
        this.board[i][j] = "[o]";
    }

    public String wrongInput(){
        String[] output = {"You're an idiot, try again",
                "It's not so hard, try again",
                "Try again, i believe in you",
                "It's easier than it looks, try again"};
        Random r = new Random();
        return output[r.nextInt(output.length)];
    }
}

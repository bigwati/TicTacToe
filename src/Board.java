import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

public class Board {
    String[][] board;
    int firstChar = 0;
    int secondChar = 0;

    public Board(Integer boardSize){
        this.board = new String[boardSize][boardSize];
        this.board[0][0] = "  ";
        Arrays.stream(this.board).forEach(a -> Arrays.fill(a, " "));
    }

    public void printBoard(){
        System.out.print("   ");
        for(char i = 'A'; i < this.board.length + 'A'; i++){
            System.out.print(i + "   ");
        }
        System.out.println();
        int i =1;
        for (String[] row : this.board) {
            System.out.print(i + " ");
            for (String value : row) {
                System.out.print("[" + value + "]" + " ");
            }
            System.out.println();
            i++;
        }
        System.out.println();
    }

    public void userMove(String playerSymbol){
        System.out.println(playerSymbol + " it's your turn");

        inputCheck();

        this.board[secondChar][firstChar] = playerSymbol;
    }

    public void inputCheck(){
        Scanner input = new Scanner(System.in);
        String userMove = "";

        int i = 0;

        do {
            if(i > 0){
                System.out.println(wrongInput());
            }

            userMove = input.next().toUpperCase();
            if(userMove.length() == 2){
                firstChar = Character.getNumericValue(userMove.charAt(0))-10;
                secondChar = Character.getNumericValue(userMove.charAt(1))-1;
            }
            i++;
        }
        while(firstChar < 0
                || firstChar >= this.board.length
                || secondChar < 0
                || secondChar >= this.board.length
                || userMove.length() != 2
                || !this.board[secondChar][firstChar].equals(" "));
    }

    public boolean winCheck(String playerSymbol){
        for(int i = 1; i < this.board.length-1; i++){
            for(int j = 1; j < this.board.length-1; j++) {
                if (!this.board[i][j].equals(" ") &
                        ((this.board[i][j].equals(this.board[i-1][j-1]) & this.board[i][j].equals(this.board[i+1][j+1]))
                        || (this.board[i][j].equals(this.board[i+1][j-1]) & this.board[i][j].equals(this.board[i-1][j+1])))
                    ) {
                    System.out.println(playerSymbol + " won!");
                    return false;
                }
            }
        }

        for(int i = 1; i < this.board.length-1; i++){
            for(int j = 0; j < this.board.length; j++) {
                if (!this.board[i][j].equals(" ") & (this.board[i][j].equals(this.board[i-1][j]) & this.board[i][j].equals(this.board[i+1][j]))
                                ||!this.board[j][i].equals(" ") & ((this.board[j][i].equals(this.board[j][i-1]) & this.board[j][i].equals(this.board[j][i+1])))
                ) {
                    System.out.println(playerSymbol + " won!");
                    return false;
                }
            }
        }

        return true;
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

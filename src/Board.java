import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

public class Board {
    String[][] board;

    public Board(Integer boardSize){
        this.board = new String[boardSize][boardSize];
        this.board[0][0] = "  ";
        Arrays.stream(this.board).forEach(a -> Arrays.fill(a, " "));
    }

    public void printBoard(){
        System.out.println("   A   B   C");
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
        Scanner input = new Scanner(System.in);

        char lastColumnIndex = (char)(this.board.length+'A');
        List<Character> columnIndexes = new ArrayList<>();
        for(char i='A'; i < lastColumnIndex; i++) {
            columnIndexes.add(i);
        }

        String userMove;
        char firstChar;
        int secondChar;
        int i = 0;
        do {
            if(i >= 1){
                System.out.println(wrongInput());
            }
            userMove = input.next().toUpperCase();
            while(userMove.length() != 2){
                System.out.println(wrongInput());
                userMove = input.next().toUpperCase();
            }
            firstChar = userMove.charAt(0);
            secondChar = Character.getNumericValue(userMove.charAt(1))-1;
            i++;
        }while(!columnIndexes.contains(firstChar) || secondChar < 0 || secondChar > 2);

        this.board[secondChar][Character.getNumericValue(firstChar)-10] = playerSymbol;
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

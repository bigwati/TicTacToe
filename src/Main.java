public class Main {
    public static void main(String[] args) {
        Board myGame = new Board(3);

        myGame.printBoard();

        myGame.userMove("x");
        myGame.printBoard();

        myGame.userMove("o");
        myGame.printBoard();
    }
}

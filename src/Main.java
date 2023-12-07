public class Main {
    public static void main(String[] args) {
        Board myGame = new Board(new String[4][4]);

        myGame.printBoard();

        myGame.xMove();
        myGame.printBoard();

        myGame.oMove();
        myGame.printBoard();
    }
}

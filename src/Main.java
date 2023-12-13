public class Main {
    public static void main(String[] args) {

        Board myGame = new Board(4);

        myGame.printBoard();
        String playerSymbol;


        do{
            playerSymbol = "x";
            myGame.userMove(playerSymbol);
            myGame.printBoard();

            if(!myGame.winCheck(playerSymbol)){
                break;
            }

            playerSymbol = "o";
            myGame.userMove("o");
            myGame.printBoard();

        }while(myGame.winCheck(playerSymbol));

    }
}

import java.util.Scanner;
public class demo {
    public static void main(String[] args) {
        SlowPiece a = new SlowPiece("piece", "red", 1,4 );
        System.out.println(a);
        Board gameBoard = new Board();

        //input example:
        //create location [fast][flexible] [name][colour]
        //move location direction [spaces]
        //print
        //help
        //exit
        //we can add a switch menu with options for this
        boolean gameOn = true;
        String playerInput;
        Scanner in = new Scanner(System.in);
        while(gameOn){
            playerInput =in.next();
            switch(playerInput){
                case "create":
                    System.out.println("location(x y) [fast][flexible] [name][colour]");
                    gameBoard.addPiece(in.nextInt(),in.nextInt(),in.next(),in.next(),in.next(),in.next());
                    break;
                case "move":
                    break;
                case "print":
                    break;
                case "help":
                    break;
                case "exit":
                    gameOn = false;
                    break;
            }
        }
    }
}

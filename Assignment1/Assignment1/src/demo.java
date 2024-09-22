import java.util.Scanner;
public class demo {
     public static  Board gameBoard = new Board();
    public static void main(String[] args) {


        boolean gameOn = true;
        String playerInput;
        Scanner in = new Scanner(System.in);
        //main game loop
        while(gameOn){

            System.out.println("Enter a command (type help for details):");
            playerInput =in.next();
            //main menu
            switch(playerInput){
                case "create":
                    System.out.println("[x position][y position] [fast][flexible] [name][colour]");
                    gameBoard.addPiece(in.nextInt(),in.nextInt(),in.next(),in.next(),in.next(),in.next());
                    break;
                case "move":
                    //[x position][y position] [left/right/up/down][# of spaces moved]
                    //# number of spaces can be a loop, the move() function can be kept simpler that way
                    System.out.println("[x position][y position] [left/right/up/down][# of spaces moved]");
                    int xpos = in.nextInt(); int ypos= in.nextInt();
                     gameBoard.getBoard()[ypos][xpos].move(in.next());
                     in.nextInt();

                    break;
                case "print":
                    break;
                case "help":
                    System.out.println("create : [x position][y position] [fast/slow][flexible/no] [name][colour] - adds piece to board\n"+
                        "move : [x position][y position] [left/right/up/down][# of spaces moved] - moves piece to other board space\n"+
                        "print: prints current board\n"+
                        "exit : closes program");
                    break;
                case "exit":
                    gameOn = false;
                    break;
            }
        }
    }
}

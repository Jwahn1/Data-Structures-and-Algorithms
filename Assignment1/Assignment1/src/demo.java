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
                    System.out.println("[y position][x position] [fast][flexible] [name][colour]");
                    gameBoard.addPiece(in.nextInt(),in.nextInt(),in.next(),in.next(),in.next(),in.next());
                    break;
                case "move":

                    System.out.println("[y position][x position] [left/right/up/down][# of spaces moved]");


                    //get all user inputs first of what piece were moving and where
                    int ypos = in.nextInt(); int xpos= in.nextInt();
                    String direction = in.next(); int numberOfMoves = in.nextInt();

                    //check if it's a slow piece first
                    if(!gameBoard.getBoard()[ypos][xpos].getType().equals("slow") &&
                    !gameBoard.getBoard()[ypos][xpos].getType().equals("slowFlexible") ){
                            gameBoard.getBoard()[ypos][xpos].move(direction,numberOfMoves);
                    }else{
                        if(numberOfMoves == 1){
                            gameBoard.getBoard()[ypos][xpos].move(direction);
                        }else{
                            System.out.println("A slow piece can't move more than once");
                        }

                    }



                    break;
                case "print":
                    break;
                case "help":
                    System.out.println("create : [y position][x position] [fast/slow][flexible/no] [name][colour] - adds piece to board\n"+
                        "move : [y position][x position] [left/right/up/down][# of spaces moved] - moves piece to other board space\n"+
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

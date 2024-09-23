//Javier Wahn
//B00935618
import java.util.Scanner;
public class GameDemo {
     public static  Board gameBoard = new Board();
    public static void main(String[] args) {


        boolean gameOn = true;
        Scanner in = new Scanner(System.in);
        //main game loop
        while(gameOn){

            System.out.println("Enter a command (type help for details):");
            String command = in.nextLine();
            String[] playerInput = command.split(" ");
            //main menu
            switch(playerInput[0]){
                case "create":

                    try{
                        int posy;
                        int posx;
                        String fast = "";
                        String flex = "";
                        //get user input

                        //depending on what they wrote the array would at minimum need to be of size 3 or max 5


                        posx = Integer.parseInt(playerInput[1]);
                        posy = Integer.parseInt(playerInput[2]);

                        //variable optional inputs are handled here
                        if(playerInput.length == 4 ) {
                            if (playerInput[3].equals("flexible")) {
                                flex = "flexible";

                            }else{
                                fast = "fast";
                            }
                        }else if(playerInput.length == 5){
                            flex = "flexible";
                            fast = "fast";
                        }

                        //mandatory inputs are handled here
                        System.out.println("Name of piece?");
                        String name = in.next();
                        System.out.println("Color of piece?");
                        String color = in.next();

                        if(!gameBoard.addPiece(posy,posx,fast,flex,name,color)){
                            System.out.println("piece creation failed, please retry");
                        }
                    }catch(Exception Wronginput){
                        System.out.println("please input in the following format: [x position][y position] [fast][flexible] [name][colour]");
                        System.out.println("please keep name under 13 characters");
                    }

                    break;
                case "move":

                    try{
                        //get all user inputs first of what piece were moving and where
                        int xpos = in.nextInt(); int ypos= in.nextInt();
                        String direction = in.next();
                        //check if there's a piece there first
                        if(!gameBoard.getBoard()[ypos][xpos].getName().equals("empty")){
                            //check if it's a slow piece first
                            if(!gameBoard.getBoard()[ypos][xpos].getType().equals("S") &&
                                    !gameBoard.getBoard()[ypos][xpos].getType().equals("SF") ){
                                //fast pieces are moved here
                                int numberOfMoves = in.nextInt();
                                gameBoard.getBoard()[ypos][xpos].move(direction,numberOfMoves);
                            }else {
                                //slow pieces are moved here
                                gameBoard.getBoard()[ypos][xpos].move(direction);
                            }
                        }

                    }catch(Exception Wronginput){
                        System.out.println("please input in the following format: [x position][y position] [left/right/up/down][# of spaces moved]");
                    }
                    break;
                case "print":
                    gameBoard.boardPrint();
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
            in.nextLine();
        }
    }
}

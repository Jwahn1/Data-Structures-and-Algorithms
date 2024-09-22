import java.util.Arrays;

public class FastPiece extends Piece{
    public FastPiece(){}
    public FastPiece(String name,String colour, int posy,int posx){
        this.setColour(colour);
        this.setPosition(posy,posx);
        this.setName(name);
        this.type = "F";
    }

    // A method to move the piece left or right by a specified number of
    //spaces. This method will accept a direction parameter and a number of spaces. If a move is requested that
    //would take the Piece off the edge of the board, simply return without doing anything
    @Override
    public void move(String direction,int directionAmount){
        //Assume that the game board is an 8 X 8 grid. The position is a coordinate ([x, y]) on the board, with the values of x
        //and y each taking a value between 0 and 7. The top left corner of the board is taken to be the origin ([0, 0]). You can
        //define Position in a separate class or use classes from the Java standard library if you wish.
        for(int i = 0 ; i<directionAmount ; i++) {
            switch (direction) {
                case "left":
                    //checks if the piece is already near the border
                    if (this.getPosition()[1] != 0) {
                        //checks if left of the current space is empty
                        if (demo.gameBoard.isEmpty(this.getPosition()[0], this.getPosition()[1] - 1)) {
                            demo.gameBoard.setPiece(this, this.getPosition()[0], this.getPosition()[1] - 1);
                        }else{
                            System.out.println("this space is occupied");
                        }
                    } else {
                        System.out.println("piece has reached maximum left position");
                    }

                    break;
                case "right":
                    //checks if the piece is already near the border
                    if (this.getPosition()[1] != 7) {
                        //checks if left of the current space is empty
                        if (demo.gameBoard.isEmpty(this.getPosition()[0], this.getPosition()[1] + 1)) {
                            //here we use board.setPiece(this)
                            demo.gameBoard.setPiece(this, this.getPosition()[0], this.getPosition()[1] + 1);
                        }else{
                            System.out.println("this space is occupied");
                        }
                    } else {
                        System.out.println("piece has reached maximum right position");
                    }
                    break;
            }
        }
    }
    public String toString() {
        return this.getName()+this.getColour()+this.getType();
    }
}

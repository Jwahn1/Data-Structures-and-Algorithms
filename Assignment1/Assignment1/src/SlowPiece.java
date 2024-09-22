import java.util.Arrays;

public class SlowPiece extends Piece{

    public SlowPiece(){}
    public SlowPiece(String name,String colour, int posx, int posy){
        this.setColour(colour);
        this.setPosition(posx,posy);
        this.setName(name);
    }
    //method to move the piece left or right by one space. This method will accept
    //a direction parameter. If a move is requested that would take the Piece off the edge of the board, simply return
    //without doing anything
    public void move(String direction){
        //Assume that the game board is an 8 X 8 grid. The position is a coordinate ([x, y]) on the board, with the values of x
        //and y each taking a value between 0 and 7. The top left corner of the board is taken to be the origin ([0, 0]). You can
        //define Position in a separate class or use classes from the Java standard library if you wish.
    }

    public String toString() {
        return "Piece{" +
                "name='" + getName() + '\'' +
                ", colour='" + getColour() + '\'' +
                ", position=" + Arrays.toString(getPosition()) +
                ", Type= SlowPiece"+
                '}';
    }
}

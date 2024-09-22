import java.util.Arrays;

public class FastPiece extends Piece{
    public FastPiece(){}
    public FastPiece(String name,String colour, int posx,int posy){
        this.setColour(colour);
        this.setPosition(posx,posy);
        this.setName(name);
    }

    // A method to move the piece left or right by a specified number of
    //spaces. This method will accept a direction parameter and a number of spaces. If a move is requested that
    //would take the Piece off the edge of the board, simply return without doing anything
    @Override
    public void move(String direction,int directionAmount){
        //Assume that the game board is an 8 X 8 grid. The position is a coordinate ([x, y]) on the board, with the values of x
        //and y each taking a value between 0 and 7. The top left corner of the board is taken to be the origin ([0, 0]). You can
        //define Position in a separate class or use classes from the Java standard library if you wish.

    }
    public String toString() {
        return "Piece{" +
                "name='" + getName() + '\'' +
                ", colour='" + getColour() + '\'' +
                ", position=" + Arrays.toString(getPosition()) +
                ", Type= FastPiece"+
                '}';
    }
}

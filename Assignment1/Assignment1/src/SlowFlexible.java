import java.util.Arrays;

public class SlowFlexible extends SlowPiece{

    public SlowFlexible(String name,String colour, int posx, int posy){
        this.setColour(colour);
        this.setPosition(posx,posy);
        this.setName(name);
    }



    public void move(String direction){
        //Assume that the game board is an 8 X 8 grid. The position is a coordinate ([x, y]) on the board, with the values of x
        //and y each taking a value between 0 and 7. The top left corner of the board is taken to be the origin ([0, 0]). You can
        //define Position in a separate class or use classes from the Java standard library if you wish.

        //A flexible Piece is one that can move up or down as well as right or left.
    }
    public String toString() {
        return "Piece{" +
                "name='" + getName() + '\'' +
                ", colour='" + getColour() + '\'' +
                ", position=" + Arrays.toString(getPosition()) +
                ", Type= SlowFlexible"+
                '}';
    }
}

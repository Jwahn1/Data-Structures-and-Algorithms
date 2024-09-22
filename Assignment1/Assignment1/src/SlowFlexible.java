import java.util.Arrays;

public class SlowFlexible extends SlowPiece{

    public SlowFlexible(String name,String colour, int posx, int posy){
        this.setColour(colour);
        this.setPosition(posx,posy);
        this.setName(name);
        this.type = "slowFlexible";
    }


    @Override
    public void move(String direction){
        //Assume that the game board is an 8 X 8 grid. The position is a coordinate ([x, y]) on the board, with the values of x
        //and y each taking a value between 0 and 7. The top left corner of the board is taken to be the origin ([0, 0]). You can
        //define Position in a separate class or use classes from the Java standard library if you wish.
        switch(direction){
            case"left":
                //checks if the piece is already near the border
                if(this.getPosition()[1] != 0){
                    //checks if left of the current space is empty
                    if(demo.gameBoard.isEmpty(this.getPosition()[0],this.getPosition()[1]-1)){
                        demo.gameBoard.setPiece(this,this.getPosition()[0],this.getPosition()[1]-1);
                    }
                }else{
                    System.out.println("piece is already at maximum left position");
                }

                break;
            case "right":
                //checks if the piece is already near the border
                if(this.getPosition()[1] != 7){
                    //checks if left of the current space is empty
                    if(demo.gameBoard.isEmpty(this.getPosition()[0],this.getPosition()[1]+1)){
                        //here we use board.setPiece(this)
                        demo.gameBoard.setPiece(this,this.getPosition()[0],this.getPosition()[1]+1);
                    }
                }else{
                    System.out.println("piece is already at maximum right position");
                }
                break;
            case "up":
                //checks if the piece is already near the border
                if(this.getPosition()[0] != 0){
                    //checks if left of the current space is empty
                    if(demo.gameBoard.isEmpty(this.getPosition()[0]-1,this.getPosition()[1])){
                        demo.gameBoard.setPiece(this,this.getPosition()[0]-1,this.getPosition()[1]);
                    }
                }else{
                    System.out.println("piece is already at maximum up position");
                }
                break;
            case "down":
                //checks if the piece is already near the border
                if(this.getPosition()[0] != 7){
                    //checks if left of the current space is empty
                    if(demo.gameBoard.isEmpty(this.getPosition()[0]+1,this.getPosition()[1])){
                        demo.gameBoard.setPiece(this,this.getPosition()[0]+1,this.getPosition()[1]);
                    }
                }else{
                    System.out.println("piece is already at maximum down position");
                }
                break;
        }

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

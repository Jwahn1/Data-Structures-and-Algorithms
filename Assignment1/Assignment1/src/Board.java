public class Board {
    private int numberOfPieces = 0; private Piece[][] board = new Piece[8][8];
    public  Board(){
        //fill board with empty pieces
        for(int i = 0; i<8 ; i++){
            for(int j = 0; j<8; j++){
                Piece piece = new Piece();
                piece.setPosition(i,j);
                board[i][j] = piece;

            }
        }
    }

    public void setNumberOfPieces(int numberOfPieces) {this.numberOfPieces = numberOfPieces;}

    public int getNumberOfPieces() {return numberOfPieces;}

    public Piece[][] getBoard() {return board;}

    //Method adds a piece, first it must check that the inputs given for the position are valid for the 8x8 array
    //then it must check that the position given is currently empty, lastly it checks what type of piece the tester
    //wants to create, if the inputs aren't valid then nothing will be created.
    //method returns true when successful, false when unsuccessful
    public boolean addPiece(int posy, int posx, String fastOrSlow, String flex, String name, String colour){
        //prevents bad input
        if((posx >=0) && (posx <= 7) &&(posy >=0) && (posy <=7) && (name.length() <=13)){
            if(isEmpty(posy,posx)){
                switch(fastOrSlow){
                    case "fast":
                        if(flex.equals("flexible")){
                            board[posy][posx] = new FastFlexible(name, colour, posy,posx);
                            numberOfPieces++;
                            return true;
                        }
                        board[posy][posx] = new FastPiece(name, colour, posy,posx);
                        numberOfPieces++;
                        return true;
                    case "":
                        if(flex.equals("flexible")){
                            board[posy][posx] = new SlowFlexible(name, colour, posy,posx);
                            numberOfPieces++;
                            return true;
                        }
                        board[posy][posx] = new SlowPiece(name, colour, posy,posx);
                        numberOfPieces++;
                        return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }
    //method checks whether a given space in the board is empty (empty pieces are always named "-"
    public boolean isEmpty(int posy, int posx){
        return board[posy][posx].getName().equals("empty");
    }

    //method moves given piece to a new position and replaces the old space with an empty slot
    public void setPiece(Piece movingPiece,int newPositionY, int newPositionX) {

        int oldx = movingPiece.getPosition()[1];
        int oldy = movingPiece.getPosition()[0];
        //move piece to new position
        board[newPositionY][newPositionX] = movingPiece;
        //replace piece's coordinates to reflect the new position
        board[newPositionY][newPositionX].setPosition(newPositionY,newPositionX);
        //replace old position with an empty space
        board[oldy][oldx] = new Piece();
        board[oldy][oldx].setPosition(oldy,oldx);


    }

    public void boardPrint(){
        for(int i = 0; i<8 ; i++){
            for(int j = 0; j<8 ; j++){
                System.out.print(demo.gameBoard.getBoard()[i][j]);
                for(int k = 0; k <15-demo.gameBoard.getBoard()[i][j].toString().length();k++){
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }
}

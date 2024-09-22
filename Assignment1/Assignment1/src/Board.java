public class Board {
    private int numberOfPieces = 0; private Piece[][] board = new Piece[8][8];
    public Board(){
        //fill board with empty pieces
        for(int i = 0; i<8 ; i++){
            for(int j = 0; j<8; j++){
                board[i][j] = new Piece();
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
    public boolean addPiece(int posx, int posy, String fastOrSlow, String flex, String name, String colour){
        //prevents bad input
        if((posx >=0) && (posx <= 7) &&(posy >=0) && (posy <=7) ){
            if(isEmpty(posx,posy)){
                switch(fastOrSlow){
                    case "fast":
                        if(flex.equals("flexible")){
                            board[posx][posy] = new FastFlexible(name, colour, posx,posy);
                            return true;
                        }
                        board[posx][posy] = new SlowPiece(name, colour, posx,posy);
                        return true;
                    case "slow":
                        if(flex.equals("flexible")){
                            board[posx][posy] = new SlowFlexible(name, colour, posx,posy);
                            return true;
                        }
                        board[posx][posy] = new FastPiece(name, colour, posx,posy);
                        return true;
                }
                return false;
            }
            return true;
        }
        return true;
    }
    public boolean isEmpty(int posx, int posy){
        return board[posx][posy].getName().equals("-");
    }
}

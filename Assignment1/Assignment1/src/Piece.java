public class Piece {
    public String name; public String colour; public int[] position;
    public Piece(){};
    public Piece(String name,String colour, int[] position){
        this.name = name;
        this.colour = colour;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int[] getPosition() {
        return position;
    }

    public String getColour() {
        return colour;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    //dont know yet how the position should be changed
//    public void setPosition(int[] position) {
//        this.position = position;
//    }
}

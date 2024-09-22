import java.util.Arrays;

public class Piece {
    private String name; private String colour; private int[] position = {0,0}; String type = "";
    public Piece(){name = "empty";}


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

    public void setPosition(int posy,int posx) {
        this.position[0] = posy;
        this.position[1] = posx;
    }

    public String getType() {return type;}

    public void move(String Direction){}
    public void move(String Direction, int n){System.out.println("no piece at " + this.getPosition()[0]+ this.getPosition()[1]);}

    @Override
    public String toString() {
        return "-";
    }
}

public class Rectangle2 {


    //instance variables
    private int xpos, ypos, width, height;
    //constructors
    public Rectangle2(){}
    public Rectangle2(int xpos, int ypos, int width, int height){
        this.xpos=xpos; this.ypos=ypos; this.width=width; this.height=height;
    }
    //setters and getters
    public void setX(int xpos){this.xpos=xpos;}
    public void setY(int ypos){this.ypos=ypos;}
    public void setWidth(int width){this.width=width;}
    public void setHeight(int height){this.height=height;}
    public int getX(){return xpos;}
    public int getY(){return ypos;}
    public int getWidth(){return width;}
    public int getHeight(){return height;}

    //other methods: moveTo changes xpos and ypos and resize changes
    //width and height
    public void moveTo(int xpos, int ypos){this.xpos=xpos; this.ypos=ypos;}
    public void resize(int width, int height){this.width=width; this.height=height;}
    // toString method that returns the rectangle's details in the format
    //(xpos, ypos, width, height)
    public String toString() {
        return "(" + xpos + ", " + ypos + ", " + width + ", " + height + ")";
    }


    //contains method: returns true if a point (px, py) is contained within this rectangle
    //contains also returns true if the point touches the rectangle
    public boolean contains(int px, int py) {
        return (px>=xpos && px<=xpos+width && py>=ypos && py<= ypos+height);
    }

    //contains method: This method will return true if all four corners of r are inside or touching this
    //rectangle.
    public boolean contains(Rectangle2 r) {
        return(this.contains(r.getX(),r.getY())&&
        this.contains(r.getX() + r.getWidth(), r.getY()+r.getHeight()));
    }

    //This method will return true if any corner or side of rectangle r touches the sides of this
    //rectangle, but does not result in a full containment or overlap.
    public boolean touches(Rectangle2 r){

        //first call contains() and check if r is inside this rectangle, if return true ==> return false
        //else, check if any corner or side of r is touching this rectangle
        return true;
    }

    //This method will return true if one or more corners of r are inside this rectangle, but
    //not all the corners (partial overlap)
    public boolean overlaps(Rectangle2 r){
        //just call contains(int px, int py) 4 times checking with all 4 corners, each returned true increases a counter
        //if counter == 4 or == 0 return false, else return true
        return true;
    }
}

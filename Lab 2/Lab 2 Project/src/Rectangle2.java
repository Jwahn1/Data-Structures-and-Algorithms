/*
Javier Wahn
B00935618
 */

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
    //pointInside method: returns true if a point (px, py) is contained within this rectangle
    public boolean pointInside(int px, int py) {
        return (px>xpos && px<xpos+width && py>ypos && py< ypos+height);
    }
    //pointTouches method: returns true if the point touches the rectangle
    public boolean pointTouches(int px, int py) {
        return (px>=xpos && px<=xpos+width && py==ypos || py== ypos+height);
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
        int rectTouch = 0;

        //if both rectangles fully overlap in the same space, all sides are touching
        if(xpos == r.getX() && ypos == r.getY() && width == r.getWidth() && height == r.getHeight()){
            return true;
        }

        //we check if any of the four corners of r are parallel to this rectangle, if they are that means that the side
        //must be touching
        if(this.pointTouches(r.getX(),r.getY())){
            rectTouch++;
        }
        if(this.pointTouches(r.getX()+r.getWidth(),r.getY())){
            rectTouch++;
        }
        if(this.pointTouches(r.getX()+r.getWidth(),r.getY()+r.getHeight())){
            rectTouch++;
        }
        if(this.pointTouches(r.getX(),r.getY()+ r.getHeight())){
            rectTouch++;
        }

        if(rectTouch >0){
            return true;
        }
        return false;

    }

    //This method will return true if one or more corners of r are inside this rectangle, but
    //not all the corners (partial overlap)
    public boolean overlaps(Rectangle2 r){
        int cornerOverlap = 0;
        //if this rectangle contains r then it cant overlap, return false
        if(this.contains(r)){
            return false;
        }

        //check with all four corners if either one is inside this rectangle
        if(this.pointInside(r.getX(),r.getY())){
            cornerOverlap++;
        }
        if(this.pointInside(r.getX()+r.getWidth(),r.getY()+r.getHeight())){
            cornerOverlap++;
        }
        if(this.pointInside(r.getX(),r.getY()+r.getHeight())){
            cornerOverlap++;
        }
        if(this.pointInside(r.getX()+r.getWidth(),r.getY())){
            cornerOverlap++;
        }
        //only 1,2 or 3 corners can be overlapping at the same time, any other number returns false
        return cornerOverlap > 0 && cornerOverlap < 4;
    }
}

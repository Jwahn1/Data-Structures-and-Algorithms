public class Rectangle2 extends Rectangle1{

    //his method will return true if all four corners of r are inside or touching this
    //rectangle.
    public boolean contains(Rectangle2 r){

        return true;
    }
    //This method will return true if any corner or side of rectangle r touches the sides of this
    //rectangle, but does not result in a full containment or overlap.
    public boolean touches(Rectangle2 r){

        return true;
    }

    //This method will return true if one or more corners of r are inside this rectangle, but
    //not all the corners (partial overlap)
    public boolean overlaps(Rectangle2 r){

        return true;
    }
}

//Demo class
public class Demo1{
    public static void main(String[] args)
    { Rectangle1 rect1 = new Rectangle1(10, 20, 300, 400);
        Rectangle1 rect2 = new Rectangle1(15, 25, 100, 100);
        System.out.println("Is Point (30,40) is contained in Rectangle" + rect1 + "?\n" +
                rect1.contains(30,40) + "\n");
        System.out.println("Is Point (10,20) is contained in Rectangle" + rect1 + "?\n" +
                rect1.contains(10,20) + "\n");
        System.out.println("Is Point (4,3) is contained in Rectangle" + rect1 + "?\n" +
                rect1.contains(4,3)+ "\n");
        System.out.println("Is Rectangle " + rect2 + " is contained in Rectangle" + rect1 + "?\n"
                + rect1.contains(rect2) + "\n");
        System.out.println("Is Rectangle " + rect1 + " is contained in Rectangle" + rect2 + "?\n"
                + rect2.contains(rect1) +"\n");
    }
}
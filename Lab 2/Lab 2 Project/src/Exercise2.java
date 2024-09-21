/*
Javier Wahn
B00935618
 */

import java.util.Scanner;
public class Exercise2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int numberOfTests= in.nextInt();
        Rectangle2 rect1;
        Rectangle2 rect2;

        while(numberOfTests >0){
            rect1 = new Rectangle2(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
            rect2 = new Rectangle2(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());

            //printout space
            System.out.println("Rectangle 1: ("+rect1.getX()+ ", "+rect1.getY()+ ", "+rect1.getWidth()+ ", "+rect1.getHeight()+")");
            System.out.println("Rectangle 2: ("+rect2.getX()+ ", "+rect2.getY()+ ", "+rect2.getWidth()+ ", "+rect2.getHeight()+")");

            System.out.println("Is Rectangle 2 contained in Rectangle 1 ?" + rect1.contains(rect2));
            System.out.println("Does Rectangle 2 touch Rectangle 1? " + rect1.touches(rect2) );
            System.out.println("Does Rectangle 2 overlap with Rectangle 1?" + rect1.overlaps(rect2) + "\n");

            numberOfTests--;

        }

        //The expected output is:
        //Test case: 1
        //Rectangle 1: (0, 0, 10, 10)
        //Rectangle 2: (20, 20, 5, 5)
        //Is Rectangle 2 contained in Rectangle 1? false
        //Does Rectangle 2 touch Rectangle 1? false
        //Does Rectangle 2 overlap with Rectangle 1? false

        //test 1 : 5 0 0 10 10 20 20 5 5 0 0 20 20 5 5 5 5 0 0 20 20 0 0 20 20 0 0 10 10 10 0 5 5 0 0 20 20 15 15 10 10


    }
}
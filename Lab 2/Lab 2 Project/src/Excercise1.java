/*
Javier Wahn
B00935618
 */


import java.util.Scanner;
public class Excercise1 {
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

            System.out.println("Is Rectangle 2 contained in Rectangle 1 ?\n" +
            rect1.contains(rect2) + "\n");

            numberOfTests--;

        }

        //test 1 : 2 1 1 5 5 2 2 3 3 1 1 5 5 2 2 10 10
        //4 10 10 100 300 15 15 50 50 10 10 50 50 15 15 100 300 10 10 10 10 20 20 20 20 10 10 50 50 10 10 50 50

    }
}

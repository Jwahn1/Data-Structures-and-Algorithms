import java.util.*;
public class Exercise5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("input integer to print vertically:");
        writeVertical(in.nextInt());
    }

    //Takes a single positive integer n as a parameter and prints the digits of that integer vertically, one per line.
    public static void writeVertical(int n){{
        String vertical = Integer.toString(n);
        if(vertical.length()>0){
            System.out.println(vertical.charAt(0));
            if(vertical.length()!=1){
                writeVertical(Integer.parseInt(vertical.substring(1)));
            }

        }

    }

    }

}

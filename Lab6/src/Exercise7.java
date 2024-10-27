import java.util.*;
public class Exercise7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Find the reverse string of ");
        System.out.print(reverseString(in.nextLine()));
    }
    //takes a string str and returns the string in reverse order
    public static String reverseString(String str){

        if(str.length()> 0){
            String temp = str.substring(str.length()-1);
            str = str.substring(0,str.length()-1);
            str = temp + reverseString(str);
        }

        return str;
    }
}

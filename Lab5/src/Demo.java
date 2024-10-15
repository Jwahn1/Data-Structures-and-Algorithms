/*
Javier Wahn
B00935618
 */
import java.util.*;
public class Demo {

    /*
    test case even numbered list:
    9 8 7 6 5 4 3 2 1 0 quit
    test case, odd numbered list;
    7 6 5 4 3 2 1 quit
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean inputting = true;
        LinkedList<String> list = new LinkedList<String>();
        LinkedList<String> reverseList;

        while(inputting){
            String input = in.next();
            if(input.equals("quit")){
                inputting = false;
            }else{
               list.add(input);
            }
        }

        reverseList = reverse(list);

        //print list
        for(int i = 0; i<list.size(); i++){
            System.out.print(" "+list.getAt(i)+ "-->");
        }

        //print even numbered nodes
        System.out.println("\n\neven numbered nodes");
        displayEven(list);
        //print odd numbered nodes
        System.out.println("\n\nodd numbered nodes");
        displayOdd(list);
        //print reversed list
        System.out.println("\n\nreversed list");
        reverseList=reverse(list);
        for(int i = 0; i<reverseList.size(); i++){
            System.out.print(" "+reverseList.getAt(i)+ "-->");
        }
        //print list with middle node removed
        System.out.println("\n\nmiddle removed");
        removeMiddle(list);
        for(int i = 0; i<list.size(); i++){
            System.out.print(" "+list.getAt(i)+ "-->");
        }

    }


    //method to display even-numbered nodes
    public static void displayEven(LinkedList<String> list){
        //print list at even index numbers
        for(int i = 0; i<list.size(); i++){
            if(i%2==0){
                System.out.print(" "+list.getAt(i)+ "-->");
            }
        }
    }

    //method to display odd-numbered nodes
    public static void displayOdd(LinkedList<String> list){
        //print list at odd index numbers
        for(int i = 0; i<list.size(); i++){
            if(i%2==1){
                System.out.print(" "+list.getAt(i)+ "-->");
            }
        }
    }
    //method to create a reversed linked list
    public static LinkedList<String> reverse(LinkedList<String> list) {
        LinkedList<String> reverseList = new LinkedList<String>();
        for(int i = 0; i< list.size(); i++){
            reverseList.add(list.getAt(i));
        }
        return reverseList;
    }
    //method to remove the middle node in the linked list
    public static void removeMiddle(LinkedList<String> list){
        list.removeAt(list.size()/2);
    }
}

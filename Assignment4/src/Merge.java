import java.io.*;
import java.util.*;
public class Merge {
    public static void main(String[] args) throws FileNotFoundException {


        File randomNames = new File("Docs/RandomNames.txt");
        Scanner in = new Scanner(randomNames);
        ArrayList<String> names = new ArrayList<>();

        while(in.hasNextLine()){
            names.add(in.next());
        }

        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }
    }

    //method takes two orderedLists and merges them into a third ordered list which is then returned
    public static <T extends Comparable<T>> OrderedList<T> merge(OrderedList<T> list1, OrderedList<T> list2){

        OrderedList<T> merged = new OrderedList<>();
        int f1 = 0;
        int f2 = 0;
        while(f1 < list1.size() && f2 < list2.size()){
            //if the item in list1(f1) is smaller than list2(f2)
            if(list1.get(f1).compareTo(list2.get(f2)) <0){
                merged.add(list1.get(f1));
                f1++;
            //if the item in list2(f2) is smaller than list1(f1)
            }else if(list2.get(f2).compareTo(list1.get(f1)) <0){
                merged.add(list2.get(f2));
                f2++;
            }else{
                merged.add(list1.get(f1));
                f1++;
                f2++;
            }
        }

        //append remaining items in list2 to merged
        if(f1 == list1.size()){
            while(f2 < list2.size()){
                merged.add(list2.get(f2));
                f2++;
            }
        }
        if(f2 == list2.size()){
            while(f1 < list1.size()){
                merged.add(list1.get(f1));
                f1++;
            }
        }


        return merged;
    }


    public static <T extends Comparable<T>> OrderedList<T> common(OrderedList<T> list1, OrderedList<T> list2)
    {
        OrderedList<T> commonList = new OrderedList<>();
        int f1 = 0;
        int f2 = 0;

        //modified two finger walking algorithm
        while(f1 < list1.size() && f2 < list2.size()){
            if(list1.get(f1).compareTo(list2.get(f2)) == 0) {
                commonList.add(list1.get(f1));
                f1++;
                f2++;
                //we traverse list2 for all items bigger than f1 in hopes of finding one equal to it, if f2 is smaller
                //that means that we should move f1 up
            } else if (list1.get(f1).compareTo(list2.get(f2)) < 0 ) {
                f1++;
                //else just keep traversing list2
            } else{
                f2++;
            }

        }



        return commonList;
    }


    public static <T extends Comparable<T>> OrderedList<T> difference (OrderedList<T> list1, OrderedList<T> list2) {
        OrderedList<T> differenceList = new OrderedList<>();
        int f1 = 0;
        int f2 = 0;
        boolean inList2 = false;


        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                //if a single item in list2 is equal to the current list1.get(i) then we ignore list1.get(i)
                if(list1.get(i).compareTo(list2.get(j)) == 0){
                    inList2 = true;
                }
            }

            if(!inList2){
                differenceList.add(list1.get(i));
            }
            inList2 = false;
        }

        return differenceList;
    }
    /*

Method 2: Input arguments are two ordered lists; the method creates and returns a new list
that contains the common items in list1 and list2. You would still use the two-finger walking algorithm concept with a
small variation in the pseudocode.
The header for this method would be:

Method 3: Input arguments are two ordered lists; the method creates and returns a new list
that contains the items in list1 but not in list2. You would still use the two-finger walking algorithm concept with a
small variation in the pseudocode.
The header for this method would be:
public static <T extends Comparable<T>> OrderedList<T> difference (OrderedList<T> list1, OrderedList<T> list2)
{
//your code here
}
As an example, suppose we have the following lists:
list1: [Amar, Boris, Charlie, Dan, Fujian, Inder, Pei, Travis]
list2: [Alex, Betty, Charlie, Dan, Travis, Zola, Zulu]
then the first method (merge) should return the list
[Alex, Amar, Betty, Boris, Charlie, Dan, Fujian, Inder, Pei, Travis, Zola, Zulu]
The second method (common) should return the list
[Charlie, Dan, Travis]
The third method (difference) should return the list
[Amar, Boris, Fujian, Inder, Pei]
As you may notice from the above example, the items can be repeated across the two lists, but they are not repeated
within each list. Same with the result lists – items are not repeate
     */
}

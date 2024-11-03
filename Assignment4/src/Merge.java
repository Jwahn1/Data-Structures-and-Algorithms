import java.io.*;
import java.util.*;
import java.io.FileWriter;
public class Merge {
    public static void main(String[] args) throws IOException {


        File randomNames = new File("Docs/RandomNames.txt");


            FileWriter mergedtxt = new FileWriter("Docs/merged.txt");
            FileWriter differencetxt = new FileWriter("Docs/difference.txt");
            FileWriter commontxt = new FileWriter("Docs/common.txt");


        Scanner file = new Scanner(randomNames);
        Scanner in = new Scanner(System.in);

        ArrayList<String> names = new ArrayList<>();
        OrderedList<String> names1 = new OrderedList<String>();
        OrderedList<String> names2 = new OrderedList<String> ();

        int n1;
        int n2;

        //transfer from file all names into arraylist
        while(file.hasNextLine()){
            names.add(file.next());
        }

        //create names1
        System.out.print("please input an integer between 1000 and 1500");
        n1 = in.nextInt();


        for(int i  = 0 ; i < n1 ; i++){
            //int from 0 to 2000
            int rand_int1 = (int)(Math.random() * names.size());
            //adds a random name to list 1
            names1.insert(names.get(rand_int1));
        }

        //create names2
        System.out.print("please input an integer between 1000 and 1500");
        n2 = in.nextInt();


        for(int i  = 0 ; i < n2 ; i++){
            //int from 0 to 2000
            int rand_int1 = (int)(Math.random() * names.size());
            //adds a random name to list 2
            names2.insert(names.get(rand_int1));
        }

        // Merge the two lists
        OrderedList<String> mergedList = merge(names1, names2);
        for (int i = 0; i < mergedList.size(); i++) {
           mergedtxt.write(mergedList.get(i)+ "\n");
        }

        // Find common elements between the two lists
        OrderedList<String> commonList = common(names1, names2);
        for (int i = 0; i < commonList.size(); i++) {
            commontxt.write(commonList.get(i)+ "\n");
        }


        // Find the difference between the first list and the second
        OrderedList<String> differenceList = difference(names1, names2);
        for (int i = 0; i < differenceList.size(); i++) {
            differencetxt.write(differenceList.get(i) + "\n");
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

}

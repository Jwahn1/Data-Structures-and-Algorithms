public class Demo {
    public static void main(String[] args) {
        // Create two ordered lists
        OrderedList<Integer> list1 = new OrderedList<>();
        OrderedList<Integer> list2 = new OrderedList<>();

        // Populate the first ordered list
        list1.add(1);
        list1.add(3);
        list1.add(5);
        list1.add(7);

        // Populate the second ordered list
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(6);
        list2.add(8);

        System.out.println("List1 : " + list1);
        System.out.println("List2 : " + list2);

        // Merge the two lists
        OrderedList<Integer> mergedList = Merge.merge(list1, list2);
        System.out.println("Merged List: " + mergedList);

        // Find common elements between the two lists
        OrderedList<Integer> commonList = Merge.common(list1, list2);
        System.out.println("Common List: " + commonList);

        // Find the difference between the first list and the second
        OrderedList<Integer> differenceList = Merge.difference(list1, list2);
        System.out.println("Difference List (list1 - list2): " + differenceList);
    }
}

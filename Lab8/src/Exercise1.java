import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();


        System.out.println("Enter positive integers to construct the BST (Enter '0' to stop):");
        int input;
        while (true) {
            System.out.print("Enter int or '0': ");
            input = scanner.nextInt();

            if (input > 0){
                bst.insert(input);
            }else if(input == 0){
                System.out.println("input system closed");
                break;
            }

        }

        // Find and print the max and min elements in the BST
        System.out.println("The max data value in the BST is: " + bst.findMax());

        // Implementing findMin
        System.out.println("The min data value in the BST is: " + bst.findMin());

        // Search for an element in the tree
        System.out.print("What key would you like to search for? ");
        int searchKey = scanner.nextInt();
        if (bst.recursiveSearch(bst.getTree(), searchKey) != null) {
            System.out.println("Found!");
        } else {
            System.out.println("Not found!");
        }

        //search for element not found in tree
        System.out.print("What key would you like to search for? ");
        searchKey = scanner.nextInt();
        if (bst.recursiveSearch(bst.getTree(), searchKey) != null) {
            System.out.println("Found!");
        } else {
            System.out.println("Not found!");
        }

        scanner.close();
    }


}
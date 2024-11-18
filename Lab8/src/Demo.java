import java.util.Arrays;
import java.util.Random;
public class Demo {
    public static void main(String[] args) {
        // Create a BinarySearchTree instance
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        // Generate random numbers to insert into the BST
        Random rand = new Random();
        int[] randomNumbers = rand.ints(20, 1, 101).toArray(); // Generate 20 random numbers between 1 and 100
        System.out.println("Inserting the following elements into the BinarySearchTree:");
        System.out.println(Arrays.toString(randomNumbers));

        for (int num : randomNumbers) {
            bst.insert(num);
        }

        // Display the elements in the tree using inorder traversal
        System.out.println("\nInorder traversal of the tree:");
        BinaryTree.inorder(bst.getTree());
        System.out.println();

        // Find the maximum value in the BST
        System.out.println("\nFinding the maximum value in the BST:");
        Integer maxValue = bst.findMax();
        System.out.println("Maximum value in the tree: " + maxValue);

        // Find the min value in the BST
        System.out.println("\nFinding the maximum value in the BST:");
        Integer minValue = bst.findMin();
        System.out.println("Maximum value in the tree: " + minValue);
    }
}

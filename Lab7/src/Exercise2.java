/*
Javier Wahn
B00935618
 */

import java.util.*;
public class Exercise2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("input the names of the nodes you want, enter 'quit' if you want to stop");
        String input = in.next();
        ArrayList<BinaryTree<String>> list = new ArrayList<>();
        //get all the users inputs
        while(!input.equals("quit")){

            //we add each new node the user wants into the list in order
            BinaryTree<String> A = new BinaryTree<>();
            A.makeRoot(input);
            list.add(A);

            input = in.next();
        }


        //create a tree here with the list nodes
        if(list.size()>0){
            BinaryTree<String> root = list.get(0);
            BinaryTree<String> A = createTree(list, root);

            // test statements
            System.out.printf("Height of the tree is: %d\n", BinaryTree.findHeight(A));

            System.out.printf("Number of nodes in the tree is: %d\n", BinaryTree.countNodes(A));

            System.out.println();

            System.out.print("Inorder:\t");
            BinaryTree.inorder(A);
            System.out.println();

            System.out.print("Preorder:\t");
            BinaryTree.preorder(A);
            System.out.println();

            System.out.print("Postorder:\t");
            BinaryTree.postorder(A);
            System.out.println();

            System.out.print("Levelorder:\t");
            BinaryTree.levelOrder(A);
            System.out.println();
            System.out.println();

            System.out.printf("And is it height balanced... %s\n", BinaryTree.heightBalanced(A) ? "Yes!" : "No.");

            System.out.println();

        }

    }

    //method recieves a list of BinaryTree nodes and a main binarytree node which will act as the root of all the others
    //and will return a complete binary tree made up of all the nodes in the lista
    public static BinaryTree<String> createTree(ArrayList<BinaryTree<String>> list,BinaryTree<String> root ){
        if(list.isEmpty()){
            return null;
        }

        int index = 0;
        int offset = -1;
        BinaryTree<String> right = null;
        BinaryTree<String> left = null;

        //get the first left and right nodes

        if(index+1 <list.size()) {
            if(list.get(index+1) != null) {
                left = list.get(index+1);
            }
        }



        if(index+2 <list.size()){
            if(list.get(index+2) != null) {
                right = list.get(index+2);
            }
        }




        while (index < list.size() ) {

            //attach left child to root
            if(left != null){
                root.attachLeft(left);
            }
            //attach right child to root
            if(right != null){
                root.attachRight(right);
            }

            System.out.print("");
            //move up the list and get the next root node
            index++;
            if(index < list.size()){
                root = list.get(index);
            }


            // example situation : [a,b,c,d,e,f,g,h,i,j,k,l]
            // in the case of b the children nodes are 2 and 3 spaces away from  the parent ,
            // in the case of c the children nodes are 3 and 4 spaces away from  the parent.
            // in the case of d the children nodes are 4 and 5 spaces away from the parent and so on.
            //this is why the solution involves getting the children nodes as left = list.get(index+offset+2)
            offset++;

            //get the child nodes corresponding to the new root node
            if(index+2+offset <list.size()){
                left = list.get(index+2+offset);
            }else{
                left = null;
            }

            if(index+3+offset <list.size()){
                right = list.get(index + 3+offset);
            }else{
                right = null;
            }
        }
        //return the root node of the tree
        return list.get(0);
    }


}

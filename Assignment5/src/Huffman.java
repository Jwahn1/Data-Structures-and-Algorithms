import java.io.*;
import java.util.*;
import java.io.FileWriter;
import java.util.Queue;

public class Huffman {
    public static void main(String[] args) throws FileNotFoundException {
        File LettersProbability = new File("Docs/LettersProbability.txt");
        Scanner fileReader = new Scanner(LettersProbability);

        ArrayList<BinaryTree> SQueue = new ArrayList<>();
        ArrayList<BinaryTree> TQueue = new ArrayList<>();



        //As you read each line of the LettersProbability.txt file, you will create a BinaryTree<Pair> object
        //for each letter-probability pair that you read.


         /*
        Step 3: Next, you will build a Huffman tree. To build a Huffman tree you will require two queues, Queue S
        and Queue T, of type BinaryTree<Pair>. You may use structures from the Java Standard Library, or you
        may choose to trivially implement your queues using ArrayLists (appending new elements and removing
        at index 0). Both options are acceptable.
         */

        /*
        Enqueue the BinaryTree<Pair> objects in ascending order into the Queue S, with the lowest
        probabilities at the head of the queue. Your second queue (Queue T) should remain empty for the
        time being
         */

        while(fileReader.hasNext()){
            Pair pair = new Pair(fileReader.next().charAt(0),Double.parseDouble(fileReader.next()));

            BinaryTree<Pair> treePair = new BinaryTree<>();
            treePair.makeRoot(pair);
            SQueue.add(treePair);

        }

        fileReader.close();

        /*
        Now you can implement the rest of the Huffman algorithm from your workbook:
         */

        BinaryTree<Pair> A, B,SqueueHead,TqueueHead;
        while(!SQueue.isEmpty()){

            //1) Pick the two smallest weight trees, say A and B, from queues S and T, as follows:

            /*
            a) If T is empty, A and B are respectively the front and next to front entries of S.
            Dequeue them from S.
             */
            if(TQueue.isEmpty()){
                A = SQueue.remove(0);
                B = SQueue.remove(0);

                //b) If T is not empty:
            }else{
                /*
                i) Find the smaller weight tree of the trees in front of S and in front of T.
                This is A. Dequeue it.
                 */
                SqueueHead = SQueue.remove(0);
                TqueueHead = TQueue.remove(0);

                if(SqueueHead.getData().compareTo(TqueueHead.getData()) < 0){
                    TQueue.add(0,TqueueHead);
                    A = SqueueHead;
                }else{
                    SQueue.add(0,SqueueHead);
                    A = TqueueHead;
                }


                if(!TQueue.isEmpty()){
                    SqueueHead = SQueue.remove(0);
                    TqueueHead = TQueue.remove(0);

                    /*
                    ii) Find the smaller weight tree of the trees in front of S and in front of T.
                    This is B. Dequeue it.
                     */

                    if(SqueueHead.getData().compareTo(TqueueHead.getData()) < 0){
                        TQueue.add(0,TqueueHead);
                        B = SqueueHead;
                    }else{
                        SQueue.add(0,SqueueHead);
                        B = TqueueHead;
                    }
                }else{
                    SqueueHead = SQueue.remove(0);
                    TqueueHead = SQueue.remove(0);

                    /*
                    ii) Find the smaller weight tree of the trees in front of S and in front of T.
                    This is B. Dequeue it.
                     */

                    if(SqueueHead.getData().compareTo(TqueueHead.getData()) < 0){
                        TQueue.add(0,TqueueHead);
                        B = SqueueHead;
                    }else{
                        SQueue.add(0,SqueueHead);
                        B = TqueueHead;
                    }
                }

            }

             /*
            2) Construct a new tree P by creating a root and attaching A and B as the subtrees of this root. The
            weight of the root is the combined weights of the roots of A and B. (You may find it useful to assign a
            character value to P that is not an uppercase letter. A 0 (zero) character will work.
            */

            BinaryTree<Pair> treePair = new BinaryTree<>();
            Pair pair = new Pair((char)0,A.getData().getProbability()+B.getData().getProbability());
            treePair.makeRoot(pair);
            treePair.attachLeft(A);
            treePair.attachRight(B);

            //3) Enqueue tree P to queue T.
            TQueue.add(treePair);



        }

        //5) If the number of elements in queue T is greater than 1, dequeue two nodes at a time, combine
        //them (see step 2) and enqueue the combined tree until queue T's size is 1. The last node remaining in
        //the queue T will be the final Huffman tree.

        while(TQueue.size() != 1){
            A = TQueue.remove(0);
            B = TQueue.remove(0);

            BinaryTree<Pair> treePair = new BinaryTree<>();
            Pair pair = new Pair((char)0,A.getData().getProbability()+B.getData().getProbability());
            treePair.makeRoot(pair);
            treePair.attachLeft(A);
            treePair.attachRight(B);

            //3) Enqueue tree P to queue T.
            TQueue.add(treePair);

        }


        // Now that you have the Huffman codes, you are ready to encode and decode text. Prompt the user to
        //enter a line of text in uppercase letter

        // The final Huffman tree
        BinaryTree<Pair> huffmanTree = TQueue.get(0);

        // get the huffman codes
        String[] codes = findEncoding(huffmanTree);

        // get user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a line of text in uppercase letters:");
        String inputText = scanner.nextLine().toUpperCase();

        StringBuilder encodedText = new StringBuilder();
        for (char c : inputText.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                encodedText.append(codes[c - 'A']);
            }
        }

        System.out.println("Encoded Text: " + encodedText.toString());

        // Step 3: Decode the encoded text using the Huffman tree
        StringBuilder decodedText = new StringBuilder();
        BinaryTree<Pair> currentNode = huffmanTree;
        for (int i = 0; i < encodedText.length(); i++) {
            if (encodedText.charAt(i) == '0') {
                currentNode = currentNode.getLeft();
            } else {
                currentNode = currentNode.getRight();
            }

            // If we reach a leaf node, output the corresponding character
            if (currentNode.getLeft() == null && currentNode.getRight() == null) {
                decodedText.append(currentNode.getData().getValue());
                currentNode = huffmanTree;  // reset to the root
            }
        }

        System.out.println("Decoded Text: " + decodedText.toString());


    }

    private static String[] findEncoding(BinaryTree<Pair> bt){
        String[] result = new String[26];
        findEncoding(bt, result,
                ""); return result;
    }

    private static void findEncoding(BinaryTree<Pair> bt, String[] a, String prefix){
        // test is node/tree is a leaf
        if (bt.getLeft()==null && bt.getRight()==null){
            a[bt.getData().getValue() - 65] = prefix;
        }
        // recursive calls
        else{
            findEncoding(bt.getLeft(), a, prefix+"0");
            findEncoding(bt.getRight(), a, prefix+"1");
        }
    }

}

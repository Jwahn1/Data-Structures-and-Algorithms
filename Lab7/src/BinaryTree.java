//This class contains the methods for the BinaryTree class.
//For the lab Exercise 1, you need to complete the TO-DO methods
import java.util.ArrayList;
public class BinaryTree<T> {
	private T data;
	private BinaryTree<T> parent;
	private BinaryTree<T> left;
	private BinaryTree<T> right;

	public BinaryTree() {
		parent = left = right = null;
		data = null;
	}

	public void makeRoot(T data) {
		if (!isEmpty()) {
			System.out.println("Can't make root. Already exists");
		} else
			this.data = data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setLeft(BinaryTree<T> tree) {
		left = tree;
	}

	public void setRight(BinaryTree<T> tree) {
		right = tree;
	}

	public void setParent(BinaryTree<T> tree) {
		parent = tree;
	}

	public T getData() {
		return data;
	}

	public BinaryTree<T> getParent() {
		return parent;
	}

	public BinaryTree<T> getLeft() {
		return left;
	}

	public BinaryTree<T> getRight() {
		return right;
	}

	public void attachLeft(BinaryTree<T> tree) {
		if (tree == null)
			return;
		else if (left != null || tree.getParent() != null) {
			System.out.println("Can't attach");
			return;
		} else {
			tree.setParent(this);
			this.setLeft(tree);
		}
	}

	public void attachRight(BinaryTree<T> tree) {
		if (tree == null)
			return;
		else if (right != null || tree.getParent() != null) {
			System.out.println("Can't attach");
			return;
		} else {
			tree.setParent(this);
			this.setRight(tree);
		}
	}

	public BinaryTree<T> detachLeft() {
		if (this.isEmpty())
			return null;
		BinaryTree<T> retLeft = left;
		left = null;
		if (retLeft != null)
			retLeft.setParent(null);
		return retLeft;
	}

	public BinaryTree<T> detachRight() {
		if (this.isEmpty())
			return null;
		BinaryTree<T> retRight = right;
		right = null;
		if (retRight != null)
			retRight.setParent(null);
		return retRight;
	}

	public boolean isEmpty() {
		if (data == null)
			return true;
		else
			return false;
	}

	public void clear() {
		left = right = parent = null;
		data = null;
	}

	public BinaryTree<T> root() {
		if (parent == null)
			return this;
		else {
			BinaryTree<T> next = parent;
			while (next.getParent() != null)
				next = next.getParent();
			return next;
		}
	}

	//this method counts the number of nodes in a BinaryTree recursively
	public static <T> int countNodes(BinaryTree<T> t){

		if(t ==null) {
			return 0;//no nodes to count
		}else{
			BinaryTree<T> right = t.getRight();
			BinaryTree<T> left = t.getLeft();
			return 1+ countNodes(right) + countNodes(left) ;
		}

	}


	// this method returns the height of a BinaryTree
	public static <T> int findHeight(BinaryTree<T> t) {
		int height = 0;
		if(t == null){
			return -1;
		}else{
			BinaryTree<T> left = t.getLeft();
			BinaryTree<T> right = t.getRight();
			height = 1 + Math.max(findHeight(left), findHeight(right));

		}
		return height;
	}
	
	// this method tests whether a tree is height balanced
	public static <T> boolean heightBalanced(BinaryTree<T> t) {
		if(t == null){
			return false;
		}else{
			BinaryTree<T> left = t.getLeft();
			BinaryTree<T> right = t.getRight();
			//A binary tree is height balanced if, for every node in the tree,
			// the height of its left subtree differs from the height of its right subtree by no more than one.
			if(findHeight(left) != findHeight(right)) {
				return false;
			}else {
				return true;
			}
	}

	}

	public static <T> void preorder(BinaryTree<T> t) {
		if (t != null) {
			System.out.print(t.getData() + "\t");
			preorder(t.getLeft());
			preorder(t.getRight());
		}
	}

	public static <T> void inorder(BinaryTree<T> t) {
		if (t != null) {
			inorder(t.getLeft());
			System.out.print(t.getData() + "\t");
			inorder(t.getRight());
		}
	}

	public static <T> void postorder(BinaryTree<T> t) {
		if (t != null) {
			postorder(t.getLeft());
			postorder(t.getRight());
			System.out.print(t.getData() + "\t");
		}
	}

	// this method uses an ArrayList to print the data associated with all
	// nodes/trees in level order
	public static <T> void levelOrder(BinaryTree<T> t) {
		ArrayList<BinaryTree<T>> q = new ArrayList<BinaryTree<T>>();
		q.add(t);
		while(!q.isEmpty()){

			//current node will be the leftmost node in the tree level
			BinaryTree<T> currentNode = q.get(0);
			System.out.print(currentNode.data);
			System.out.print(" ");
			//after we print it we move up the queue
			q.remove(0);

			//line up next two nodes in the current level
			if(currentNode.getLeft() != null){
				q.add(currentNode.getLeft());
			}
			if(currentNode.getRight() != null){
				q.add(currentNode.getRight());
			}



		}

	//TO-DO
	}
}

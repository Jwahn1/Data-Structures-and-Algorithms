
/**
 * Generic Binary Search Tree Class
 * @param <T>
 */
public class BinarySearchTree<T extends Comparable<T>>{
    // declare required fields
	private BinaryTree<T> tree;
	private int size;

    /**
    Constructor 1
    No arg constructor
    */
    public BinarySearchTree(){
		tree = new BinaryTree<T>();
		size=0;
	}

	public BinaryTree<T> getTree(){
		return tree;
	}

	public boolean isEmpty(){
		return tree.isEmpty();
	}

	public int size(){
		return size;
	}

	public BinaryTree<T> search(T key){
		BinaryTree<T> t = tree;

        if (isEmpty()) return null;

        while (t!=null){
			if (key.compareTo(t.getData())<0)
				t = t.getLeft();
			else if (key.compareTo(t.getData())>0)
				t = t.getRight();
			else // key is found
				return t;
		}
        return null;
	}

	public void insert(T item){
        //initialize new BT and sets left, right, parent and data to null
		BinaryTree<T> newNode = new BinaryTree<T>();
		newNode.setData(item);

		if (size==0){
            tree = newNode;
            size++;
            return;
        }

		BinaryTree<T> t = tree;
		boolean done = false;

        while (!done){
			int c = item.compareTo(t.getData());
			if (c==0){
				System.out.println("Duplicate key. Can't insert");
				return;
			}
            //need to go left
			else if (c<0){
                //place to insert found
				if (t.getLeft()==null){
					t.setLeft(newNode);
					newNode.setParent(t);
					size++;
					done = true;
				}
				else
                    //otherwise go left one branch
					t = t.getLeft();
			}
            //c>0; need to go right
			else{
                //place to insert found
				if (t.getRight()==null){
					t.setRight(newNode);
					newNode.setParent(t);
					size++;
					done=true;
				}
				else
					t = t.getRight();
			}
		}
	}

	public BinaryTree<T> findPredecessor(BinaryTree<T> node){
		if (node==null)
            return null;

		if (node.getLeft()==null)
            return null;

		BinaryTree<T> pred = node.getLeft();

        while (pred.getRight()!=null)
			pred = pred.getRight();

        return pred;
	}

	public void deleteHere(BinaryTree<T> deleteNode, BinaryTree<T> attach){
		if (deleteNode==null)
            return;

		BinaryTree<T> parent = deleteNode.getParent();

		if (parent == null)
            return;

        if (attach == null){
			if (parent.getLeft()==deleteNode)
				parent.setLeft(null);
			else
				parent.setRight(null);
			return;
		}

        if (deleteNode==parent.getRight()){
			parent.detachRight();
			deleteNode.setParent(null);
			//attach.setParent(parent);
			attach.setParent(null);
			parent.attachRight(attach);
			attach.setParent(parent);
		}
		else{
			parent.detachLeft();
			deleteNode.setParent(null);

			//attach.setParent(parent);
			attach.setParent(null);
			parent.attachLeft(attach);
			attach.setParent(parent);
		}

		deleteNode.clear();
	}

	public void delete(T key){
		if (size==0){
            System.out.println("Can't delete. Empty tree");
            return;}

		BinaryTree<T> deleteNode = search(key);

        if (deleteNode==null){
            System.out.println("Key not found. Can't delete");
            return;
        }

		BinaryTree<T> hold = null;
		if (deleteNode.getLeft()==null && deleteNode.getRight()==null){
			deleteHere(deleteNode, null);
		}
		else if (deleteNode.getLeft()==null){
			hold = deleteNode.getRight();
			deleteHere(deleteNode, hold);
		}
        else if (deleteNode.getRight()==null){
			hold = deleteNode.getLeft();
			deleteHere(deleteNode, hold);
		}
		else{
			hold = findPredecessor(deleteNode);
			deleteNode.setData(hold.getData());
			deleteNode=hold;
			deleteHere(deleteNode, deleteNode.getLeft());
		}

		size--;
	}

	/*
	This method should return the maximum data value stored in the binary search tree
	(i.e., the largest integer or double, the String which is lexicographically (i.e., alphabetically) last).
	 */
    public T findMax(){
        T MAX = this.getTree().getData();
		BinaryTree<T> current = new BinaryTree<T>();
		current = this.getTree();

		boolean edgeNode = false;

		if(current.getData() != null){
			//the right most leaf is the biggest key in the tree so just loop until we're there
			while(!edgeNode){
				if(current.getRight() != null){
					current = current.getRight();
				}else{
					//if we're in the right most leaf then return the max
					MAX = current.getData();
					edgeNode = true;
				}
			}

		}
		return MAX;
    }

	/*
	This method should return the minimum data value stored in the binary search tree
	(i.e., the smallest integer or double, the String which	is lexicographically first).
	 */
    public T findMin(){
		T MIN = this.getTree().getData();
		BinaryTree<T> current = new BinaryTree<T>();
		current = this.getTree();

		boolean edgeNode = false;

		if(current.getData() != null){
			//the left most leaf is the smallest key in the tree so just loop until we're there
			while(!edgeNode){
				if(current.getLeft() != null){
					current = current.getLeft();
				}else{
					//if we're in the left most leaf then return the min
					MIN = current.getData();
					edgeNode = true;
				}
			}

		}
		return MIN;

    }

    //Helper method to search the tree of this class
    public BinaryTree<T> recursiveSearch(T key){
        return recursiveSearch(this.getTree(),key);
    }

	/*
	This method returns a BinaryTree whose data value matches the search key, returns null if key is not found
	 */
    public BinaryTree<T> recursiveSearch(BinaryTree<T> t, T key) {
		if(t.getData() == null){
			return null;
		}

		BinaryTree<T> searchLeft = null;
		BinaryTree<T> searchRight = null;
		//we have current node, if its the key we want to return
		if(t.getData().compareTo(key) == 0){
			return t;
		}else{
			//if not,  search left node and right node IF they are not null
			if(t.getLeft() != null){
				//search further left of current node
				 searchLeft = recursiveSearch(t.getLeft(),key);
			}
			if(t.getRight() != null){
				//search further right of current node
				 searchRight = recursiveSearch(t.getRight(),key);
			}

		}

		//return whichever node held the key
		if(searchLeft != null){
			return searchLeft;
		}
		if(searchRight != null){
			return searchRight;
		}
		//if both are null return null (key not found)
		return null;

    }
}

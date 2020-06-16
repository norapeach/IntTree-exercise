//IntTree.java
/**
 * @author Nora P.
 * @version 6/16/20
 * @see http://www.buildingjavaprograms.com/code-files/5ed/ch17/IntTree.java
 */
public class IntTree {
	private IntTreeNode overallRoot;

	/**
	 * Constructs a sequential tree starting at 1 with the given number of nodes
	 * 
	 * @param max The maximum number of nodes in the tree to construct
	 */
	public IntTree(int max) {
		if (max <= 0) {
			throw new IllegalArgumentException("max: " + max);
		}

		overallRoot = buildTree(1, max);
	}

	/**
	 * Recursive helper method for adding intTree nodes by sequential value
	 * 
	 * @param n
	 * @param max
	 * @return The constructed sequential IntTree
	 */
	private IntTreeNode buildTree(int n, int max) {
		if (n > max) {
			return null;
		} else {
			return new IntTreeNode(n, buildTree(2 * n, max), buildTree(2 * n + 1, max));
		}
	}

	/**
	 * Post: Constructs an empty tree
	 */
	public IntTree() {
		overallRoot = null;
	}

	public void add(int value) {
		overallRoot = add(overallRoot, value);
	}

	/**
	 * Constructs a Node with the given value and adds it to the given tree
	 * 
	 * @param root  The tree root to attach the new Node
	 * @param value The data value for the new Node to be added
	 * @return The modfied, larger IntTree functional as a binary search tree
	 */
	private IntTreeNode add(IntTreeNode root, int value) {
		if (root == null) {
			root = new IntTreeNode(value);
		} else if (value <= root.data) {
			root.left = add(root.left, value);
		} else {
			root.right = add(root.right, value);
		}
		return root;
	}

	/**
	 * @author Nora P.
	 * @return The total count of empty branches in a tree
	 */
	public int countEmpty() {
		return countEmpty(overallRoot, 0); // call to recursive helper, passes zero to start counting
	}

	/**
	 * Recursive helper that accepts the Tree/Subtree and counts each empty branch
	 * via the parameter count - default start is zero.
	 * 
	 * @author Nora P.
	 * @param root  The Tree to evaluate
	 * @param count Tracks the number of empty branches in the tree
	 * @return The number of empty branches
	 */
	private int countEmpty(IntTreeNode root, int count) {
		if (root == null) {
			// base case: empty tree == 1 empty branch
			return 1 + count;
		} else {
			// root is not null
			// recursive case: at least one non-empty branch

			if (root.left == null && root.right != null) {
				return 1 + countEmpty(root.right, count);
			} else if (root.right == null && root.left != null) {
				return 1 + countEmpty(root.left, count);
			} else {
				// final case: neither branch is empty, continues
				// to move through tree until final leaves are reached

				return countEmpty(root.right, count) + countEmpty(root.left, count);

			} // end inner if/else
		} // end outer if/else
	} // end method

	/**
	 * @author Nora P.
	 * @return The total number of Nodes
	 */
	public int size() {
		return size(overallRoot); // recursive call passing root IntTreeNode
	}

	/**
	 * @author Nora P.
	 * @param root
	 * @return
	 */
	private int size(IntTreeNode root) {
		if (root == null) {
			return 0;
		} else {
			return 1 + size(root.left) + size(root.right); // 1 is for the overall root, then adds the values returned
			// from the recursive calls (passes the subroot of each branch,
			// will call on sub branches if there are, otherwise returns 0 for both)
		}
	} // end size()

}

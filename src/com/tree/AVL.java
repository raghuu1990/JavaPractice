package com.tree;

import com.node.AVLNode;

/* The constructed AVL Tree would be
	    30
	   /  \
	  20   40
	 /  \    \
	10  25   50
*/

public class AVL {
	public static void main(String[] args) {
		AVLNode root = new AVLNode(10);
		root = insert(root, 20);
		root = insert(root, 30);
		root = insert(root, 40);
		root = insert(root, 50);
		root = insert(root, 25);
		System.out.println("Inorder traversal" + " of constructed tree is : ");
		inorder(root);
		System.out.println();
		System.out.println("After deletion");
		deleteNode(root, 30);
		inorder(root);
		
	}

	public static AVLNode deleteNode(AVLNode root, int data) {
		if(root==null) {
			return root;
		}
		if(root.data > data) {
			root.left = deleteNode(root.left, data);
		}else if(root.data < data) {
			root.right = deleteNode(root.right, data);
		} else if(root.left==null && root.right==null) {
			root = null;
			return root;
		} else if (root.left == null) {
			root = root.right;
		} else if (root.right == null) {
			root = root.left;
		} else {
			AVLNode node = minValueNode(root.right);
			root.data = node.data;
			root.right = deleteNode(root.right, root.data);
		}

		if (root == null) {
			return root;
		}
		
		root.height = 1 + Math.max(height(root.left), height(root.right));

		int balance = getBalance(root);
		if (balance > 1 && data < root.left.data)
			return rightRotate(root);

		// Right Right Case
		if (balance < -1 && data > root.right.data)
			return leftRotate(root);

		// Left Right Case
		if (balance > 1 && data > root.left.data) {
			root.left = leftRotate(root.left);
			return rightRotate(root);
		}

		// Right Left Case
		if (balance < -1 && data < root.right.data) {
			root.right = rightRotate(root.right);
			return leftRotate(root);
		}
		return root;
	}

	public static AVLNode insert(AVLNode root, int data) {
		if (root == null) {
			return new AVLNode(data);
		}

		if (data < root.data) {
			root.left = insert(root.left, data);
		} else if (data > root.data) {
			root.right = insert(root.right, data);
		} else {
			return root;
		}

		root.height = 1 + Math.max(height(root.left), height(root.right));

		int balance = getBalance(root);
		
		// If this node becomes unbalanced, then there are 4
		// cases Left Left Case
		if (balance > 1 && data < root.left.data)
			return rightRotate(root);

		// Right Right Case
		if (balance < -1 && data > root.right.data)
			return leftRotate(root);

		// Left Right Case
		if (balance > 1 && data > root.left.data) {
			root.left = leftRotate(root.left);
			return rightRotate(root);
		}

		// Right Left Case
		if (balance < -1 && data < root.right.data) {
			root.right = rightRotate(root.right);
			return leftRotate(root);
		}
		return root;
	}

	public static AVLNode rightRotate(AVLNode y) {
		AVLNode x = y.left;
		AVLNode T2 = x.right;

		x.right = y;
		y.left = T2;

		y.height = Math.max(height(y.left), height(y.right)) + 1;
		x.height = Math.max(height(x.left), height(x.right)) + 1;

		return x;
	}

	public static AVLNode leftRotate(AVLNode x) {
		AVLNode y = x.right;
		AVLNode T2 = y.left;

		y.left = x;
		x.right = T2;

		x.height = Math.max(height(x.left), height(x.right)) + 1;
		y.height = Math.max(height(y.left), height(y.right)) + 1;

		return y;
	}

	// loop down to find the leftmost leaf
	private static AVLNode minValueNode(AVLNode root) {
		AVLNode current = root;
		while (current.left != null) {
			current = current.left;
		}
		return current;
	}

	private static int getBalance(AVLNode node) {
		if (node == null) {
			return 0;
		}
		return height(node.left) - height(node.right);
	}

	private static int height(AVLNode node) {
		if (node == null) {
			return 0;
		}
		return Math.max(height(node.right), height(node.left));
	}

	public static void inorder(AVLNode root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}
}
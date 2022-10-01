// Checking if a given binary tree is a complete binary tree in Java

// Creating Node
class Node {
    int data;
    Node left, right;
  
    Node(int value) {
      data = value;
      left = right = null;
    }
  }
  
  class BinaryTree {
    Node root;
  
    // Count the number of nodes
    int countNodes(Node root) {
      if (root == null)
        return (0);
      return (1 + countNodes(root.left) + countNodes(root.right));
    }
  
    // Check for complete binary tree
    boolean checkCompleteBinary(Node root, int index, int numberNodes) {
  
      // Check if the tree is empty
      if (root == null)
        return true;
  
      if (index >= numberNodes)
        return false;
  
      return (checkCompleteBinary(root.left, 2 * index + 1, numberNodes)
          && checkCompleteBinary(root.right, 2 * index + 2, numberNodes));
    }
  
    public static void main(String args[]) {
      BinaryTree tree = new BinaryTree();
  
      tree.root = new Node(1);
      tree.root.left = new Node(2);
      tree.root.right = new Node(3);
      tree.root.left.right = new Node(5);
      tree.root.left.left = new Node(4);
      tree.root.right.left = new Node(6);
  
      int node_count = tree.countNodes(tree.root);
      int index = 0;
  
      if (tree.checkCompleteBinary(tree.root, index, node_count))
        System.out.println("The tree is a complete binary tree");
      else
        System.out.println("The tree is not a complete binary tree");
    }
  }
  
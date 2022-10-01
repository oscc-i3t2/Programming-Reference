/*Given two binary trees with head reference as T and S having at most N nodes. The task is to check if S is present as subtree in T.
A subtree of a tree T1 is a tree T2 consisting of a node in T1 and all of its descendants in T1.*/

/*
 T:      1          S:   3
      /   \            /
     2     3          4
   /  \    /
  N    N  4

  Output: 1 
 */

class Node
{
    int data;
    Node left, right, nextRight;
  
    Node(int item)
    {
        data = item;
        left = right = nextRight = null;
    }
}
  
class BinaryTree
{
    Node root1,root2;
  
    /* A utility function to check whether trees with roots as root1 and root2 are identical or not */
    boolean areSame(Node root1, Node root2)
    {
  
        /* base cases */
        if (root1 == null && root2 == null)
            return true;
  
        if (root1 == null || root2 == null)
            return false;
  
        /* Check if the data of both roots is same and data of left and right subtrees are also same */
        return (root1.data == root2.data
                && areSame(root1.left, root2.left)
                && areSame(root1.right, root2.right));
    }
  
    /* This function returns true if S is a subtree of T, otherwise false */
    boolean isSubtree(Node T, Node S)
    {
        /* base cases */
        if (S == null)
            return true;
  
        if (T == null)
            return false;
  
        /* Check the tree with root as current node */
        if (areSame(T, S))
            return true;
  
        /* If the tree with root as current node doesn't match then
           try left and right subtrees one by one */
        return isSubtree(T.left, S)
                || isSubtree(T.right, S);
    }
  
    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();
          
        // TREE 1
        /* Construct the following tree
              26
             /   \
            10     3
           /    \     \
          4      6      3
           \
            30  */
           
        tree.root1 = new Node(26);
        tree.root1.right = new Node(3);
        tree.root1.right.right = new Node(3);
        tree.root1.left = new Node(10);
        tree.root1.left.left = new Node(4);
        tree.root1.left.left.right = new Node(30);
        tree.root1.left.right = new Node(6);
  
        // TREE 2
        /* Construct the following tree
           10
         /    \
         4      6
          \
          30  */
           
        tree.root2 = new Node(10);
        tree.root2.right = new Node(6);
        tree.root2.left = new Node(4);
        tree.root2.left.right = new Node(30);
  
        if (tree.isSubtree(tree.root1, tree.root2))
            System.out.println("Tree 2 is subtree of Tree 1 ");
        else
            System.out.println("Tree 2 is not a subtree of Tree 1");
    }
}
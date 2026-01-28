import java.util.LinkedList;
import java.util.Queue;

public class BinaryTrees {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;
        public static Node buildTree(int nodes[]) { // O(n)
             idx++;
             if(nodes[idx] == -1) return null;

             Node newNode = new Node(nodes[idx]);
             newNode.left = buildTree(nodes);
             newNode.right = buildTree(nodes);

             return newNode;

        }

        // Pre-Order Traversal O(n)
        // print root -> root.left -> root.right
        public static void preorder(Node root) { 
            if(root == null) return;
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        // Inorder Traversal O(n)
        // print root.left -> root -> root.right
        public static void inorder(Node root) {
            if(root == null) return;
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        // Post-Traversal O(n)
        // print root.left -> root.right -> root
        public static void postorder(Node root) {
            if(root == null) return;
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }

        // Level-Order Traversal O(n)
        public static void levelOrder(Node root) {
            if(root == null) return;
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()) {
                Node currNode = q.remove();
                if(currNode == null) {
                    System.out.println();
                    if(q.isEmpty()) {
                        break;
                    } 
                    q.add(null);
                } else {
                    System.out.print(currNode.data + " ");
                    if(currNode.left != null) q.add(currNode.left);
                    if(currNode.right != null) q.add(currNode.right);
                }
            }
        }
    }

        // Q. Height of binary tree - O(n)
        /* 
                     1
                   /  \
                  2    3
                 / \   / \
                4   5 6   7
        */
    
    public  static int height(Node root) {
        if(root == null) return 0;

        int lh = height(root.left);
        int rh = height(root.right);

        return  Math.max(lh, rh)+1;
    }

        // Q. Count of binary tree - O(n)
        /* 
                     1
                   /  \
                  2    3
                 / \   / \
                4   5 6   7
        */
    public static int count(Node root) {
        if(root == null) return 0;
        return count(root.left) + count(root.right) + 1;
    }

        // Q. Sum of all nodes of binary tree - O(n)
        /* 
                     1
                   /  \
                  2    3
                 / \   / \
                4   5 6   7
        */
       public static int sum(Node root) {
        if(root == null) return 0;
        return  sum(root.left) + sum(root.right) + root.data;
       }

    public static void main(String args[]) {
        // int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        // BinaryTree tree = new BinaryTree();
        // Node root = tree.buildTree(nodes);
        // tree.levelOrder(root);

        // Call for height & count & sum
        // Node root = new Node(1);
        // root.left = new Node(2);
        // root.right = new Node(3);
        // root.left.left = new Node(4);
        // root.left.right = new Node(5);
        // root.right.left = new Node(6);
        // root.right.right = new Node(7);
        // System.out.println(sum(root));

        System.out.println(1);
        System.out.println(12);
        System.out.println(123);
        System.out.println(1234);
    }
}

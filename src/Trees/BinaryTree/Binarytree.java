package Trees.BinaryTree;
import java.util.*;

class Node
{
    int data;
    Node left;
    Node right;

    Node(int d)
    {
        data=d;
        left=null;
        right=null;
    }
}

public class Binarytree {
    static Node createNode(int val)  //we can use static then it is not required to create a object if it is not we have create a object
    {
        Node n = new Node(val);
        return n;
    }

    static void Preorder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        Preorder(root.left);
        Preorder(root.right);
    }

    static void Inorder(Node root) {
        if (root == null) return;
        Inorder(root.left);
        System.out.print(root.data + " ");
        Inorder(root.right);
    }

    static void Postorder(Node root) {
        if (root == null) return;
        Postorder(root.left);
        Postorder(root.right);
        System.out.print(root.data + " ");
    }

    static void BFS(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        q.offer(root);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            System.out.print(temp.data + " ");

            if(temp.left!=null){
                q.offer(temp.left);
            }
            if(temp.right!=null){
                q.offer(temp.right);
            }
        }
    }
   public static void main(String[] args)
   {
       Node root=createNode(1); // Level 1
       root.left=createNode(2); //level 2
       root.right=createNode(3);
       root.left.left=createNode(4); //Level 3
       root.left.right=createNode(5);
       root.right.left=createNode(6);
       root.right.right=createNode(7);
       root.left.right.left=createNode(8);
       root.right.left.left=createNode(9);
       root.right.left.right=createNode(10);
       //System.out.println("Inorder: ");
       //Inorder(root);
       //System.out.println("\nPreorder: ");
       //Preorder(root);
       //System.out.println("\nPostorder: ");
       //Postorder(root);
       BFS(root);
   }
}

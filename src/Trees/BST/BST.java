package Trees.BST;


import java.util.*;

class node
{
    int key;
    node left;
    node right;
    node(int key)
    {
        this.key =key;
        left = null;
        right = null;
    }

}
public class BST {
    node root;

    BST() {
        root = null;
    }

    private node insertRec(node root, int key) {
        if (root == null) {
            return new node(key);
        }
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        return root;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    private boolean searchRec(node root, int key) {
        if (root == null) {
            return false;
        }
        if (key == root.key) {
            return true;
        }
        if (key < root.key) {
            return searchRec(root.left, key);
        } else {
            return searchRec(root.right, key);
        }
    }

    boolean search(int key) {
        return searchRec(root, key);
    }

    private node deleteRec(node root, int key) {
        if (root == null) {
            return root;
        }
        if(key < root.key) {
            root.left = deleteRec(root.left, key);
        }
        else if(key > root.key) {
            root.right = deleteRec(root.right, key);
        }
        else {  //if key is found to be deleted it will come to else part
            //if node has 0 or 1 child
            if (root.left == null && root.right == null) {
                root = null;
                return root;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            node temp = findSuccessor(root.right);
            root.key = temp.key;
            root.right = deleteRec(root.right, temp.key);
        }
        return root;
    }
    private node findSuccessor(node root) {
        while(root.left!=null)
        {
            root=root.left;
        }
        return root;
    }
    void delete(int key)
    {
        root = deleteRec(root, key);
    }

    void Inorder(node root) {
        if (root == null) return;
        Inorder(root.left);
        System.out.print(root.key + " ");
        Inorder(root.right);
    }

    public static void main(String args[]) {
        BST b = new BST();
        b.insert(100);
        b.insert(50);
        b.insert(170);
        b.insert(10);
        b.insert(70);
        b.insert(130);
        b.insert(190);
        b.insert(60);
        b.insert(110);
        b.insert(150);

        b.Inorder(b.root);

        int key=50;
        System.out.println("\n"+b.search(key));

        b.delete(100);
        b.Inorder(b.root);
    }
}
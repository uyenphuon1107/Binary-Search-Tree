/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bts;

/**
 *
 * @author Uyen Le
 * 
 */
 
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class BST {
   class Node {
       int key;
       Node left, right;

       public Node(int k)
       {
           key = k;
           left = right = null;
       }
   }

        Node root;
        Node searchedNode ;

         // This is constructor
        BST()
        {
            root = null;
        }
        
        //// add new node
        void insert(int key)
        {
            root = insertRec(root, key);
        }
        
        Node insertRec(Node root, int key)
        {

            if (root == null)
            {
                root = new Node(key);
                return root;
            }

            if (key < root.key)
                root.left = insertRec(root.left, key);
            else if (key > root.key)
                root.right = insertRec(root.right, key);

            return root;
        }

   // Level order line by line
   void tree()
   {
       Node root = this.root;
       if(root == null)
           return;
       Queue<Node> q =new LinkedList<Node>();
       q.add(root);
       while(true)
       {
           int nodeCount = q.size();
           if(nodeCount == 0)
               break;
           while(nodeCount > 0)
           {
               Node node = q.peek();
               System.out.print(node.key + " ");
               q.remove();
               if(node.left != null)
                   q.add(node.left);
               if(node.right != null)
                   q.add(node.right);
               nodeCount--;
           }
           System.out.println();
       }
   }
  
   // the value of sum to 0
    public class Sum {
        int sum = 0;
    }
  
    void addGreater(Node node, Sum S)
    {
        if (node == null)
            return;
        this.addGreater(node.right, S);
        S.sum = S.sum + node.key;
        node.key = S.sum;
        this.addGreater(node.left, S);
    }
    
    void addGreaterValue()
    {
    Sum S = new Sum();
    this.addGreater(root, S);
    }

   static BST binarySearchTree(int arrays[]){
       BST tree=new BST();
       for(int i :arrays){
           tree.insert(i);
       }
       return tree;
   }
   public static void main(String[] args)
   {
       int array[] = {5, 3, 2, 8, 4, 6, 10};
       System.out.println("Array: "+Arrays.toString(array));
       BST tree = binarySearchTree(array);
       System.out.println("\n");
       System.out.println("The original binary search tree is: ");
       tree.tree();
       tree.addGreaterValue();
       System.out.println("\nThe tree contain the sum of all greater is:");
       tree.tree();
   }
}



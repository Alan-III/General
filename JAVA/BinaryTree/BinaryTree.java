/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytree;

/**
 *
 * @author Alan
 */
public class BinaryTree {

    /**
     * @param args the command line arguments
     */
    static Node root;
    
    public static void main(String[] args) {
        insertNode(20);
       insertNode(25);
       insertNode(9);
       insertNode(12);
       insertNode(14);
       insertNode(5);
       insertNode(11);
        findInnerSuccessor(9);
        findInnerSuccessor(14);
        findInnerSuccessor(20);
        findInnerSuccessor(25);
        findInnerSuccessor(5);
        findInnerSuccessor(11);
        printTree(root);
    }
    
    public static void insertNode(int value){
        Node n= new Node(value);
        if(root==null)
            root=n;
        else
            findCorrectPlaceForNewNode(root,n);
    }
    
    public static void findCorrectPlaceForNewNode(Node currentNode, Node n){
        if(n.value > currentNode.value){
            if (currentNode.right != null)
                findCorrectPlaceForNewNode(currentNode.right,n);
            else{
                currentNode.right = n;
                n.parent = currentNode;
            }          
        } else if(n.value < currentNode.value){
            if (currentNode.left != null)
                findCorrectPlaceForNewNode(currentNode.left,n);
            else{
                currentNode.left = n;
                n.parent = currentNode;
            }   
        } else
            System.out.println("Node with this value exists");
    }
    
    public static void printTree(Node r){
        if(r.left != null)
            printTree(r.left);
        System.out.print(r.value +"\t");
        if(r.right != null)
            printTree(r.right);
        
    }
    
    public static void findInnerSuccessor(int value) {
        
        Node innerNode = getNodeByValue(value);
        Node successor =null;
        if(innerNode!=null){
            if(innerNode.right != null)
                successor = getLeftmostNode(innerNode.right);
            else
                successor = getParentGreater(innerNode);
        }
        if(successor == null)
            System.out.println("There is no Inner Successor for "+innerNode.value);
        else
            System.out.println("The Inner Successor of "+innerNode.value+" is: "+ successor.value);
        
    }
    
    public static Node getParentGreater(Node n){
        if(n.parent == null)
            return null;
        else if (n.parent.value > n.value)
            return n.parent;
        else
            return getParentGreater(n.parent);
    }
    
    public static Node getLeftmostNode(Node n){
        if(n.left != null)
            return getLeftmostNode(n.left);
        else
            return n;
    }
    
    public static Node getNodeByValue(int value){
        Node n = null;
        if(root != null){
           n = root;
           while (n.value != value){
               if(n.value > value)
                   n = n.left;
               else
                   n = n.right;
               if(n==null)
                   break;
           }
        }
        return n;
    }
}
import java.util.*;

class Solution{
   // Write an algorithm to find the ‘next’ node (i.e., in-order successor) of a given node in
   // a binary search tree where each node has a link to its parent.
   class Node{
      int val;
      Node left;
      Node right;
      Node parent;
      Node(int k){
         val = k;
         left = null;
         right = null;
         parent = null;
      }
   }
   static Node successor(Node n){
      if(n==null) return null;
      if(n.right!=null){ // leftmost of right subtree
         Node k = n.right;
         while(k.left!=null) k = k.left;
         return k;
      }
      if(n.parent==null) return null; //n = root
      Node k;
      while(n.parent!=null){ // check if subtree is descendant of a parent.left
         k = n.parent;
         if(k.left==n) return k;
         n = k;
      }
      return null;
   }

   public static void main(String args[]){
      Node n = null;
      Node s = successor(n);
   }
}

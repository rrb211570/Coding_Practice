import java.util.*;

class Solution{
   // You have two very large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes. Create an algorithm to decide if T2 is a subtree of T1.
   static class Node{
      int val;
      Node left;
      Node right;
      Node(int k){
         val = k;
         left = null;
         right = null;
      }
   }
   //pre: subRoot != null
   static boolean checkEquivalency(Node root, Node subRoot){
      if(root==null&&subRoot==null) return true;
      if(root==null||subRoot==null) return false;
      if(root.val!=subRoot.val) return false;
      return checkEquivalency(root.left, subRoot.left) && checkEquivalency(root.right, subRoot.right);
   }
   //pre: subRoot != null
   static boolean isSubTree(Node root, Node subRoot){
      if(root==null) return false;
      if(root.val==subRoot.val){
         if(checkEquivalency(root, subRoot)) return true;
      }
      return isSubTree(root.left, subRoot)) || isSubTree(root.right, subRoot));
   }
   static boolean preprocess_isSubTree(Node root, Node subRoot){
      if(subRoot==null) return true;
      return isSubTree(root, subRoot);
   }

   public static void main(String args[]){
      Node t1;
      Node t2;
      bool encapsulated;
      try{
         encapsulated = isSubTree(t1,t2);
      } catch(Exception e){
         System.out.println("Error: isSubTree(): "+e);
         exit(-1);
      }
   }
}

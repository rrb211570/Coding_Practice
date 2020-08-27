import java.util.*;

class Solution{
   class Node{
      int val;
      Node left;
      Node right;
      Node(int k){
         left = null;
         right = null;
         val = k;
      }
   }
   static int maxDepth(Node root){
      if(root==null) return 0;
      return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
   }
   static int minDepth(Node root){
      if(root==null) return 0;
      return 1 + Math.min(maxDepth(root.left), maxDepth(root.right));
   }
   static boolean isBalanced(Node root){
      if(root==null){
         System.out.println("Err: isBalanced(): Root is null.");
         return false;
      }
      return (maxDepth(root) - minDepth(root)) <= 1;
   }

   public static void main(String args[]){
      Node[] trees;
      for(int i=0;i<trees.length;++i){
         System.out.println("Tree "+i+" balanced? "+isBalanced(trees[i]));
      }
   }
}

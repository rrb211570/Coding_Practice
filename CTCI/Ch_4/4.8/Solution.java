import java.util.*;

class Solution{
   //Assume 0<val
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
   // if val can be negative or zero, we can keep recursing to leaf nodes
   static void tryPathFromRoot(int[] path, Node root, int sum){
      if(root==null) return;
      if(root.val==sum){
         for(int i : path) System.out.print(i+" ");
         System.out.println(sum);
      } else if(root.val<sum){
         int[] newPath = Arrays.copyOf(path, path.length+1);
         newPath[newPath.length-1] = root.val;
         tryPathFromRoot(newpath, root.left, sum-root.val);
         tryPathFromRoot(newpath, root.right, sum-root.val);
      }
   }
   // if h1 = height from current root to current node, runtime = n*sum(h1)
   static void printPaths(Node root, int sum){
      if(root==null) return;
      try{
         tryPathFromRoot(new int[]{}, root, sum);
         printPaths(root.left, sum);
         printPaths(root.right, sum);
      } catch (Exception e){
         System.out.println("Error: printPaths(Node, "+sum+"): "+e);
      }
   }

   public static void main(String args[]){
      Node root;
      int sum;
      printPaths(root, sum);
   }
}

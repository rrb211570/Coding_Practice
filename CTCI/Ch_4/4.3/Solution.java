import java.util.*;

class Solution{
   // Given a sorted (increasing order) array,
   // write an algorithm to create a binary tree with minimal height.
   class Node{
      int val;
      Node left;
      Node right;
      Node(int k){
         val = k;
         left = null;
         right = null;
      };
   }
   static Node toTree(int[] arr){ //len = 6,7,2,3
      if(arr.length==0) return null;
      if(arr.length==1) return new Node(arr[0]);

      int mid = arr[arr.length/2]; //arr[1]
      Node root = new Node(mid);

      int[] left = new int[arr.length/2];
      int[] right = new int[arr.length-arr.length/2-1];
      
      for(int i=0;i<arr.length/2;++i) left[i] = arr[i];
      for(int i=arr.length/2+1;i<arr.length;++i){
         right[i-(arr.length/2+1)] = arr[i];
      }

      root.left = toTree(left);
      root.right = toTree(right);
      return root;
   }

   public static void main(String args[]){
      // no tests here..
      Node root = toTree(int[]{0,1,2,3,4,5});
   }
}

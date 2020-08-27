import java.util.*;

class Solution{
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
   static List<List<Node>> toTreeLevelListing(Node root){
      if(root==null) return null;

      List<List<Node>> ret = new LinkedList<List<Node>>();
      Queue<Node> level = new LinkedList<Node>();
      level.add(root);

      while(!level.isEmpty()){
         int sz = level.size();
         List<Node> curLevel = new LinkedList<Node>();
         while(sz-->0){
            Node cur = level.remove();
            curLevel.add(cur);
            if(cur.left!=null) level.add(cur.left);
            if(cur.right!=null) level.add(cur.right);
         }
         ret.add(curLevel);
      }
      return ret;
   }

   public static void main(String args[]){
      // no tests here...
      Node root = null; //pretend we populate to depth 5
      if(toTreeLevelListing(root)==null) System.out.println("null");
      root = new Node(5);
      List<List<Node>> thing = toTreeLevelListing(root);
      if(thing.size()==1&&thing.get(0).size()==1) System.out.println("works for 1");
   }
}

import java.util.*;

class Solution{
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
      static boolean equals(Node n){
         if(this.val==n.val) return true;
         return false;
      }
   }
   static boolean contains(Node root, Node a){
      if(root==null) return false;
      if(root.equals(a)) return true;
      else return contains(root.left, a) || contains(root.right, a);
   }
   static Node common_Ancestor1(Node root, Node a, Node b){ //if parent variable
      if(root==null||a==null||b==null) throw new Exception("null input");
      if(!contains(root,a)||!contains(root,b)) throw new Exception("a or b not in tree");
      if(a.equals(b)) throw new Exception("a cannot equal b");

      Node par1 = a.parent;
      Node par2 = b.parent;
      List<Node> pathNodeToRoot = new LinkedList();
      while(par1!=null){
         pathNodeToRoot.add(par1);
         par1 = par1.parent;
      }
      while(par2!=null){
         for(Node n : pathNodeToRoot){
            if(par2.equals(n)) return par2;
         }
         par2 = par2.parent;
      }
      return null;
   }
   static Node common_Ancestor2(Node root, Node a, Node b){ //
      if(root==null||a==null||b==null) throw new Exception("null input");
      if(!contains(root,a)||!contains(root,b)) throw new Exception("a or b not in tree");
      if(a.equals(b)) throw new Exception("a cannot equal b");

      if(contains(root.left,a)&&contains(root.left,b)){
         return common_Ancestor2(root.left,a,b);
      }
      if(contains(root.right,a)&&contains(root.right,b)){
         return common_Ancestor2(root.right,a,b);
      }
      return root;
   }

   public static void main(String args[]){
      Node root;
      Node a;
      Node b;
      try{
         Node c = common_Ancestor(root,a,b);
         System.out.print("common_Ancestor("+a+", "+b+"): ");
         if(c==null) System.out.println("null");
         else System.out.println(c.val);
      } catch(Exception e){
         System.out.println("Error: common_Ancestor("+a+", "+b+"): \n"+"     : "+e);
      }
      System.out.println("Reached end of program.");
   }
}

import java.util.*;

class Node{
   Node next;
   int val;
   Node(int k){
      val = k;
      next = null;
   }
   void append(int[] k){
      Node n = this;
      while(n.next!=null) n = n.next;
      for(int c : k){
         n.next = new Node(c);
         n = n.next;
      }
   }
}
class Solution{
   static boolean remove (Node c){ //cannot remove tail
      if(c==null||c.next==null) return false;
      c.val = c.next.val;
      c.next = c.next.next;
      return true;
   }
   static void printList(Node head){
      System.out.print("List: ");
      while(head!=null){
         System.out.print(" "+head.val);
         head = head.next;
      }
      System.out.println();
   }
   public static void main(String args[]){
      Node head = new Node(0);
      head.append(new int[]{1,2,3,4,5});
      printList(head);
      boolean ret = remove(head);
      System.out.println(ret);
      printList(head);
   }
}

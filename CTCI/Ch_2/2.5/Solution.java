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
   static Node cycle_head(Node head1){ //cannot remove tail
      if(head1==null||head1.next==null) return null;
      Node race1 = head1;
      Node race2 = head1;
      while(true){
         race1 = race1.next;
         if(race1.next==null) return head1;
         race2 = race2.next;
         if(race2.next==null) return head1;
         race2 = race2.next;
         if(race2.next==null) return head1;
         if(race1.val==race2.val) return race1;
      }
   }
   static Node cycle_head2(Node head1){
      List<Integer> seen = new LinkedList<Integer>();
      while(head1!=null){
         if(seen.contains(head1.val)) return head1;
         else seen.add(head1.val);
         head1 = head1.next;
      }
      return null;
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
      Node head1 = new Node(0);
      head1.append(new int[]{1,2,3,4,5,6,7});
      Node last = head1;
      while(last.next!=null) last = last.next;
      last.next = head1;

      Node ret = cycle_head(head1);
      System.out.println(ret.val);
   }
}

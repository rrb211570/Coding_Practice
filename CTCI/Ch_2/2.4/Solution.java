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
   static Node sum_linked(Node head1, Node head2, int carry){ //cannot remove tail
      if(head1==null||head2==null) {
         if(carry==1) return new Node(1);
         else return null;
      }
      int sum = carry;
      if(head1!=null){
         sum += head1.val;
         head1 = head1.next;
      }
      if(head2!=null){
         sum += head2.val;
         head2 = head2.next;
      }
      carry = sum/10;
      Node ret = new Node(sum%10);
      ret.next = sum_linked(head1, head2, carry);
      return ret;
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
      Node head1 = new Node(3);
      head1.append(new int[]{1,9});
      Node head2 = new Node(5);
      head2.append(new int[]{9,2});

      printList(head1);
      printList(head2);
      Node ret = sum_linked(head1, head2, 0);
      printList(ret);
   }
}

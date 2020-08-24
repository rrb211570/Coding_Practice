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
   static void nth_FromLast(Node head,int n){ //Assume n>0
      int len = 0;
      Node count = head;
      while(count!=null){
         count = count.next;
         len++;
      }
      if(len-1<n||len<1) System.out.println("Error: nth_FromLast: Insufficient nodes");
      else {
         int index=1;
         while(index!=len - n){ // len 5, n 4
            head = head.next;
            index++;
         }
         System.out.println("nth_FromLast: "+head.val);
      }
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
      head.append(new int[]{1,2,3,4});
      nth_FromLast(head, 0);
      nth_FromLast(head, 1);
      nth_FromLast(head, 2);
      nth_FromLast(head, 3);
      nth_FromLast(head, 4);

   }
}

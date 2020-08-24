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
   static void groupUnique(Node head){
      if(head==null||head.next==null) return;
      HashSet<Integer> numbers = new HashSet<Integer>();
      Node n = head;
      while(n!=null){
         numbers.add(n.val);
         n = n.next;
      }
      Node prev = head;
      numbers.remove(prev.val);
      Node cur = prev.next;
      while(cur!=null){
         if(!numbers.contains(cur.val)){ //remove node
            prev.next = prev.next.next;
            cur = prev.next;
         } else {
            numbers.remove(cur.val);
            prev = cur;
            cur = cur.next;
         }
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
      Node t0 = null;
      Node t1 = new Node(0);
      t1.append(new int[]{1,-2,3,-4,5});
      Node t2 = new Node(0);
      t2.append(new int[]{1,2,2,4,5});
      Node t3 = new Node(0);
      t3.append(new int[]{1,-2,3,-2,5});
      Node t4 = new Node(0);
      t4.append(new int[]{0,0,0,0,0});

      Node[] nodeList =  new Node[]{t0,t1,t2,t3,t4};
      for(Node k : nodeList){
         System.out.print("\noriginal: ");
         printList(k);
         groupUnique(k);
         System.out.print("removed:  ");
         printList(k);
      }
   }
}

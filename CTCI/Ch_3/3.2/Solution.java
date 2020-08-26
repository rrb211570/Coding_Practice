import java.util.*;

class Solution{
   /*How would you design a stack which, in addition to push and pop, also has a function
   min which returns the minimum element? Push, pop and min should all operate in
   O(1) time*/
   static class Node{
      Node next;
      int val;
      int min;
      Node(int k){
         next = null;
         val = k;
         min = k;
      }
   }
   static class Stack{
      //can also be implemented as linked list w/ buffer, nodeptr replaced w/ cur
      Node[] buffer;
      int nodePtr;
      Stack(int len){
         buffer = new Node[len];
         nodePtr = -1;
      }
      void push(int k){
         if(nodePtr==buffer.length-1){
            System.out.println("Err: stack full");
            return;
         }
         Node t = new Node(k);
         if(this.peek().min<t.min) t.min = this.peek().min;
         buffer[++nodePtr] = t;;
      }
      Node pop(){
         if(nodePtr==-1){
            System.out.println("Err: Stack Empty");
            return null;
         }
         Node ret = this.peek();
         buffer[nodePtr--] = null;
         return ret;
      }
      Node peek(){
         if(nodePtr==-1){
            System.out.println("Err: Stack Empty");
            return null;
         }
         return buffer[nodePtr];
      }
      boolean isEmpty(){
         return nodePtr == -1;
      }
      int min(){
         if(this.isEmpty()) return Integer.MAX_VALUE;
         else return this.peek().min;
      }
   }

   public static void main(String args[]){
      //no testing for this..
   }
}

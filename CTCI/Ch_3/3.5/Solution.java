import java.util.*;

class Solution{

   static class MyQueue{
      Stack<Integer> in;
      Stack<Integer> out;
      MyQueue(){
         in = new Stack<Integer>();
         out = new Stack<Integer>();
      }
      static void add(int k){
         in.push(k);
         if(out.isEmpty()){
            while(!in.isEmpty()){
               out.push(in.pop());
            }
         }
      }
      static int remove(){
         if(out.isEmpty()){
            System.out.println("Err: MyQueue is empty.");
            return -1;
         } else return out.pop();
      }
      static int peek(){
         if(out.isEmpty()){
            System.out.println("Err: MyQueue is empty.");
            return -1;
         } else return out.peek();
      }
      static int length(){
         return in.length() + out.length();
      }
   }

   public static void main(String args[]){
      // no tests here...
   }
}

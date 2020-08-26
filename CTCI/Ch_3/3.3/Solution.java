import java.util.*;

class Solution{
   static Class Stack{
      int[] buf;
      int ptr;
      Stack(int size){
         buf = new int[size];
         ptr = -1;
      }
      void push(int k){
         buf[++ptr] = k;
      }
      int pop(){
         int ret = buf[ptr];
         buf[ptr--] = null;
         return ret;
      }
      int peek(){
         return buf[ptr];
      }
   }
   static class SetOfStacks{
      ArrayList<Stack> stacks = new ArrayList<Stack>();
      int threshold;
      SetOfStacks(int k){
         threshold = k;
         stacks.add(new Stack(threshold));
      }
      void push(int k){
         if(stacks.get(stacks.length()-1).ptr==threshold-1){
            stacks.add(new Stack(threshold));
         }
         stacks.get(stacks.length()-1).push(k);
      }
      int pop(){
         int index = stacks.length()-1;
         Stack sc = stacks.get(index);
         if(sc.ptr==-1){
            System.out.println("Err: SetOfStacks is empty.");
            return -1;
         }
         if(sc.ptr==0){
            int ret = sc.peek();
            stacks.remove(index);
            return ret;
         }
         return sc.pop();
      }
      private void rollOver(int stackNum, int pos){
         Stack sc = stacks.get(stackNum);
         int i;
         for(i=pos;pos<sc.ptr;++i){
            sc.buf[pos] = sc.buf[pos+1];
         }
         if(stackNum<stacks.length()){
            sc.buf[i] = stacks.get(++stackNum).buf[0];
            rollOver(stackNum, 0);
         }
      }
      int popAt(int stackNum){ // starting at 1
         if(stacks.length()<stackNum){
            System.out.println("Err: Invalid stackNum");
            return -1;
         }
         Stack sc = stacks.get(stackNum);
         if(stackNum==stacks.length()) return sc.pop();
         int ret = sc.pop();
         rollOver(stackNum, sc.ptr+1);
         return ret;
      }
      public static void main(String args[]){
         //no tests here..
      }
   }

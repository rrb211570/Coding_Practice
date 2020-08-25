import java.util.*;

// Describe how you could use a single array to implement three stacks.

/*You could partition into three subarrays, and grow from the bottom of the subarray
to the upper bound of the subarray limit.*/
class Stack{
   int stackSize;
   int[] buffer;
   int[] stackPtr;
   Stack(int size){
      stackSize = size/3;
      buffer = new int[size];
      stackPtr = new int[]{-1,-1,-1};
   };
   int pop(int stackNum){ // 0,1,2
      if(stackNum>2||stackNum<0){
         System.out.println("Err: Invalid stackNum: "+stackNum);
         return Integer.MIN_VALUE;
      }
      if(stackPtr[stackNum]==-1){
         System.out.println("Stack: "+stackNum+" is empty.");
         return Integer.MIN_VALUE;
      }
      int index = stackNum * stackSize + stackPtr[stackNum];
      stackPtr[stackNum]--;
      int val = buffer[index];
      buffer[index] = 0;
      return val;
   }
   void push(int stackNum, int value){
      if(stackNum>2||stackNum<0){
         System.out.println("Err: Invalid stackNum: "+stackNum);
         return;
      }
      if(stackPtr[stackNum]==stackSize-1){
         System.out.println("Stack: "+stackNum+" is full.");
         return;
      }
      stackPtr[stackNum]++;
      int index = stackNum * stackSize + stackPtr[stackNum];
      buffer[index] = value;
   }
   int peek(int stackNum){
      if(stackNum<0||stackNum>2){
         System.out.println("Err: Invalid stackNum: "+stackNum);
         return -1;
      }
      if(stackPtr[stackNum]==-1){
         System.out.println("Err: Stack "+stackNum+" empty.");
         return -1;
      }
      else return buffer[stackNum * stackSize + stackPtr[stackNum]];
   }
   boolean isEmpty(int stackNum){
      if(stackNum<0||stackNum>2){
         System.out.println("Err: Invalid stackNum: "+stackNum);
         return true;
      }
      return stackPtr[stackNum] == -1;
   }
}

class Solution{
   public static void main(String[] args){
      Stack sc = new Stack(10);
      sc.pop(-1);
      sc.pop(0);
      sc.pop(1);
      sc.pop(2);
      sc.pop(3);

      sc.peek(-1);
      sc.peek(0);
      sc.peek(1);
      sc.peek(2);
      sc.peek(3);

      sc.isEmpty(-1);
      System.out.println(sc.isEmpty(0));
      System.out.println(sc.isEmpty(1));
      System.out.println(sc.isEmpty(2));
      sc.isEmpty(3);

      sc.push(-1,1);
      sc.push(0,1);
      sc.push(1,1);
      sc.push(2,1);
      sc.push(3,1);

      sc.peek(-1);
      System.out.println(sc.peek(0));
      System.out.println(sc.peek(1));
      System.out.println(sc.peek(2));
      sc.peek(3);

      sc.pop(-1);
      System.out.println(sc.pop(0));
      System.out.println(sc.pop(1));
      System.out.println(sc.pop(2));
      sc.pop(3);

      sc.peek(-1);
      System.out.println(sc.peek(0));
      System.out.println(sc.peek(1));
      System.out.println(sc.peek(2));
      sc.peek(3);

      sc.push(-1,1);
      sc.push(0,1);
      sc.push(1,1);
      sc.push(2,1);
      sc.push(3,1);

      sc.push(-1,1);
      sc.push(0,1);
      sc.push(1,1);
      sc.push(2,1);
      sc.push(3,1);

      sc.push(-1,1);
      sc.push(0,1);
      sc.push(1,1);
      sc.push(2,1);
      sc.push(3,1);

      sc.push(-1,1);
      sc.push(0,1);
      sc.push(1,1);
      sc.push(2,1);
      sc.push(3,1);
   }
}

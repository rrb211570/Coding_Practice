import java.util.*;

class Solution{
   static class Stack{/* Assume it works...*/
      int k;
   }
   static void hanoi(Stack[] stacks, int elems){
      if(elems<1){
         System.out.println("Err: elems: "+elems+". must be greater than 0.");
         return;
      }
      stacks_initialize(stacks, elems);
      if(elems==1) stacks[2].push(stacks[0].pop());
      else hanoi(0,elems,2);
   }
   static void hanoi_rec(int source, int elems, int target){
      if(elems<1) return;
      if(elems==1){
         stacks[target].push(stacks[source].pop());
         return;
      }
      int empty;
      if(source!=0&&target!=0) empty = 0;
      if(source!=1&&target!=1) empty = 1;
      if(source!=2&&target!=2) empty = 2;
      hanoi_rec(source,elems-1,empty);
      stacks[target].push(stacks[source].pop());
      hanoi_rec(empty,elems-1,target);
   }

   public static void main(String args[]){
      // no testing here..
   }
}

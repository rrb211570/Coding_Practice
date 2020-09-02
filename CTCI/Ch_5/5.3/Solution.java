import java.util.*;

class Solution{
   //Given an integer, print the next smallest and next largest number that have the same number of 1 bits in their binary representation.
   // Pre: val>1
   static void rightAlign(StringBuilder bin, int countOnes, int index){
      for(int i=31; i>31-countOnes; --i) bin.setCharAt(i,'1');
      for(int i=31-countOnes; i>index; --i) bin.setCharAt(i,'0');
   }
   static void leftAlign(StringBuilder bin, int countOnes, int index){
      for(int i=index+1; i<(32-(32-(index+1)-countOnes)); ++i) bin.setCharAt(i,'1');
      for(int i=(32-(32-(index+1)-countOnes)); i<32; ++i) bin.setCharAt(i,'0');
   }
   static void printNextBiggest(StringBuilder bin, int val){
      int index = 31, countOnes = -1;
      while(bin.charAt(index)=='0') index--;
      while(bin.charAt(index)=='1'){
         countOnes++;
         index--;
      };
      bin.setCharAt(index, '1'); // bin.charAt(index) currently zero
      bin.setCharAt(++index, '0');
      rightAlign(bin, countOnes, index);
      System.out.println("Next Biggest ("+val+"): "+bin.toString());
   }
   static void printNextSmallest(StringBuilder bin, int val){
      int index = 31, countOnes = 0;
      while(bin.charAt(index)=='1'){
         countOnes++;
         index--;
      }
      while(bin.charAt(index)=='0') index--;
      bin.setCharAt(index, '0');  // bin.charAt(index) currently one
      bin.setCharAt(++index, '1');
      leftAlign(bin, countOnes, index);
      System.out.println("Next Smallest ("+val+"): "+bin.toString());
   }
   static void sameNumOfBinaryOnes_nextAndPrev(int val){
      try{
         StringBuilder bin = new StringBuilder();
         String s = Integer.toBinaryString(val);
         for(int i=0;i<32-s.length();++i) bin.append('0');
         bin.append(s);
         StringBuilder bin2 = new StringBuilder(bin.toString());

         boolean left_aligned = true;
         boolean right_aligned = true;
         if(bin.indexOf("01",1)>-1) left_aligned = false;
         if(bin.indexOf("10",1)>-1) right_aligned = false;

         if(!left_aligned) printNextBiggest(bin,val);
         bin.delete(0,bin.length());
         for(int i=0;i<32-s.length();++i) bin.append('0');
         bin.append(s);
         if(!right_aligned) printNextSmallest(bin2,val);
      } catch(Exception e){
         System.out.println("ERROR: sameNumOfBinaryOnes_nextAndPrev(): "+e);
      }
   }

   public static void main(String args[]){
      for(int i=2;i<15;++i){
         sameNumOfBinaryOnes_nextAndPrev(i);
         System.out.println();
      }
   }
}

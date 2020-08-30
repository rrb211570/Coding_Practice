import java.util.*;

class Solution{
//You are given two 32-bit numbers, N and M, and two bit positions, i and j. Write a method to set all bits between i and j in N equal to M (e.g., M becomes a substring of N located at i and starting at j).
   static int replaceSubString(int a, int b, int i, int j){
      try{
         int window = -1 >>> (32-(j+1-i));
         window = window << i;
         return (a & ~window) ^ (b & window);
      } catch(Exception e){
         System.out.println("Error: replaceSubString(): "+e);
         return -1;
      }
   }
   static class Entry{
      int a;
      int b;
      int i;
      int j;
      Entry(int aa, int bb, int ii, int jj){
         a = aa;
         b = bb;
         i = ii;
         j = jj;
      }
   }
   public static void main(String args[]){
      HashMap<Entry,Integer> mapping = new HashMap<Entry,Integer>();
      mapping.put(new Entry(0b00000000000,0b00000000000,2,6),0b00000000000);
      mapping.put(new Entry(0b00000000000,0b11111111111,2,6),0b00001111100);
      mapping.put(new Entry(0b11111111111,0b00000000000,2,6),0b11110000011);
      mapping.put(new Entry(0b11111111111,0b11111111111,2,6),0b11111111111);
      mapping.put(new Entry(0b10000101000,0b11111010111,2,6),0b10001010100);
      int pass = 0, tests = 5;
      for(Entry p : mapping.keySet()){
         if(replaceSubString(p.a, p.b, p.i, p.j)==mapping.get(p)) pass++;
      }
      System.out.println("replaceSubString(): "+pass+"/"+tests+" tests passed.");
   }
}

import java.util.*;

/*Design an algorithm and write code to remove the duplicate characters in a string
without using any additional buffer.
NOTE: One or two additional variables are fine.
An extra copy of the array is not.
NOTE: Use '|' to denote end of array if duplicate characters removed*/
class Solution{
   static void group_Duplicate_Char(char[] str){
      if(str==null||str.length<2) return;

      boolean[] seen = new boolean[256];
      for(int i=0;i<seen.length;++i) seen[i] = false;

      int end=0; // aabcdd8
      for(int i=0;i<str.length;++i){
         if(!seen[str[i]]){
            str[end++] = str[i];
            seen[str[i]] = true;
         }
      }
      if(end!=str.length) str[end] = '|';
   }

   public static void main(String args[]){
      char[] test0 = null;
      char[] test1 = "".toCharArray();
      char[] test1_out = "".toCharArray();
      char[] test2 = "y".toCharArray();
      char[] test2_out = "y".toCharArray();
      char[] test3 = "abbcccccdcc$%^&////////".toCharArray();
      char[] test3_out = "abcd$%^&/|".toCharArray();
      char[] test4 = "tybxc".toCharArray();
      char[] test4_out = "tybxc".toCharArray();
      char[] test5 = "bbb".toCharArray();
      char[] test5_out = "b|".toCharArray();

      int pass = 0, tests = 6; /*pass2, pass3, etc. */

      char[] b = null;
      group_Duplicate_Char(b);
      if(b==null) pass++;

      group_Duplicate_Char(test1);
      if(test1.length==0) pass++;
      group_Duplicate_Char(test2);
      if(test2.length==1&&test2[0]==test2_out[0]) pass++;

      group_Duplicate_Char(test3);
      for(int i=0;i<test3.length;++i){
         if(test3[i]!=test3_out[i]) break;
         if(i==test3.length-1||(test3[i]=='|'&&test3_out[i]=='|')){
            pass++;
            break;
         }
      }
      for(char c : test3) System.out.print(c);
      System.out.println();
      for(char c : test3_out) System.out.print(c);
      System.out.println();


      group_Duplicate_Char(test4);
      for(int i=0;i<test4.length;++i){
            if(test4[i]!=test4_out[i]) break;
            if(i==test4.length-1||(test4[i]=='|'&&test4_out[i]=='|')){
               pass++;
               break;
            }
      }

      group_Duplicate_Char(test5);
      for(int i=0;i<test5.length;++i){
         if(test5[i]!=test5_out[i]) break;
         if(i==test5.length-1||(test5[i]=='|'&&test5_out[i]=='|')){
            pass++;
            break;
         }
      }

      System.out.println("function: "+pass+"/"+tests+" passed.");
   }
}

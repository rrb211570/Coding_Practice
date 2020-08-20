import java.util.*;

class Solution{

   static void reverse_C(char[] c_string){
      if(c_string==null||c_string.length<3) return;

      int mid = (c_string.length-1)/2;
      int last = c_string.length-2;
      for(int i=0;i<mid;++i){
         if(c_string[i]!=c_string[last-i]){
            c_string[i] ^= c_string[last-i];
            c_string[last-i] ^= c_string[i];
            c_string[i] ^= c_string[last-i];
         }
      }
   }

   public static void main(String args[]){
      char[] test0 = null;
      char[] test1 = "abccd$%^&/\0".toCharArray();
      char[] test1_out = "/&^%$dccba\0".toCharArray();
      char[] test2 = "\0".toCharArray();
      char[] test2_out = "\0".toCharArray();
      char[] test3 = "y\0".toCharArray();
      char[] test3_out = "y\0".toCharArray();


      int pass = 0; /*pass2, pass3, etc. */
      reverse_C(test0);
      if(test0==null) pass++;

      reverse_C(test1);
      for(int i=0;i<test1.length-1;++i){
         if(test1[i]!=test1_out[i]) break;
         if(i==test1.length-2) pass++;
      }
      reverse_C(test2);
      if(test2.length==test2_out.length&&test2[0]==test2_out[0]) pass++;
      reverse_C(test3);
      if(test3.length==test3_out.length&&test3[0]==test3_out[0]&&
         test3[1]==test3_out[1]) pass++;

      System.out.println("function: "+pass+"/4 passed.");
   }
}

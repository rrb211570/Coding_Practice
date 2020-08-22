import java.util.*;

class Solution{

   static boolean isRotation(char[] str, char[] str2){
      if(str==null||str2==null||str.length!=str2.length||str.length==0) return false;
      char[] poss_Rotations = new char[str.length*2];
      for(int i=0;i<str.length;++i) poss_Rotations[i] = str[i];
      for(int i=0;i<str.length;++i) poss_Rotations[str.length+i] = str[i];
      return isSubstring(str2,poss_Rotations));
   }

   public static void main(String args[]){
      System.out.println("*** Need code for substring() to test ***");
      if(isRotation({'a','b','c'},{'c','a','b'})) System.out.println("Success!");
      else System.out.println("Fail.");
   }
}

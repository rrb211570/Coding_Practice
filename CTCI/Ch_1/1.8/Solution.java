import java.util.*;

class Solution{

   static boolean isRotation(char[] str, char[] str2){
      if(str==null||str2==null||str.length!=str2.length) return false;
      if(str.length==0) return true;
      char[] poss_Rotations = new char[str.length*2];
      for(int i=0;i<str.length;++i) poss_Rotations[i] = str[i];
      for(int i=0;i<str.length;++i) poss_Rotations[str.length+i] = str[i];
      if(isSubstring(str2,poss_Rotations)) return true;
      else return false;
   }

   public static void main(String args[]){
      System.out.println("Can't check this, because we don't have code for substring()");
      if(isRotation({'a','b','c'},{'c','a','b'})) System.out.println("Success!");
      else System.out.println("Fail.");
   }
}

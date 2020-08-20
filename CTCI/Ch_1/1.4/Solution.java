import java.util.*;

class Solution{
   // Write a method to decide if two strings are anagrams or not.
   static boolean isAnagram(String a, String b){
      if(a==null&&b==null) return true;
      if(a==null||b==null) return false;
      if(a.length()==b.length()&&a.length()==0) return true;
      else if(a.length()!=b.length()) return false;

      for(int i=0;i<a.length();++i){
         if(a.charAt(i)!=b.charAt(b.length()-1-i)) return false;
      }

      return true;
   }
   static class Pair{
      String a;
      String b;
      Pair(){};
      Pair(String aa, String bb){
         a = aa;
         b = bb;
      }
   }
   public static void main(String args[]){
      HashMap<Pair,Boolean> mapping = new HashMap<Pair,Boolean>();

      String a=null, b = null;
      mapping.put(new Pair(a,b), true);
      mapping.put(new Pair(a,"hello"), false);
      mapping.put(new Pair("",""), true);
      mapping.put(new Pair("b","b"), true);
      mapping.put(new Pair("bab","bab"), true);
      mapping.put(new Pair("baab","baab"), true);
      mapping.put(new Pair("abcd","abcd"), false);

      int pass = 0; /*pass2, pass3, etc. */
      int tests = mapping.size();
      for(Pair p: mapping.keySet()){
         if(isAnagram(p.a,p.b)==mapping.get(p)) pass++;
      }

      System.out.println("function: "+pass+"/"+tests+" passed.");
   }
}

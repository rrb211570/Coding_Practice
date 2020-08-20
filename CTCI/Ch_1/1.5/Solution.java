import java.util.*;

class Solution{
   // Write a method to replace all spaces in a string with ‘%20’
   static char[] replace(char[] str){
      if(str==null||str.length==0) return str;

      int spaces = 0;
      for(char c : str){
         if(c==' ') spaces++;
      }
      char[] ret = new char[str.length+(2*spaces)];
      int index=0;
      for(int i=0;i<str.length;++i){
         if(str[i]==' '){
            ret[index++] = '%';
            ret[index++] = '2';
            ret[index++] = '0';
         }
         else ret[index++] = str[i];
      }
      return ret;
   }

   public static void main(String args[]){
      HashMap<char[],char[]> mapping = new HashMap<char[],char[]>();

      char[] tt = null;
      mapping.put(tt, tt);
      mapping.put("".toCharArray(), "".toCharArray());
      mapping.put("a".toCharArray(), "a".toCharArray());
      mapping.put(" ".toCharArray(), "%20".toCharArray());
      mapping.put(" a".toCharArray(), "%20a".toCharArray());
      mapping.put("a ".toCharArray(), "a%20".toCharArray());
      mapping.put("The cat jumped over the moon.".toCharArray(),
                  "The%20cat%20jumped%20over%20the%20moon.".toCharArray());
      mapping.put("   ".toCharArray(), "%20%20%20".toCharArray());

      int pass = 0; /*pass2, pass3, etc. */
      int tests = mapping.size();
      for(char[] a : mapping.keySet()){
         char[] out = replace(a);
         char[] tmp = mapping.get(a);
         if(out==null&&tmp==null) ++pass;
         else if(out.length==tmp.length){
            for(int i=0;i<out.length;++i){
               if(out[i]!=tmp[i]) break;
               if(i==out.length-1) ++pass;
            }
            if(out.length==0) ++pass;
         }
      }

      System.out.println("replace(): "+pass+"/"+tests+" passed.");
   }
}

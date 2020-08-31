import java.util.*;

class Solution{
   //Assume val correctly contains a double
   static void printDecToBin(String val){
      try{
         if(val==null) throw new NullPointerException();
         String preDecimal;
         String postDecimal;
         int index=-1;
         while(val.charAt(++index)!='.');
         preDecimal = Integer.toBinaryString(Integer.parseInt(val.substring(0,index)));
         postDecimal = Integer.toBinaryString(Integer.parseInt(val.substring(index+1,val.length())));
         System.out.println(preDecimal+"."+postDecimal);
      } catch(Exception e){
         System.out.println("ERROR: printDecToBin(): "+e);
      }
   }

   public static void main(String args[]){]
      printDecToBin("0.101");
      printDecToBin("13.111");
   }
}

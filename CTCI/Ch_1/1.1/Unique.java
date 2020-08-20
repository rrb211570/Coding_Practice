import java.util.*;

//string = "baklava"
class Unique {

   static void merge(char[] arr, int begin1, int end1, int begin2, int end2){
      if(end1-begin1<0||end2-begin2<0) return;
      Stack<Character> st = new Stack<Character>();
      Stack<Character> st2 = new Stack<Character>();

      for(int i=end1;i>=begin1;--i) st.push(arr[i]);
      for(int i=end2;i>=begin2;--i) st2.push(arr[i]);

      int index = begin1;
      while(!st.isEmpty()&&!st2.isEmpty()){
         if(st.peek()<st2.peek()) arr[index++] = st.pop();
         else arr[index++] = st2.pop();
      }
      while(!st.isEmpty()) arr[index++] = st.pop();
      while(!st2.isEmpty()) arr[index++] = st2.pop();
      return;
   }
   static void mergeSort(char[] arr, int begin, int end){
      if(arr==null||arr.length==0||end-begin<1) return;

      mergeSort(arr,begin,(begin+end)/2);
      mergeSort(arr,(begin+end)/2+1,end);
      merge(arr,begin, (begin+end)/2, (begin+end)/2 + 1, end);
   }
   static boolean unique(String s){
      if(s==null||s.length()<2) return true;

      char[] letters = s.toCharArray();
      mergeSort(letters,0,letters.length-1);

      for(int i=0;i<letters.length-1;++i){
         if(letters[i]==letters[i+1]) return false;
      }
      return true;
   }

   static boolean unique2(String s){
      if(s==null||s.length()<2) return true;
      HashSet<Character> hist = new HashSet<Character>();

      for(char c : s.toCharArray()){
         if(hist.contains(c)) return false;
         else hist.add(c);
      }
      return true;
   }

   static boolean unique3(String s){
      if(s==null||s.length()<2) return true;

      int c1 = (int) s.charAt(0);
      int c2 = (int) s.charAt(s.length()-1);

      for(int i=1;i<s.length();++i) c1 = ~(c1 | (int) s.charAt(i));
      for(int i=s.length()-2;i>-1;--i) c1 = ~(c2 | (int) s.charAt(i));

      if(c1!=c2) return false;
      else return true;
   }

   public static void main(String[] args){
      HashMap<String, Boolean> mapping = new HashMap<String, Boolean>();
      String b = null;
      mapping.put(b, true);
      mapping.put("", true);
      mapping.put("bb", false);
      mapping.put("baklava", false);
      mapping.put("kaplevin*^$@/+y., f", true);

      int pass = 0, pass2 = 0, tests = mapping.size();
      for(String s : mapping.keySet()){
         if(mapping.get(s)==unique(s)) pass++;
         if(mapping.get(s)==unique2(s)) pass2++;
      }

      System.out.println("unique: "+pass+"/"+tests+" passed.");
      System.out.println("unique2: "+pass2+"/"+tests+" passed.");
   }
}

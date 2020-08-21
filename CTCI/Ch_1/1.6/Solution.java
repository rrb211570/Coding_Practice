import java.util.*;

class Solution{
   /*Given an image represented by an NxN matrix, where each pixel in the image is 4
   bytes, write a method to rotate the image by 90 degrees. Can you do this in place?*/
   static void rotate(int[][] matrix){
      if(matrix==null||matrix.length==0||
      matrix.length!=matrix[0].length||matrix.length==1) return;

      int[] side = new int[matrix.length];
      int mid = matrix.length/2;
      int tmp;
      for(int i=0;i<mid;++i){
         for(int j=i;j<matrix.length-1-i;++j){
            tmp = matrix[i][j];
            matrix[i][j] = matrix[matrix.length-1-j][i];
            matrix[matrix.length-1-j][i] = matrix[matrix.length-1-i][matrix.length-1-j];
            matrix[matrix.length-1-i][matrix.length-1-j] = matrix[j][matrix.length-1-i];
            matrix[j][matrix.length-1-i] = tmp;
         }
      }
   }
   static boolean test_matrix(int[][] matrix, boolean verbose){
      for(int i=0;i<matrix.length;++i){
         for(int j=0;j<matrix.length/2;++j) matrix[i][j] = 0;
         for(int j=matrix.length/2;j<matrix.length;++j) matrix[i][j] = 1;
      }
      if(verbose){
         System.out.println("      Initial:\n--------------------");
         for(int i=0;i<matrix.length;++i){ //print matrix
            for(int j=0;j<matrix.length;++j) System.out.print(matrix[i][j]);
            System.out.println();
         }
         System.out.println();
      }
      rotate(matrix);
      if(verbose){
         System.out.println("    After rotate:\n---------------------");
         for(int i=0;i<matrix.length;++i){
            for(int j=0;j<matrix.length;++j) System.out.print(matrix[i][j]);
            System.out.println();
         }
         System.out.println();
      }
      boolean flag1=true;
      for(int i=0;i<matrix.length;++i){
         for(int j=0;j<matrix.length;++j){
            if(i<matrix.length/2&&matrix[i][j]!=0) flag1 = false;
            else if(i>=matrix.length/2&&matrix[i][j]!=1) flag1 = false;
         }
      }
      if(flag1) return true;
      else return false;
   }
   public static void main(String args[]){
      int pass = 0, tests = 6;

      int[][] a = null;
      rotate(a);
      if(a==null) ++pass;

      int[][] b = new int[0][0];
      try{ rotate(b); pass++;
      } catch(Exception e){ System.out.println("Error: rotating empty array"); }

      int[][] c = {{1}};
      rotate(c);
      if(c[0][0]==1) pass++;

      int[][] d = {{1,2}};
      rotate(d);
      if(d[0][0]==1&&d[0][1]==2) pass++;

      if(test_matrix(new int[4][4], true)) pass++; // set second parameter to
      if(test_matrix(new int[7][7], true)) pass++; // false to hide print output

      System.out.println("rotate(): "+pass+"/"+tests+" passed.");
   }
}

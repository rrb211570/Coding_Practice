import java.util.*;

class Solution{
   //Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
   //column is set to 0.
   static void zero_row(int[][] matrix, int row){
      for(int i=0;i<matrix[row].length;++i) matrix[row][i] = 0;
   }
   static void zero_col(int[][] matrix, int col){
      for(int i=0;i<matrix.length;++i) matrix[i][col] = 0;
   }
   static void zero_extend_2D(int[][] matrix){
      if(matrix==null||matrix.length==0||matrix[0].length==0) return;
      boolean[] row = new boolean[matrix.length];
      Arrays.fill(row,false);
      boolean[] col = new boolean[matrix[0].length];
      Arrays.fill(col,false);

      for(int i=0;i<matrix.length;++i){
         for(int j=0;j<matrix[0].length;++j){
            if(matrix[i][j]==0){
               row[i] = true;
               col[j] = true;
            }
         }
      }

      for(int i=0;i<row.length;++i){
         if(row[i]) zero_row(matrix,i);
      }

      for(int i=0;i<col.length;++i){
         if(col[i]) zero_col(matrix,i);
      }
   }
   public static void main(String args[]){

      int pass = 0, tests = 12;
      try{ // edge cases
         int[][] matrix = null;
         zero_extend_2D(matrix);
         pass++;
         zero_extend_2D(new int[0][0]);
         pass++;
         zero_extend_2D(new int[0][1]);
         pass++;
         zero_extend_2D(new int[1][0]);
         pass++;
      } catch(Exception e){
         System.out.println("Error: function(edge case)" + e);
      }

      HashMap<int[][] , int[][]> mapping = new HashMap<int[][],int[][]>();
      mapping.put(new int[][]{{0,0,0},{0,0,0},{0,0,0}} , new int[][]{{0,0,0},{0,0,0},{0,0,0}});
      mapping.put(new int[][]{{1,1,1},{1,1,1},{1,1,1}} , new int[][]{{1,1,1},{1,1,1},{1,1,1}});
      mapping.put(new int[][]{{0,1,1},{1,0,1},{1,1,1}} , new int[][]{{0,0,0},{0,0,0},{0,0,1}});
      mapping.put(new int[][]{{0,1,0},{1,0,1},{1,1,1}} , new int[][]{{0,0,0},{0,0,0},{0,0,0}});
      mapping.put(new int[][]{{0,1,1},{1,1,0},{1,1,1}} , new int[][]{{0,0,0},{0,0,0},{0,1,0}});
      mapping.put(new int[][]{{0,1,0},{1,1,1},{1,1,1}} , new int[][]{{0,0,0},{0,1,0},{0,1,0}});
      mapping.put(new int[][]{{0,1,1,1},{1,0,1,1},{1,1,1,1}} , new int[][]{{0,0,0,0},{0,0,0,0},{0,0,1,1}});
      mapping.put(new int[][]{{0,1},{1,1},{1,1}} , new int[][]{{0,0},{0,1},{0,1}});
      for(int[][] test : mapping.keySet()){
         try{
            int[][] matrix = test;
            zero_extend_2D(matrix);
            boolean passed = true;
            for(int i=0;i<matrix.length;++i){
               for(int j=0;j<matrix[0].length;++j){
                  if(mapping.get(test)[i][j]!=matrix[i][j]) passed = false;
               }
            }
            if(passed) pass++;
         } catch(Exception e){
            System.out.println("Error: zero_extend_2D(): " + e);
         }
      }

      System.out.println("zero_extend_2D(): "+pass+"/"+tests+" passed.");
   }
   static void print_matrix(int[][] matrix){
      if(matrix==null||matrix.length==0||matrix[0].length==0) return;
      for(int i=0;i<matrix.length;++i){
         for(int j=0;j<matrix[0].length;++j) System.out.print(matrix[i][j]);
         System.out.println();
      }
      System.out.println();
   }
}

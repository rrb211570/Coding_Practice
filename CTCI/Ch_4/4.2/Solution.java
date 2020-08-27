import java.util.*;

class Solution{
   // Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
   static class Node{
      Node[] adj;
      Node(Node[] neighbors){
         adj = neighbors;
      };
   }
   static class Graph{
      ArrayList<Node> nodes = new ArrayList<Node>();
      static void add(Node n){
         nodes.add(n);
      }
      static boolean validRoute(Node s, Node f){
         if(g==null) throw new Exception("uninitialized graph");
         if(!nodes.contains(s)||!nodes.contains(f)) return false;
         ArrayList<Node> unvisited = new ArrayList<Node>();
         for(Node n : nodes) unvisited.add(n);
         Queue<Node> frontier = new Queue<Node>();
         unvisited.remove(s);
         frontier.add(s);
         while(!frontier.isEmpty()){
            int sz = frontier.size();
            while(sz-->0)){
               Node n = frontier.remove();
               for(Node neighbor : n.adj){
                  if(neighbor==f) return true;
                  if(unvisited.contains(neighbor)){
                     unvisited.remove(neighbor);
                     frontier.add(neighbor);
                  }
               }
            }
         }
         return false;
      }
   }
   public static void main(String args[]){
      Graph[] graphs;
      Node s, f;
      // add s and f, among other nodes, to every graph
      for(int i=0;i<graphs.length;++i){
         try{
            bool exists = graphs[i].validRoute(,s,f);
            System.out.println("Graph "+i+": Route exists between s and f? "+exists);
         } catch(Exception e){
            System.out.println("Error: validRoute(): "+e);
            System.out.println("On Graph "+i);
         }
      }
   }
}

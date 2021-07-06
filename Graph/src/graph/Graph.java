/*
================================= TABLE VALUES ===================================
           || |E| = |V| - 1  |  |E| = [(|V| - 1 )^(3/2)]    |  |E| = (|V| -1)^2)
==================================================================================
|V| = 10   ||  19            |      19                      |       19          ||
==================================================================================
|V| = 100  ||  199           |      199                     |       199         ||
==================================================================================
|V| = 1000 ||  1999          |       1999                   |       1999        ||
==================================================================================



Q3: The asymptotic running time of the depth first search is = (nodes + edges) 
example:
When the number of nodes is 10 and the number of edges is (10- 1) =  9
The finish time is 
10 + 9 = 19
V = 10 and E = V-1 = 9
O(|V|  + |E|) = 10+9= 19

This running time is equal to the expected O(|V| + |E|) 

 */
package graph;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Graph {
    public static LinkedList<Integer> adjacencyList[];

    public Graph(int vertices){
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++){
            adjacencyList[i]= new LinkedList<>();
        }
    }
    public void addEdge(int destination, int start) 
    {
            //digraph
        
        adjacencyList[destination].addFirst(start);
             
    }

    public static void main(String[] args) {
        try{
            System.out.println("Enter the number of nodes(vertices)");
            Scanner scanner = new Scanner(System.in);
            int vertices = scanner.nextInt();
            System.out.println("Enter the number of Edges");
            int edges = scanner.nextInt();  
            if(vertices<0 || edges<0){
                System.out.println("The nodes and edges are numbers greater than 0");
            }else{
            Graph graph = new Graph(vertices);
            int n = 1;
            int destination;
            int start;
            Random random = new Random();   
            while (n <= edges){
               destination = random.nextInt(vertices);
                start = random.nextInt(vertices)  ;
                graph.addEdge(destination, start);
               n++;
            }
               System.out.println("The adjacency list for a digraph with "+ vertices + " vertices and "+edges+ " edges is:");
               
            for (int i =0; i < vertices; i++){
                System.out.print(i+1 + " ======> ");
                 List<Integer> edgeList;
                edgeList = adjacencyList[i];
                if (edgeList.isEmpty())
                    System.out.print(  " is isolated");
                else {
                    for (int j =1;j<edges; j++){
                        if (j != edgeList.size())
                            System.out.print(edgeList.get(j-1) + " ======> "); 
                       else {
                            System.out.print(edgeList.get(j -1));
                            break;
                        }
                    }
                }
                System.out.println();
            }
            System.out.println("The Depth First Traversal is: ");
            
            int[] arrival = new int[vertices];
            int[] departure = new int[vertices];
            int time = 0;
            
       depthFirstSearch(vertices, arrival, departure, time);
            }
       }
        
        catch(InputMismatchException  e){
            System.out.println("nodes and edges should be numbers" );
        }
    }
    public static void depthFirstSearch(int vertices, int[] arrival, int[] departure, int time ){
        boolean isVisited[] = new boolean[vertices];
        time = 0;
                
        for(int i = 0; i<vertices; i++){
            if(!isVisited[i]){                    
              time = depthFirstSearchVisit(i, isVisited,arrival,departure, time); 
            }
        }
        
        
    }
    public static int depthFirstSearchVisit(int vertex, boolean isVisited[], int[] arrival, int[] departure , int time){
       arrival[vertex] = time++ ; //discovered at this time
        isVisited[vertex] = true; // the vertex has been visited
        
       
      
       Iterator iterator = adjacencyList[vertex].listIterator();
       while(iterator.hasNext()){
           int next = (int) iterator.next();
           if(!isVisited[next]){
               time = depthFirstSearchVisit(next, isVisited,arrival, departure, time);
           }
           
       }
       departure[vertex] = time++; // finished
       System.out.println( vertex + " Discovery time " + arrival[vertex] + " finish time "+ departure[vertex]);
       return time;
       
    }
 
}

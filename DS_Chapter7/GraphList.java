package DS_Chapter7;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GraphList {
// Adjacency List
    // Key   -> Vertex
    // Value -> List of neighboring vertices

    private Map<Integer, List<Integer>> adjList;

    // constructor
    public GraphList() {
        this.adjList = new HashMap<>();
    }

    // add vertices
    public void addVertex(int value) {
         // If the vertex does not exist, create an empty list for it
        adjList.putIfAbsent(value, new ArrayList<>());

    }

    // Add an edge between src and dest (UNDIRECTED GRAPH)
    public void addEdge(int src, int dest) {
     //   Make sure both vertices exist
        if (adjList.containsKey(src) && adjList.containsKey(dest)) {
            // Add destination to source list
            adjList.get(src).add(dest);
             // Add source to destination list
            adjList.get(dest).add(src);
        }
        else {
            System.out.println("One or both vertices are not valid!");
        }
    }

    // print the graph
    public void displayGraph (){
        for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet() )
        {System.out.print(entry.getKey() + " { ");

        for (Integer neighbour : entry.getValue()){
            System.out.print(neighbour + " ");

        }  System.out.println( "} ");
    System.out.println();
}
    }

    // Remove an edge
    public void removeEdge(int src, int dest) {
        if (adjList.containsKey(src) && adjList.containsKey(dest)) {
            adjList.get(src).remove(Integer.valueOf(dest));
            adjList.get(dest).remove(Integer.valueOf(src));
        }
        else {
            System.out.println("One or both vertices do not exist!");
        }
    }
 public static void main(String[] args) {

        GraphList graph = new GraphList();

        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);

        graph.displayGraph();

        System.out.println("Removing edge between 1 and 3");
        graph.removeEdge(1, 3);
        graph.displayGraph();
    }


}

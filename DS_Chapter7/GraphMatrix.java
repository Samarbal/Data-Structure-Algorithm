package DS_Chapter7;

// Graph Representation using Adjacency Matrix
public class GraphMatrix {
    private int vertices; // number of vertices
    private int adjMatrix[][]; // adjacency matrix
    private int values[]; // values of the nodes

    // Constructor
    public GraphMatrix(int vertices) {
        this.vertices = vertices;
        this.adjMatrix = new int[vertices][vertices];
        this.values = new int[vertices];
    }

    // Adding Edges (between source node and destination node)
    public void addEdge(int src, int des) {
        // must make sure that the src and des in the vertices range
        if (src >= 0 && des >= 0 && src < vertices && des < vertices) {
            adjMatrix[src][des] = 1;
            adjMatrix[des][src] = 1;
        } else {
            System.out.println("src or des may not valid !!!");
        }
    }

    // Removing Edges
    public void removeEdge(int src, int des) {
        // must make sure that the src and des in the vertices range
        if (src >= 0 && des >= 0 && src < vertices && des < vertices) {
            adjMatrix[src][des] = 0;
            adjMatrix[des][src] = 0;
        } else {
            System.out.println("src or des may not valid !!!");
        }
    }

    // assigning values to the nodes
    public void setNodeValues(int node, int value) {
        if (node >= 0 && node < vertices) {
            values[node] = value;
            return;
        } else {
            System.out.println("The node is node valid !! ");
        }
    }

    // printing the Graph Matrix
    public void printMatrix(int adjMatrix[][]) {

        System.out.println("--- Graph Matrix --- ");
        // print column headers
        System.out.print("   ");
        for (int val : values) {
            System.out.print(val + " ");
        }
        int count = 0;
        System.out.println();
        // print rows
        for (int[] row : adjMatrix) {
            System.out.print(values[count] + " ");
            count++;
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();

        }
    }

    public static void main(String[] args) {
        GraphMatrix graph = new GraphMatrix(5);

        // assigning values to the nodes
        graph.setNodeValues(0, 10);

        graph.setNodeValues(1, 20);
        graph.setNodeValues(2, 30);
        graph.setNodeValues(3, 40);

        graph.setNodeValues(4, 50);

        // adding edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        // printing the graph matrix
        graph.printMatrix(graph.adjMatrix);

        // removing an edge
        graph.removeEdge(1, 4);
        graph.removeEdge(1, 2);
        System.out.println("After removing the edge between node 1 and node 4 : ");
        graph.printMatrix(graph.adjMatrix);
    }
}

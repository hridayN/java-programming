package DataStructures.Graphs;

import DataStructures.Arrays.Matrix;

public class UndirectedGraphUsingAdjacencyMatrix {
    // Adjacency matrix contains the info about the connection of edges
    int[][] adjMatrix;
    public UndirectedGraphUsingAdjacencyMatrix(int nodes) {
        // Adjancency matrix is a 2-D square matrix,
        this.adjMatrix = new int[nodes][nodes];
    }

    public void addEdge(int sourceEdge, int destinationEdge) {
        // to denote the connection between two edges, we provide value 1
        this.adjMatrix[sourceEdge][destinationEdge] = 1;
        this.adjMatrix[destinationEdge][sourceEdge] = 1;
    }

    public static void main(String[] args) {
        UndirectedGraphUsingAdjacencyMatrix undirectedGraph = new UndirectedGraphUsingAdjacencyMatrix(4);
        undirectedGraph.addEdge(0,1);
        undirectedGraph.addEdge(1,2);
        undirectedGraph.addEdge(2,3);
        undirectedGraph.addEdge(3,0);
        // Matrix.displayMatrixWithFullInfo(undirectedGraph.adjMatrix);
        Matrix.displayMatrix(undirectedGraph.adjMatrix);
    }
}

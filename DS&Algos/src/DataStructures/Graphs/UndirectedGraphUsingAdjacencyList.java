package DataStructures.Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class UndirectedGraphUsingAdjacencyList {
    private LinkedList<Integer>[] adjList;
    private int vertices;
    private int edges;
    
    public UndirectedGraphUsingAdjacencyList(int nodes) {
        this.vertices = nodes;
        this.edges = 0;
        this.adjList = new LinkedList[nodes];
        // Initialize list
        for (int v = 0; v < vertices; v++) {
            adjList[v] = new LinkedList<>();
        }
    }

    public static void main(String[] args) {
        UndirectedGraphUsingAdjacencyList undirectedGraphUsingAdjacencyList = new UndirectedGraphUsingAdjacencyList(5);
        undirectedGraphUsingAdjacencyList.addEdge(0, 1);
        undirectedGraphUsingAdjacencyList.addEdge(0, 3);
        undirectedGraphUsingAdjacencyList.addEdge(2, 4);
        // undirectedGraphUsingAdjacencyList.addEdge(2, 4);
        // undirectedGraphUsingAdjacencyList.addEdge(3, 0);
        // System.out.println(undirectedGraphUsingAdjacencyList);
        //undirectedGraphUsingAdjacencyList.breadthFirstSearch(0);
        // undirectedGraphUsingAdjacencyList.depthFirstSearch_Recursive();
        undirectedGraphUsingAdjacencyList.componentsUsingDFS();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d Vertices, %d Edges \n", this.vertices, this.edges));
        for (int v = 0; v < vertices; v++) {
            sb.append(v + ": ");
            for (int w: adjList[v]) {
                sb.append(w + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void addEdge(int u, int v) {
        adjList[u].add(v);
        adjList[v].add(u);
        this.edges++;
    }

    public void breadthFirstSearch(int sourceNode) {
        boolean[] visited = new boolean[this.vertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[0] = true;
        queue.offer(sourceNode);
        while(!queue.isEmpty()) {
            int element = queue.poll();
            System.out.print(element + " ");
            for (int i: adjList[element]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }

    public void depthFirstSearch_Iterative(int sourceNode) {
        // boolean array, to keep track of visited nodes
        boolean[] visited = new boolean[this.vertices];
        Stack<Integer> stack = new Stack<>();
        stack.push(sourceNode);
        while (!stack.isEmpty()) {
            int index = stack.pop();
            if (!visited[index]) {
                visited[index] = true;
                System.out.print(index + " ");
                // visit this node's adjacent nodes
                for (int adjacentNode : adjList[index]) {
                    // if adjacentNode is not-visited, push it into stack
                    if (!visited[adjacentNode]) {
                        stack.push(adjacentNode);
                    }
                }
            }
        }
    }

    public void depthFirstSearch_Recursive() {
        // boolean array, to keep track of visited nodes
        boolean[] visited = new boolean[this.vertices];
        // for every Vertex, visit it's adjacent vertex
        for (int i = 0; i < this.vertices; i++) {
            if (!visited[i]) depthFirstSearch_Recursive_VisitAdjacentVertex(i, visited);
        }
    }

    public void depthFirstSearch_Recursive_VisitAdjacentVertex(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");
        // visit this node's adjacent nodes
        for (int adjacentNode : adjList[vertex]) {
            if (!visited[adjacentNode]) {
                depthFirstSearch_Recursive_VisitAdjacentVertex(adjacentNode, visited);
            }
        }
    }

    public void componentsUsingDFS() {
        boolean[] visited = new boolean[this.vertices];
        int[] componentId = new int[this.vertices];
        int componentCount = 0;
        for(int v = 0; v < this.vertices; v++) {
            if (!visited[v]) {
                componentsUsingDFS_Logic(v, visited, componentId, componentCount);
                componentCount++;
            }
        }
        System.out.println(String.format("Components: %d", componentCount));
    }

    public void componentsUsingDFS_Logic(int vertex, boolean[] visited, int[] componentId, int componentCount) {
        visited[vertex] = true;
        componentId[vertex] = componentCount;
        for(int w : adjList[vertex]) {
            if (!visited[w]) componentsUsingDFS_Logic(w, visited, componentId, componentCount);
        }
    }
}

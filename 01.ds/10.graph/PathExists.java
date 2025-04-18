
/**
 * Given an undirected graph, represented as a list of edges. Each edge is illustrated as a pair of integers [u, v], signifying that there's a mutual connection between node u and node v.

    You are also given starting node start, and a destination node end, return true if a path exists between the starting node and the destination node. Otherwise, return false.

    Examples
    Example 1:
    Input: n = 4, edges = [[0,1],[1,2],[2,3]], start = 0, end = 3
    Image
    Expected Output: true
    Justification: There's a path from node 0 -> 1 -> 2 -> 3.
    Example 2:
    Input: n = 4, edges = [[0,1],[2,3]], start = 0, end = 3
    Image
    Expected Output: false
    Justification: Nodes 0 and 3 are not connected, so no path exists between them.
    Example 3:
    Input: n = 5, edges = [[0,1],[3,4]], start = 0, end = 4
    Image
    Expected Output: false
    Justification: Nodes 0 and 4 are not connected in any manner.
    Constraints:

    1 <= n <= 2 * 10^5
    0 <= edges.length <= 2 * 10^5
    edges[i].length == 2
    0 <= ui, vi <= n - 1
    ui != vi
    0 <= source, destination <= n - 1
    There are no duplicate edges.
    There are no self edges.
 */

import java.util.*;

public class PathExists {
    private boolean[] visited;

    public boolean validPath(int n, int[][] edges, int start, int end) {
        Graph myGraph = new Graph(n);
        visited = new boolean[n];

        // build adjacency list
        for (int i = 0; i < edges.length; i++) {
            myGraph.addEdge(edges[i][0], edges[i][1]);
        }

        // swap start and end if needed
        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
        }

        return myGraph.checkPath(start, end, visited);
    }

    public static void main(String[] args) {
        PathExists pathExists = new PathExists();
        int n = 4;
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 3 } };
        int start = 0;
        int end = 3;
        System.out.println(pathExists.validPath(n, edges, start, end)); // Output: true
    }

    class Graph {
        private int vertices;
        private LinkedList<Integer>[] adjacencyList;

        public Graph(int vertices) {
            this.vertices = vertices;
            adjacencyList = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjacencyList[i] = new LinkedList<>();
            }
        }

        public boolean checkPath(int start, int end, boolean[] visited) {
            return checkPathRecursive(start, end, start, visited);
        }

        private boolean checkPathRecursive(int start, int end, int currentVertex, boolean[] visited) {
            visited[currentVertex] = true;

            for (int neighbor : adjacencyList[currentVertex]) {
                if (neighbor == end) {
                    return true;
                }

                if (!visited[neighbor]) {
                    return checkPathRecursive(start, end, neighbor, visited);
                }
            }

            return false;
        }

        public void addEdge(int source, int destination) {
            adjacencyList[source].add(destination);
            adjacencyList[destination].add(source); // For an undirected graph
        }

        // Method to perform DFS using recursion
        public void DFS(int startVertex) {
            boolean[] visited = new boolean[vertices]; // Track visited nodes
            System.out.print("DFS Traversal: ");
            DFSRecursive(startVertex, visited); // Start DFS from the given vertex
        }

        private void DFSRecursive(int currentVertex, boolean[] visited) {
            visited[currentVertex] = true; // Mark the current node as visited
            System.out.print(currentVertex + " "); // Process the current node

            // Recur for all unvisited neighbors
            for (int neighbor : adjacencyList[currentVertex]) {
                if (!visited[neighbor]) {
                    DFSRecursive(neighbor, visited);
                }
            }
        }
    }

}

// Time Complexity: O(V + E), where V is the number of vertices and E is the
// number of edges in the graph. This is because we may need to visit all
// vertices and edges in the worst case.
// Space Complexity: O(V), where V is the number of vertices. This is due to the
// space used by the adjacency list and the visited array.


/**
 * Given a directed acyclic graph with n nodes labeled from 0 to n-1, determine the smallest number of initial nodes such that you can access all the nodes by traversing edges. Return these nodes.

    Examples
    Example 1:
    Input:
    n = 6
    edges = [[0,1],[0,2],[2,5],[3,4],[4,2]]
    Expected Output: [0,3]
    Image
    Justification: Starting from nodes 0 and 3, you can reach all other nodes in the graph. Starting from node 0, you can reach nodes 1, 2, and 5. Starting from node 3, you can reach nodes 4 and 2 (and by extension 5).
    Example 2:
    Input:
    n = 3
    edges = [[0,1],[2,1]]
    Expected Output: [0,2]
    Image
    Justification: Nodes 0 and 2 are the only nodes that don't have incoming edges. Hence, you need to start from these nodes to reach node 1.
    Example 3:
    Input:
    n = 5
    edges = [[0,1],[2,1],[3,4]]
    Expected Output: [0,2,3]
    Image
    Justification: Node 1 can be reached from both nodes 0 and 2, but to cover all nodes, you also need to start from node 3.
    Constraints:

    2 <= n <= 10^5
    1 <= edges.length <= min(10^5, n * (n - 1) / 2)
    edges[i].length == 2
    0 <= fromi, toi < n
    All pairs (fromi, toi) are distinct.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SmallestSetOfVertices {

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Graph myGraph = new Graph(n);

        for (int i = 0; i < edges.size(); i++) {
            myGraph.addEdge(edges.get(i).get(0), edges.get(i).get(1));
        }

        return myGraph.findSmallestSubset();
    }

    private class Graph {
        private int vertices;
        private boolean[] visited;
        private LinkedList<Integer>[] adjacencyList;
        private List<Integer> result;

        public Graph(int vertices) {
            this.vertices = vertices;
            this.visited = new boolean[vertices];
            this.adjacencyList = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjacencyList[i] = new LinkedList<>();
            }
            this.result = new ArrayList<>();
        }

        public void addEdge(int source, int destination) {
            adjacencyList[source].add(destination);
            // adjacencyList[destination].add(source); // For an undirected graph
        }

        // Method to perform DFS using recursion
        public List<Integer> findSmallestSubset() {
            for (int i = 0; i < vertices; i++) {
                findSmallestSubsetRecursive(i);
            }
            for (int i = 0; i < vertices; i++) {
                if (!visited[i]) {
                    result.add(i);
                }
            }

            return result;
        }

        private void findSmallestSubsetRecursive(int currentVertex) {
            for (int neighbor : adjacencyList[currentVertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true; // Mark the current node as visited
                    findSmallestSubsetRecursive(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        SmallestSetOfVertices solution = new SmallestSetOfVertices();
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(List.of(0, 1));
        edges.add(List.of(0, 2));
        edges.add(List.of(2, 5));
        edges.add(List.of(3, 4));
        edges.add(List.of(4, 2));

        List<Integer> result = solution.findSmallestSetOfVertices(6, edges);
        System.out.println(result); // Output: [0, 3]
    }
}

// Time Complexity: O(V + E), where V is the number of vertices and E is the
// number of edges.
// Space Complexity: O(V + E) for the adjacency list and visited array.
// The space complexity is O(V) for the visited array and O(E) for the adjacency
// list.

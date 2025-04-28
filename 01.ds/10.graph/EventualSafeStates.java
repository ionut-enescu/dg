
/**
 * You are given a directed graph with n nodes, labeled from 0 to n-1. This graph is described by a 2D integer array graph, where graph[i] is an array of nodes adjacent to node i, indicating there is a directed edge from node i to each of the nodes in graph[i].

    A node is called a terminal node if it has no outgoing edges. A node is considered safe if every path starting from that node leads to a terminal node (or another safe node).

    Return an array of all safe nodes in ascending order.

    Examples
    Example 1:

    Input: graph = [[1,2],[2,3],[2],[],[5],[6],[]]
    Image
    Expected Output: [3,4,5,6]
    Explanation:
    Node 3 is a terminal node.
    Node 4 leads to node 5, which is a safe node.
    Node 5 leads to node 6, which is a terminal node.
    Node 6 is a terminal node.
    Example 2:

    Input: graph = [[1,2],[2,3],[5],[0],[],[],[4]]
    Image
    Expected Output: [2,4,5,6]
    Explanation:
    Node 2 leads to node 5, which is a terminal node.
    Node 4 is a terminal node.
    Node 5 is a terminal node.
    Node 6 leads to node 4, which is a terminal node.
    Example 3:

    Input: graph = [[1,2,3],[2,3],[3],[],[0,1,2]]
    Image
    Expected Output: [0,1,2,3,4]
    Explanation:
    Node 3 is a terminal node.
    Node 2 leads to node 3, which is a terminal node.
    Node 1 leads to node 2, which is a safe node, and node 3, which is a terminal node.
    Similarly, all node leads to either a terminal or a safe node.
    Constraints:

    n == graph.length
    1 <= n <= 10^4
    0 <= graph[i].length <= n
    0 <= graph[i][j] <= n - 1
    graph[i] is sorted in a strictly increasing order.
    The graph may contain self-loops.
    The number of edges in the graph will be in the range [1, 4 * 10^4].
 */
import java.util.*;

public class EventualSafeStates {
    private Graph myGraph;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        myGraph = new Graph(graph.length);

        // build graph
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                myGraph.addEdge(i, graph[i][j]);
            }
        }

        for (int i = 0; i < graph.length; i++) {
            if (myGraph.findSafeNodes(i)) {
                myGraph.safeNodes.add(i);
            }
        }

        return myGraph.safeNodes;
    }

    class Graph {
        private int vertices;
        private LinkedList<Integer>[] adjacencyList;
        private List<Integer> safeNodes;

        public Graph(int vertices) {
            this.vertices = vertices;
            this.safeNodes = new ArrayList<>();
            this.adjacencyList = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                this.adjacencyList[i] = new LinkedList<>();
            }
        }

        public void addEdge(int source, int destination) {
            adjacencyList[source].add(destination);
        }

        public boolean findSafeNodes(int currentVertex) {
            boolean[] visited = new boolean[vertices];
            return findSafeNodesRecursive(currentVertex, visited, 0);
        }

        private boolean findSafeNodesRecursive(int currentVertex, boolean[] visited, int edgesToTerminalNode) {
            visited[currentVertex] = true;
            boolean isSafe = true;

            if (adjacencyList[currentVertex].size() == 0) {
                isSafe = true;
            } else {
                for (int neighbor : adjacencyList[currentVertex]) {
                    if (!visited[neighbor]) {
                        if (++edgesToTerminalNode > 2) {
                            return false;
                        } else {
                            isSafe = findSafeNodesRecursive(neighbor, visited, edgesToTerminalNode);
                            if (!isSafe) {
                                return false;
                            }
                        }
                    } else if (currentVertex == neighbor) {
                        isSafe = false;
                    }
                }
            }

            return isSafe;
        }
    }

    public static void main(String[] args) {
        EventualSafeStates eventualSafeStates = new EventualSafeStates();
        int[][] graph = { { 1, 2 }, { 2, 3 }, { 5 }, { 0 }, { 5 }, {}, {} };
        List<Integer> safeNodes = eventualSafeStates.eventualSafeNodes(graph);
        System.out.println("Safe nodes: " + safeNodes); // Output: [2, 4, 5, 6]
    }
}

// Time Complexity: O(V + E), where V is the number of vertices and E is the
// number of edges in the graph. This is because we traverse each vertex and
// edge once during the DFS traversal.
// Space Complexity: O(V), where V is the number of vertices in the graph. This
// is due to the space used by the adjacency list and the visited array.

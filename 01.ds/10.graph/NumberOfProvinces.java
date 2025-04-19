import java.util.LinkedList;

/**
 * There are n cities. Some of them are connected in a network. If City A is
 * directly connected to City B, and City B is directly connected to City C,
 * city A is indirectly connected to City C.
 * 
 * If a group of cities are connected directly or indirectly, they form a
 * province.
 * 
 * Given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city
 * and the jth city are directly connected, and isConnected[i][j] = 0 otherwise,
 * determine the total number of provinces.
 * 
 * Examples
 * Example 1:
 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * Image
 * Expected Output: 2
 * 
 * Justification: Here, city 1 and 2 form a single provenance, and city 3 is one
 * provinces itself.
 * 
 * Example 2:
 * 
 * Input: isConnected = [1,0,0],[0,1,0],[0,0,1]]
 * Image
 * Expected Output: 3
 * 
 * Justification: In this scenario, no cities are connected to each other, so
 * each city forms its own province.
 * 
 * Example 3:
 * 
 * Input: isConnected = [[1,0,0,1],[0,1,1,0],[0,1,1,0],[1,0,0,1]]
 * Image
 * Expected Output: 2
 * Justification: Cities 1 and 4 form a province, and cities 2 and 3 form
 * another province, resulting in a total of 2 provinces.
 * Constraints:
 * 
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] is 1 or 0.
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 */

public class NumberOfProvinces {
    private Graph myGraph;

    // Function to find the province count.
    public int findProvinces(int[][] isConnected) {
        myGraph = new Graph(isConnected.length);

        // build graph
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i; j < isConnected.length; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    myGraph.addEdge(i, j);
                }
            }
        }

        return myGraph.countProvinces(0);
    }

    public static void main(String[] args) {
        NumberOfProvinces numberOfProvinces = new NumberOfProvinces();
        int[][] isConnected = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
        System.out.println(numberOfProvinces.findProvinces(isConnected)); // Output: 2
    }

    class Graph {
        private int vertices;
        private LinkedList<Integer>[] adjacencyList;
        private int provinces;
        private boolean visiting;

        public Graph(int vertices) {
            this.vertices = vertices;
            this.provinces = 0;
            adjacencyList = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjacencyList[i] = new LinkedList<>();
            }
            visiting = false;
        }

        public void addEdge(int source, int destination) {
            adjacencyList[source].add(destination);
            adjacencyList[destination].add(source); // For an undirected graph
        }

        public int countProvinces(int startVertex) {
            boolean[] visited = new boolean[vertices]; // Track visited nodes
            for (int i = 0; i < adjacencyList.length; i++) {
                if (adjacencyList[i].size() == 0) {
                    provinces++;
                    visited[i] = true;
                } else {
                    countProvincesRecursive(i, visited);
                    if (visiting) {
                        provinces++;
                        visiting = false;
                    }
                }
            }

            return provinces;
        }

        private void countProvincesRecursive(int currentVertex, boolean[] visited) {
            if (visited[currentVertex]) {
                return;
            }

            visited[currentVertex] = true; // Mark the current node as visited
            System.out.println("currentVertex: " + currentVertex); // Process the current node

            visiting = true;
            // Recur for all unvisited neighbors
            for (int neighbor : adjacencyList[currentVertex]) {
                if (!visited[neighbor]) {
                    countProvincesRecursive(neighbor, visited);
                }
            }
        }
    }
}

// Time Complexity: O(V + E), where V is the number of vertices and E is the
// number of edges in the graph. This is because we visit each vertex and edge
// once.
// Space Complexity: O(V), where V is the number of vertices. This is for the
// visited array and the adjacency list.

/* Leetcode Problem Link: https://leetcode.com/problems/is-graph-bipartite/

There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], there is an undirected edge between node u and node v. The graph has the following properties:

There are no self-edges (graph[u] does not contain u).
There are no parallel edges (graph[u] does not contain duplicate values).
If v is in graph[u], then u is in graph[v] (the graph is undirected).
The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.

Return true if and only if it is bipartite.

*/


import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public static boolean isBipartite(int[][] graph) {
        // Initialize an array to store colors for each node, -1 denotes no color
        int[] col = new int[graph.length];
        for (int i = 0; i < col.length; i++) {
            col[i] = -1; // No color
        }

        Queue<Integer> qe = new LinkedList<>(); 

        for (int i = 0; i < graph.length; i++) {
            if (col[i] == -1) { // If the node is not colored, perform BFS
                qe.add(i);
                col[i] = 1; // Color the node with 1
                while (!qe.isEmpty()) {
                    int curr = qe.poll(); // Get the current node from the queue
                    int[] arr = graph[curr]; // Get the neighbors of the current node
                    for (int j = 0; j < arr.length; j++) {
                        // If the neighbor is not colored, assign a different color and add it to the queue
                        if (col[graph[curr][j]] == -1) {
                            col[graph[curr][j]] = 1 - col[curr]; // Assign a different color
                            qe.add(graph[curr][j]); // Add the neighbor to the queue
                        }
                        // If the neighbor has the same color as the current node, the graph is not bipartite
                        else if (col[graph[curr][j]] == col[curr]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true; // If no conflict arises, the graph is bipartite
    }

    public static void main(String args[]) {

        int graph[][] = {{1,3}, {0, 2}, {1, 3}, {0, 2}};
        
        System.out.println(isBipartite(graph));
    }
}

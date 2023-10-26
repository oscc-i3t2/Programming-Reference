/* Leetcode Problem Link: https://leetcode.com/problems/number-of-provinces/

There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.
*/



import java.util.LinkedList;
import java.util.Queue;

class Solution {
   
    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        boolean traversed[] = new boolean[len + 1]; // Array to keep track of visited nodes
        int count = 0; // Initialize the count of provinces

        // Iterate through the nodes
        for (int i = 1; i <= len; i++) {
            if (!traversed[i]) { // If the node is not traversed
                ++count; // Increment the count for a new province
                BFS(traversed, isConnected, i); // Call BFS to traverse the connected nodes
            }
        }
        return count; // Return the total count of provinces
    }

    public void BFS(boolean traversed[], int isConnected[][], int num) {
        Queue<Integer> que = new LinkedList<>(); // Queue for BFS traversal
        que.add(num); // Add the current node to the queue

        // Continue traversing while the queue is not empty
        while (!que.isEmpty()) {
            int current = que.poll(); // Retrieve and remove the head of the queue
            traversed[current] = true; // Mark the current node as visited

            // Iterate through the connections of the current node
            for (int i = 0; i < isConnected[current - 1].length; i++) {
                // If the node is connected and not traversed yet
                if (isConnected[current - 1][i] == 1 && !traversed[i + 1]) {
                    que.add(i + 1); // Add the connected node to the queue for further traversal
                }
            }
        }
    }
     public static void main(String[] args) {
        // Sample input
        int[][] isConnected = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };

        Solution solution = new Solution();
        int provinces = solution.findCircleNum(isConnected);
        System.out.println("Number of provinces: " + provinces);
    }
}

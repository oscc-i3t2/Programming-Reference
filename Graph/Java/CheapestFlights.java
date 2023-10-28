/* Leetcode Problem Link: https://leetcode.com/problems/cheapest-flights-within-k-stops/

There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

*/





import java.util.*;

class Tuple {
    int node;
    int dist;
    int stop;

    Tuple(int node, int dist, int stop) {
        this.node = node;
        this.dist = dist;
        this.stop = stop;
    }
}

class Pair {
    int node;
    int wt;

    Pair(int node, int wt) {
        this.node = node;
        this.wt = wt;
    }
}

class Solution {
    // Method to find the cheapest price using Dijkstra's algorithm with a maximum of k stops
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Array to store the minimum distances
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // List to represent the adjacency list
        List<List<Pair>> adj = new ArrayList<List<Pair>>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Pair>());
        }

        // Building the adjacency list from the flights array
        for (int i = 0; i < flights.length; i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        // Using a queue for BFS traversal
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(src, 0, 0));

        // BFS traversal with constraint on the number of stops
        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();

            for (Pair p : adj.get(tuple.node)) {
                if ((tuple.dist + p.wt < dist[p.node]) && tuple.stop <= k) {
                    dist[p.node] = tuple.dist + p.wt;
                    queue.add(new Tuple(p.node, dist[p.node], tuple.stop + 1));
                }
            }
        }

        // Returning the minimum distance to the destination, or -1 if no path exists
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }

    // Main method for testing the findCheapestPrice method
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Example inputs
        int n = 3;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int src = 0;
        int dst = 2;
        int k = 1;
        // Calling the findCheapestPrice method and displaying the result
        int result = solution.findCheapestPrice(n, flights, src, dst, k);
        System.out.println("The cheapest price is: " + result);
    }
}

package tugasStrukData;

import java.util.*;

public class bestFirstSearch {
    private int V;
    private LinkedList<Integer>[] adj;
    private int[] heuristic;

    public bestFirstSearch(int v) { // constructor
        V = v;
        adj = new LinkedList[v];
        heuristic = new int[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public void setHeuristic(int v, int h) {
        heuristic[v] = h;
    }

    public void bestFirstSearch(int s) {
        boolean visited[] = new boolean[V];
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> heuristic[a] - heuristic[b]);

        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            s = queue.poll();
            System.out.print(s + " ");

            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    queue.add(n);
                    visited[n] = true;
                }
            }
        }
    }

    public static void main(String args[]) {
        bestFirstSearch g = new bestFirstSearch(6); // create a graph with 6 vertices

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.setHeuristic(0, 5);
        g.setHeuristic(1, 3);
        g.setHeuristic(2, 2);
        g.setHeuristic(3, 1);
        g.setHeuristic(4, 4);
        g.setHeuristic(5, 6);

        System.out.println("Berikut adalah Best First Search Traversal " +
                "(mulai dari simpul 2):");
        g.bestFirstSearch(2);
    }
}
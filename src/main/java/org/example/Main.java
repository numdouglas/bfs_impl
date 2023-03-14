package org.example;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    static ArrayList<Integer> visited = new ArrayList<>();
    static LinkedList<Graph> queue = new LinkedList<>();

    static void bfs(Graph root) {
        if (root != null && !visited.contains(root.node_id)) {
            /*put root in visited list*/
            visited.add(root.node_id);

            if (root.children != null)
                for (Graph child : root.children) {
                    /*put children of root in queue*/
                    //System.out.printf("checking if %s contains %d\n", visited, child.node_id);
                    if (!visited.contains(child.node_id)) {
                        queue.add(child);
                    }
                }
            //System.out.printf("transferring from queue %s to visited %s\n", queue, visited);
            bfs(queue.pollFirst());
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(1, new Graph[]{new Graph(4), new Graph(2, new Graph[]{new Graph(3), new Graph(4)})});
        Graph pz_graph = new Graph(0, new Graph[]{new Graph(3), new Graph(2, new Graph[]{new Graph(4), new Graph(1), new Graph(1)})});

        bfs(pz_graph);

        System.out.println(visited);
    }
}
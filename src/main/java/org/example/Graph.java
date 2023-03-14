package org.example;

/**Tree with cycles**/
public class Graph {
    int node_id;
    Graph[] children;

    public Graph(int node_id){
        this.node_id=node_id;
    }

    public Graph(int node_id, Graph[] children){
        this.node_id=node_id;
        this.children=children;
    }

    @Override
    public String toString() {
        return Integer.toString(node_id);
    }
}

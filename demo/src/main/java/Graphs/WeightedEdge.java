package Graphs;

public class WeightedEdge {
    int source;
    int destination;

    int weight;

    public WeightedEdge(int src, int dest, int weight){
        this.source = src;
        this.destination = dest;
        this.weight = weight;
    }
}

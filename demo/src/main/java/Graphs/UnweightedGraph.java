package Graphs;

import java.util.ArrayList;

public class UnweightedGraph {

    /*
    * For Graphs we will save the value of each neighbours of an edge
    * ex: Edge 1 connects to edge 2 and edge 3
    * */
    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0; i< graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,2));


    }

    public static void createWeightedGraph(ArrayList<WeightedEdge>[] graph){
        for(int i=0; i< graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new WeightedEdge(0,2,2));

        graph[1].add(new WeightedEdge(1,2,10));
        graph[1].add(new WeightedEdge(1,3,0));

        graph[2].add(new WeightedEdge(2,0,2));
        graph[2].add(new WeightedEdge(2,1,10));
        graph[2].add(new WeightedEdge(2,3,-1));

        graph[3].add(new WeightedEdge(3,1,0));
        graph[3].add(new WeightedEdge(3,2,-1));


    }

    public static void main(String[] args) {
//        ArrayList<Edge>[] graph = new ArrayList[5];
        ArrayList<WeightedEdge>[] graph2 = new ArrayList[5];

//        createGraph(graph);
        createWeightedGraph(graph2);
        //print 2's neighbours
//        for(int i=0; i<graph[2].size(); i++){
//            Edge edge = graph[2].get(i);
//            System.out.println(edge.destination);
//        }

        for(int i=0; i<graph2[2].size(); i++){
            WeightedEdge edge = graph2[2].get(i);
            System.out.println(edge.destination + " "+ edge.weight);
        }
    }
}

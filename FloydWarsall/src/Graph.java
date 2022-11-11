import javafx.util.Pair;

import java.util.ArrayList;
import java.util.PriorityQueue;
public class Graph<T> {
    private ArrayList<Node<T>> graph;

    public Graph() {
        this.graph= new ArrayList<>();
    }

    public void addVertex(int key, T value){
        Node<T> a= new Node<>(value,key);
        graph.add(a);
    }

    public void addEdge(int key, int adj, int w){

        if(searchNode(key)==null || searchNode(adj)==null){
            return;
        }

        Node<T> a= searchNode(adj);
        int value=-1;
        for(int i=0; i< graph.size(); i++){
            if(graph.get(i).getKey()==key){
                value=i;
                break;
            }
        }

        graph.get(value).addAdj(a,w);

    }

    public Node<T> searchNode(int a){
        for(int i=0; i<graph.size(); i++){
            if(graph.get(i).getKey()==a){
                return graph.get(i);
            }
        }
        return null;
    }

    public int[][] floydW(){

        int[][] dist= new int[graph.size()][graph.size()];

        for(int i=0; i<dist.length;i++){
            for (int j=0; j<dist[0].length;j++){
                dist[i][j]=100000;
            }
        }

        for(Node<T>v: graph){
            dist[v.getKey()][v.getKey()]=0;
        }

        for(Node<T>v:graph){
            for(Pair<Node<T>,Integer>u: v.getNodes()){
                dist[v.getKey()][u.getKey().getKey()]=u.getValue();
            }
        }

        for(int k=0; k<graph.size(); k++){
            for(int i=0; i< graph.size(); i++){
                for(int j=0; j< graph.size(); j++){
                    if(dist[i][j]>dist[i][k]+dist[k][j]){
                        dist[i][j]=dist[i][k]+dist[k][j];
                    }
                }
            }
        }



        for(int i=0; i<dist.length;i++){
            for (int j=0; j<dist[0].length;j++){
                System.out.print(dist[i][j]+" ");
            }
            System.out.println();
        }


        return dist;
    }

}

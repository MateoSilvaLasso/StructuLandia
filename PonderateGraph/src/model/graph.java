package model;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class graph<T> {
    private ArrayList<Node<T>> graph;

    public graph() {
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

    public ArrayList<Integer> dijkstra(int source){
        ArrayList<Integer> dist= new ArrayList<>(graph.size()-1);
        ArrayList<Integer> prev= new ArrayList<>(graph.size()-1);
        for(int i=0; i<graph.size(); i++){
            dist.add(0);}

        dist.remove(source);
        dist.add(source,0);

        PriorityQueue<Integer>q=new PriorityQueue<>();
        Node<T> s= searchNode(source);
        for(Node<T> v:graph){
            if(v!=s){
                dist.remove(v.getKey());
                dist.add(v.getKey(),((Integer)1).MAX_VALUE);
            }
            prev.add(v.getKey(),null);
            q.add(dist.get(v.getKey()));



        }


        while(!q.isEmpty()){
            int u= q.peek(); q.poll();
            int value=-1;
            for(int i=0; i< dist.size(); i++){
                if(dist.get(i)==u){
                    value=i;
                    break;
                }
            }
            //System.out.println(dist);
            for(Pair<Node<T>,Integer>v: graph.get(value).getNodes()){
                int alt= dist.get(value)+v.getValue();
                if(alt<dist.get(v.getKey().getKey())){
                    q.remove(dist.get(v.getKey().getKey()));
                    dist.remove(v.getKey().getKey());
                    dist.add(v.getKey().getKey(),alt);
                    prev.remove(v.getKey().getKey());
                    prev.add(v.getKey().getKey(),u);
                    q.add(dist.get(v.getKey().getKey()));
                }
            }
        }

        return dist;

    }

    public ArrayList<Integer> dijkstraS(int source){
        ArrayList<Integer> dist= new ArrayList<>(graph.size()-1);
        ArrayList<Integer> prev= new ArrayList<>(graph.size()-1);
        for(int i=0; i<graph.size(); i++){
            dist.add(0);}

        dist.remove(source);
        dist.add(source,0);

        PriorityQueue<Integer>q=new PriorityQueue<>();
        Node<T> s= searchNode(source);
        for(Node<T> v:graph){
            if(v!=s){
                dist.remove(v.getKey());
                dist.add(v.getKey(),((Integer)1).MAX_VALUE);
            }
            prev.add(v.getKey(),null);
            q.add(dist.get(v.getKey()));



        }


        while(!q.isEmpty()){
            int u= q.peek(); q.poll();
            int value=-1;
            for(int i=0; i< dist.size(); i++){
                if(dist.get(i)==u){
                    value=i;
                    break;
                }
            }
            //System.out.println(dist);
            for(Pair<Node<T>,Integer>v: graph.get(value).getNodes()){
                int alt= dist.get(value)+v.getValue();
                if(alt<dist.get(v.getKey().getKey())){
                    q.remove(dist.get(v.getKey().getKey()));
                    dist.remove(v.getKey().getKey());
                    dist.add(v.getKey().getKey(),alt);
                    prev.remove(v.getKey().getKey());
                    prev.add(v.getKey().getKey(),u);
                    q.add(dist.get(v.getKey().getKey()));
                }
            }
        }

        return prev;

    }

}

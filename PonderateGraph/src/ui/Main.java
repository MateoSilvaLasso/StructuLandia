package ui;

import model.graph;

import java.util.ArrayList;
//import java.util.Comparator;


public class Main {
    public static void main(String[] args) {
        graph<String> arr= new graph<>();

        arr.addVertex(0,"hola");
        arr.addVertex(1,"mundo");
        arr.addVertex(2,"de");
        arr.addVertex(3,"java");
        arr.addVertex(4,"but");
        arr.addVertex(5,"cpp");
        //arr.addVertex(6,"c#");

        arr.addEdge(0,1,4);
        arr.addEdge(0,2,2);
        arr.addEdge(1,0,4);
        arr.addEdge(1,2,1);
        arr.addEdge(1,3,5);
        arr.addEdge(2,0,2);
        arr.addEdge(2,1,1);
        arr.addEdge(2,3,8);
        arr.addEdge(2,4,10);
        arr.addEdge(3,1,5);
        arr.addEdge(3,2,8);
        arr.addEdge(3,4,2);
        arr.addEdge(3,5,6);
        arr.addEdge(4,2,10);
        arr.addEdge(4,3,2);
        arr.addEdge(4,5,3);
        arr.addEdge(5,3,6);
        arr.addEdge(5,4,3);

        ArrayList<Integer> a= arr.dijkstra(0);
        System.out.println(a);

        graph<Integer> gs= new graph<>();

        gs.addVertex(0,0);
        gs.addVertex(1,1);
        gs.addVertex(2,2);
        gs.addVertex(3,3);
        gs.addVertex(4,4);
        gs.addVertex(5,5);

        gs.addEdge(0,1,2);
        gs.addEdge(0,2,3);
        gs.addEdge(1,0,2);
        gs.addEdge(1,4,2);
        gs.addEdge(1,3,5);
        gs.addEdge(2,0,3);
        gs.addEdge(2,4,5);
        gs.addEdge(3,1,5);
        gs.addEdge(3,4,1);
        gs.addEdge(3,5,2);
        gs.addEdge(4,1,2);
        gs.addEdge(4,2,5);
        gs.addEdge(4,3,1);
        gs.addEdge(4,5,4);
        gs.addEdge(5,3,2);
        gs.addEdge(5,4,4);

        ArrayList<Integer> b= gs.dijkstra(0);
        System.out.println(b);

        graph<Character> ll= new graph<>();
        ll.addVertex(0,'a');
        ll.addVertex(1,'b');
        ll.addVertex(2,'c');

        ll.addEdge(0,1,7);
        ll.addEdge(0,2,2);
        ll.addEdge(1,0,7);
        ll.addEdge(1,2,3);
        ll.addEdge(2,0,2);
        ll.addEdge(2,1,3);

        ArrayList<Integer> c= ll.dijkstra(1);
        System.out.println(c);
        ArrayList<Integer> d= ll.dijkstraS(1);
        System.out.println(d);







    }
}
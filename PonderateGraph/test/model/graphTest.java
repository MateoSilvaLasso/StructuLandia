package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class graphTest {

    private graph<String> arr;
    private graph<Character> ll;

    public void setUp1() {
        arr= new graph<>();
        arr.addVertex(0,"hola");
        arr.addVertex(1,"mundo");
        arr.addVertex(2,"de");
        arr.addVertex(3,"java");
        arr.addVertex(4,"but");
        arr.addVertex(5,"cpp");
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
    }

    public void setUp2(){
        ll= new graph<>();
        ll.addVertex(0,'a');
        ll.addVertex(1,'b');
        ll.addVertex(2,'c');

        ll.addEdge(0,1,7);
        ll.addEdge(0,2,2);
        ll.addEdge(1,0,7);
        ll.addEdge(1,2,3);
        ll.addEdge(2,0,2);
        ll.addEdge(2,1,3);
    }

    @Test
    public void firstDijkstraTest(){
        setUp1();
        assertEquals(arr.dijkstra(0).get(1),3); //el valor minimo de ir de 0 a 1 deberia ser tres
        assertEquals(arr.dijkstra(0).get(0),0); //el valor minimo de ir de 0 a 0 deberia ser cero
        assertEquals(arr.dijkstra(1).get(0),3); //el valor minimo de ir de 1 a 0 deberia ser tres
                                                            //ya que ir de 0 a 1 es tres

    }

    @Test
    public void secondDijkstraTest(){
        //En este test pasaremos por los nodos optimos para llegar a un punto y se vea mejor que esta funcionando
        setUp2();
        //caminos mas cortos desde 0 a todos los nodos
        assertEquals(ll.dijkstra(0).get(0), 0);
        assertEquals(ll.dijkstra(0).get(1), 5);
        assertEquals(ll.dijkstra(0).get(2),2);
        // caminos mas cortos desde 1 a todos los nodos
        assertEquals(ll.dijkstra(1).get(0),5);
        assertEquals(ll.dijkstra(1).get(1),0);
        assertEquals(ll.dijkstra(1).get(2),3);
        //caminos mar cortos desde 2 a todos los nodos
        assertEquals(ll.dijkstra(2).get(0),2);
        assertEquals(ll.dijkstra(2).get(1),3);
        assertEquals(ll.dijkstra(2).get(2),0);


    }


}
public class Main {
    public static void main(String[] args) {
        Graph<Character> arr= new Graph<>();

        arr.addVertex(0,'a');
        arr.addVertex(1,'b');
        arr.addVertex(2,'c');
        arr.addVertex(3,'d');

        arr.addEdge(0,2,-2);
        arr.addEdge(1,0,4);
        arr.addEdge(1,2,3);
        arr.addEdge(2,3,2);
        arr.addEdge(3,1,-1);

         arr.floydW();




    }
}
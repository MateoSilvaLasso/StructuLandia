package model;

import java.util.ArrayList;

import javafx.util.Pair;
public class Node<T> {
    private T value;
    private int key;

    private int forward;

    private int color; //0= white , 1= gray , 2= black

    private int d;

    private Node<T> pi;

    private ArrayList<Pair<Node<T>,Integer>> nodes;
    private ArrayList<Node<T>> complementaryNode;

    public Node(){

    }

    public Node(T value, int key) {
        this.value = value;
        this.key = key;
        nodes= new ArrayList<>();
        complementaryNode=new ArrayList<>();
    }

    public T getValue() {
        return value;
    }

    public void addAdj(Node<T> arr, int w){
        nodes.add(new Pair<>(arr,w));
    }

    public void addComplementaryAdj(Node<T>arr){complementaryNode.add(arr);}

    public void setValue(T value) {
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public ArrayList<Pair<Node<T>,Integer>> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<Pair<Node<T>,Integer>> nodes) {
        this.nodes = nodes;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public Node<T> getPi() {
        return pi;
    }

    public void setPi(Node<T> pi) {
        this.pi = pi;
    }

    public int getForward() {
        return forward;
    }

    public void setForward(int forward) {
        this.forward = forward;
    }

    public ArrayList<Node<T>> getComplementaryNode() {
        return complementaryNode;
    }

    public void setComplementaryNode(ArrayList<Node<T>> complementaryNode) {
        this.complementaryNode = complementaryNode;
    }
}



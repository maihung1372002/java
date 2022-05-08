package hw8_20001928_maiviethung.ex1;

import java.util.Iterator;

import hw8_20001928_maiviethung.GraphInterface;
import hw8_20001928_maiviethung.Vertex;

public class UnDirectUnWeightGraph<V,E> implements GraphInterface<V,E> {

    @Override
    public int numVertices() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Iterator<V> vertices() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int numEgde() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Iterator<E> egdes() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public E getEgde(Vertex<V> u, Vertex<V> v) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Vertex<V>[] endVertices(E e) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Vertex<V> opposite(Vertex<V> v, E e) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int outDegree(Vertex<V> v) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int inDegree(Vertex<V> v) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Iterator<E> outgoingEgdes(Vertex<V> v) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterator<E> outcomingEgdes(Vertex<V> v) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Vertex<V> insertVertex(V element) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public E insertEgde(Vertex<V> u, Vertex<V> v, V element) {
        // TODO Auto-generated method stub
        return null;
    }
    
}

package hw8_20001928_maiviethung;

import java.util.Iterator;

public interface GraphInterface<V,E> {
    int numVertices() ;
    Iterator< V > vertices();

    int numEgde();
    Iterator< E > egdes();

    E getEgde(Vertex<V> u, Vertex<V> v);

    Vertex<V>[] endVertices(E e);

    Vertex<V> opposite(Vertex<V> v, E e);

    int outDegree(Vertex<V> v);

    int inDegree(Vertex<V> v);

    Iterator<E> outgoingEgdes(Vertex<V> v);
    
    Iterator<E> outcomingEgdes(Vertex<V> v);

    Vertex<V> insertVertex(V element);

    E insertEgde(Vertex<V> u, Vertex<V> v, V element);

    
}

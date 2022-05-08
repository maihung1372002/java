package hw8_20001928_maiviethung;

public class Egde<E> {
    E start;
    E end;  
    int weight;
    public Egde(E start, E end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }  
    public Egde(E start, E end) {
        this.start = start;
        this.end = end;
        // this.weight = null;/
    }

    public E getStart() {
        return this.start;
    }

    public E getEnd() {
        return this.end;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setStart(E start) {
        this.start = start;
    }

    public void setEnd(E end) {
        this.end = end;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}

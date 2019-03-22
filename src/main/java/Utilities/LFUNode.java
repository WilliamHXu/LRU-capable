package Utilities;


import java.util.LinkedList;

public class LFUNode<T> {
    private LFUNode<T> previous;
    private Integer frequency;
    private LinkedList<T> tSet;
    private LFUNode<T> next;

    public LFUNode(LFUNode<T> previous, Integer frequency, LinkedList<T> tSet, LFUNode<T> next) {
        this.previous = previous;
        this.frequency = frequency;
        this.tSet = tSet;
        this.next = next;
    }

    public LFUNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(LFUNode<T> previous) {
        this.previous = previous;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public LinkedList<T> getSet() {
        return tSet;
    }

    public void setSet(LinkedList<T> value) {
        this.tSet = value;
    }

    public LFUNode<T> getNext() {
        return next;
    }

    public void setNext(LFUNode<T> next) {
        this.next = next;
    }

    public boolean add(T element){
        return tSet.add(element);
    }

    public boolean remove(T element){
        return tSet.remove(element);
    }

    public void pop(){
        tSet.removeFirst();
    }

    public boolean isEmpty() {
        return tSet.isEmpty();
    }

    public boolean contains(T element) {
        return tSet.contains(element);
    }
}

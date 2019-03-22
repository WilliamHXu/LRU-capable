package Utilities;

import java.util.LinkedList;

public class LFUCache<E> {
    // Max Size
    private final Integer maxSize;
    private Integer size;
    // pointer to first node
    LFUNode first;
    // pointer to last node
    LFUNode last;

    public LFUCache(Integer maxSize) {
        this.maxSize = maxSize;
        size = 0;
        first = new LFUNode(null,  1, new LinkedList(), null);;
        last = first;
    }

    public LFUCache() {
        this(100);
    }

    public void add(E element){
        // Check if element is in cache
        LFUNode elementInQueue = findNodeInQueue(element);
        if (elementInQueue != null){
            // remove the element from the LFU Node
            elementInQueue.remove(element);
            // add it to the next one;
            if (elementInQueue.getNext() != null){
                elementInQueue = elementInQueue.getNext();
            }
            else {
                elementInQueue = new LFUNode(elementInQueue, elementInQueue.getFrequency() + 1, new LinkedList(), null);
            }
            elementInQueue.add(element);
        }
        // new element to add to queue
        else{
            // check if queue is full
            if(size < maxSize){
                // if not, add more to the first LFUNode
                first.add(element);
                size++;
            }
            else{
                // If so, do some magic
                replaceLowestFrequencyValue(element);
            }
        }
    }

    private LFUNode findNodeInQueue(E element) {
        LFUNode nodeToCheck = first;
        while (nodeToCheck != null) {
            if (nodeToCheck.contains(element)) {
                break;
            }
            nodeToCheck = nodeToCheck.getNext();
        }
        return nodeToCheck;
    }

    private void replaceLowestFrequencyValue(E element) {
        LFUNode lowestFrequency = first;
        while (lowestFrequency.isEmpty()){
            lowestFrequency = lowestFrequency.getNext();
        }
        lowestFrequency.pop();
        first.add(element);
    }

    public Integer getMaxSize() {
        return maxSize;
    }

    public Integer getSize() {
        return size;
    }

    public LFUNode getFirst() {
        return first;
    }

    public boolean contains(E element) {
        if(findNodeInQueue(element) != null){
            return true;
        }
        return false;
    }
}

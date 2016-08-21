package synthesizer;

public interface BoundedQueue<AnyObject> {
  int capacity(); //return size of the buffer
  int fillCount(); //return number of items currently in the buffer
  void enqueue(AnyObject x); //add an item x to the end
  AnyObject dequeue(); // delete and return the item from the front
  AnyObject peek(); //return (but do not delete item from the front)

  // is the buffer empty (fillCount equals zero)?
  default boolean isEmpty() {
    return fillCount() == 0;
  }
  // is the buffer full (fillcount is same as capacity)
  default boolean isFull() {
    return fillCount() == capacity();
  }
}

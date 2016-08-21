package synthesizer;

public abstract class AbstractBoundedQueue<AnyObject> implements BoundedQueue<AnyObject> {
  protected int fillCount;
  protected int capacity;
  public int capacity() {
    return capacity;
  }
  public int fillCount() {
    return fillCount;
  }
}
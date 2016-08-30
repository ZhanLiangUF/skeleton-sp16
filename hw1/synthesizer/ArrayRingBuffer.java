// TODO: Make sure to make this class a part of the synthesizer package
package synthesizer;
import java.util.Iterator;

//TODO: Make sure to make this class and all of its methods public
//TODO: Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer<AnyObject> extends AbstractBoundedQueue<AnyObject> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private AnyObject[] rb;

    public static void main(String[] args) {
      ArrayRingBuffer l1 = new ArrayRingBuffer(4);
      l1.capacity();
      l1.enqueue("ANYBODY");
      l1.peek();
    }


    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
      rb = (AnyObject[]) new Object[capacity];
      first = 0;
      last = 0;
      fillCount = 0;
      this.capacity = capacity;

    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(AnyObject x) {
      if (last == capacity) {
        throw new IllegalArgumentException("Can't enqueue array ring buffer of size" + capacity);
      }
      rb[last] = x;
      fillCount += 1;
      last += 1;
        // TODO: Enqueue the item. Don't forget to increase fillCount and update last.
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
     public AnyObject dequeue() {
       if (first == capacity) {
         first = 0;
       } else if (fillCount == 0) {
         throw new IllegalArgumentException("Can't dequeue array ring buffer of size" + fillCount);
       }
       AnyObject randomObject = rb[first];
       rb[first] = null;
       fillCount -= 1;
       first += 1;
       return randomObject;
         // TODO: Dequeue the first item. Don't forget to decrease fillCount and update
     }

     /**
      * Return oldest item, but don't remove it.
      */
     public AnyObject peek() {
       System.out.print(rb[first]);
       return rb[first];
         // TODO: Return the first item. None of your instance variables should change.
     }
     // TODO: When you get to part 5, implement the needed code to support iteration.
}

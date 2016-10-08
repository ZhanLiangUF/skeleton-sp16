public class MyHashMap<Value> {
  private int initialSize;   //hash table size
  private int numOfItems; //number of key-value pairs
  private LinearLinkedList<Value>[] hashMap; //array of linked-lists
  /*-------------------------------------------------------------------*/
  public class LinearLinkedList<Value> {
    private Node sentinel;
    private int numOfItems;
    //helper class for LinearLinkedList
    private class Node {
      private String key;
      private Value val;
      private Node sentinel;
      public Node(String key, Value val, Node next) {
        this.key = key;
        this.val = val;
        this.next = next;
      }
    }
    /*Initializes*/
    public LinearLinkedList() {
    }
    /*inserts key-value pair into the linearlinkedlist, overwriting old Value
    with the new value if the list contains specified key.
    Deletes specified key if specified value is null
    */
    public Value put(String key, Value val) {
      if (key == null) throw new NullPointerException("Error - cannot have null key")
      if (val == null) {
        //delete key
        return;
      }
      //for loop to check to see if specified key is already in list
      for(Node x = sentinel; x != null; x = x.next) {
        if (key.equals(x.key)) {
          x.val = val;
          return;
        }
      }
      sentinel = new Node(key, val, sentinel)
      numOfItems++;
    }
    public Value get(String key) {
      if (key == null) throw new NullPointerException("Error - cannot have null key")
      for (Node x = sentinel; x != null; x = x.next) {
        if (key.equals(x.key)) {
          return x.val;
        }
      }
      return null;
    }
  }
/*-------------------------------------------------------------------*/
  public MyHashMap() {
  }
  public MyHashMap(int initialSize) {
    this.initialSize = initialSize;
    hashMap = (LinearLinkedList<Value>[]) new LinearLinkedList[initialSize];
    for (int i = 0; i < initialSize; i++) {
      hashMap[i] = new LinearLinkedList<Value>();
    }
  }
  public boolean contains(Key key) {
    if (key == null) throw new NullPointerException("cannot check for a null key")
    return get(key) != null;
  }
  public MyHashMap(int initialSize, double loadFactor) {
  }
  public void put(String key, Value val) {
    if (key == null) {
      throw new NullPointerException("Error - cannot have null Key")
    }
    if (val == null) {
      //delete key
      return;
    }
    int index = (key.hashCode()) % initialSize;
    if (!hashMap[index].contains(key)) {
      hashMap[i].put(key, val)
      numOfItems++;
    }
  }
  public Value get(String key) {
    if (key == null) throw new NullPointerException("Cannot get a null key")
    int index = (key.hashCode()) % initialSize;
    return hashMap[index].get(key);
  }

}z

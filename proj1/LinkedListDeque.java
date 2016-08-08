public class LinkedListDeque<Item> {

   public class IntNode {
      public Item item;     /* Equivalent of first */
      public IntNode next; /* Equivalent of rest */
      public IntNode previous; /* Equivalent of previous */
      public IntNode(IntNode p,Item i, IntNode n) {
         item = i;
         next = n;
         previous = p;

      }
   }

   public static void main(String[] args) {
      LinkedListDeque l1 = new LinkedListDeque();
      System.out.println(l1.sentinel.next.item);
      System.out.println(l1.sentinel.previous.item);
      l1.addFirst(1);
      l1.printDeque();
      l1.removeFirst();

   }
   private int size;
   private IntNode sentinel;
   private Item product;
   private IntNode indexTracker;
   private Item randomItem;

   //Creates an empty linked list deque
   public LinkedListDeque() {
      size = 0;
      sentinel = new IntNode(null, null, null);
      if (size == 0) {
         sentinel.previous = sentinel;
         sentinel.next = sentinel;
      }

   }
   public void addFirst(Item item) {
      IntNode oldFrontNode = sentinel.next;
      IntNode newNode = new IntNode(sentinel, item, oldFrontNode);
      sentinel.next = newNode;
      if (size == 0) {
         sentinel.previous = newNode;
      } else {
         oldFrontNode.previous = newNode;
      }
      size += 1;
   }

   public void addLast(Item item) {
      IntNode oldBackNode = sentinel.previous;
      IntNode newNode = new IntNode(oldBackNode, item, sentinel);
      sentinel.previous = newNode;
      if (size == 0) {
         sentinel.next = newNode;
      } else {
         oldBackNode.next = newNode;
      }
      size +=1;
   }

   public boolean isEmpty() {
      if (size == 0) {
         return true;
      } else {
         return false;
      }
   }
   public int size() {
      return size;
   }
   public Item get(int index) {
      for(int i=-1; i<index; i++) {
         indexTracker = sentinel.next;
         product = indexTracker.item;
         if ( i > -1) {
            indexTracker = indexTracker.next;
            product = indexTracker.item;
         }
      }
      return product;
   }

   public void printDeque() {
     if (size == 0 ) {
       System.out.print("THIS DEQUE IS EMPTY AF");
     } else {
       for(int i=0; i<size; i++) {
         System.out.print(this.get(i) + " ");
       }
     }
   }
   public Item removeFirst() {
     if (size == 1) {
      randomItem = sentinel.next.item;
      sentinel.next = null;
      sentinel.previous = null;
      size -= 1;
    } else if(size == 0) {
      return null;
    } else {
      randomItem = sentinel.next.item;
      IntNode firstNode = sentinel.next;
      sentinel.next = firstNode.next;
      firstNode.next.previous = sentinel;
      firstNode.item = null;
      firstNode = firstNode.next;
      size -= 1;
    }
     return randomItem;
  }
  //removeLAST is basically same function 

}

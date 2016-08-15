/** Array based list.
*  @author Josh Hug
*/

/* The next item ALWAYS goes in the size postiion */

public class ArrayDeque<Item> {
	/* the stored integers */
	private Item[] items;
	private int size;
	private int nextFirst;
	private int nextLast;
	private int arrayIndex;
	private int counter;

	private static int RFACTOR = 2;

	/** Creates an empty list. */
	public ArrayDeque() {
		//Create an array of size 8
		size = 4;
		items = (Item[]) new Object[size];
		nextFirst = size/2;
		nextLast = nextFirst + 1;
		counter = 0;
	}
	public static void main(String[] args) {
		ArrayDeque l1 = new ArrayDeque();
      l1.addFirst(1);
      l1.addFirst(2);
      l1.addFirst(3);
      l1.addFirst(4);
	}
	/** Resize our backing array so that it is
	* of the given capacity. */
	private void resize(int capacity) {
		Item[] a = (Item[]) new Object[capacity];
		System.arraycopy(items, 0, a, 0, size);
		items = a;
		if (capacity > size) {
			nextFirst = size - 1;
			nextLast = size/2;
		} else if(size > capacity) {
			nextFirst = capacity/2;
			nextLast = nextFirst + 1;
		}
		size = capacity;
	}


	public void addBack(Item item) {
		if (counter == size) {
			resize(size * RFACTOR);
		}
		items[nextLast] = item;
		nextLast += 1;
		if (nextLast == size) {
			nextLast = 0;
		}
		counter += 1;
	}

	public void addFirst(Item item) {
		if (counter == size) {
			resize(size * RFACTOR);
		}
		items[nextFirst] = item;
		nextFirst -= 1;
		if (nextFirst == -1) {
			nextFirst = size - 1;
		}
		counter += 1;
	}

	public Item getFirst() {
		return items[nextFirst + 1];
	}
	/** Returns the item from the back of the list. */
	public Item getBack() {
		return items[nextLast - 1];
	}
	/** Gets the ith item in the list (0 is the front). */
	public Item get(int i) {
		return items[i];
	}

	/** Returns the number of items in the list. */
	public int size() {
		return size;
	}
	public Item removeFirst() {
		if (counter == 0) {
			return null;
		} else if (nextFirst == size-1) {
			nextFirst = -1;
		}
		Item itemToReturn = getFirst();
		items[nextFirst + 1] = null;
		counter -= 1;
		nextFirst += 1;

		double rRatio = ((double)counter)/((double)size);
		System.out.print(rRatio);
		if (rRatio == 0.25 && counter > 1) {
			resize(size/2);
		}
		return itemToReturn;
		/** remove function is basically the same*/
	}
}

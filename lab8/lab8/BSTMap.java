package lab8;
import java.util.Set;

public class BSTMap<K extends Comparable<Key>, Value> implements Map61B<K, V> {


 private Node root; // In a rooted tree, we call one node the root

 private class Node {
   private Key key;
   private Value val;
   private Node left, right;
   private int size; // # of nodes

   public Node(Key key, Value val, int size) {
     this.key = key;
     this.val = val;
     this.size = size;
   }


 }

 public void put(Key key, Value val) {
   // throw error when key or val is null
   root = putHelper(root, key, val);

 }

 private Node putHelper(Node x, Key key, Value val) {
   if (x == null) {
     return new Node(key, val, 1);
   }
   int cmp = key.compareTo(x.key);
   if (cmp < 0) { // cmp is negative if this.key < input key
     x.left  = putHelper(x.left, key, val);
   } else if (cmp > 0) {// cmp is positive if this.key > input key
     x.right = putHelper(x.right, key, val);
   } else {
     x.val = val;
   }
   x.size = 1 + size(x.left) + size(x.right);
   return x;
 }

 public int size() {
   if (root == null) {
     return 0;
   }
   return root.size;
 }

 public void clear() {
   root == null
 }




}

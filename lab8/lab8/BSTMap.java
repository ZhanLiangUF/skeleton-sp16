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

 public Value get(Key key) {
   return get(root,key);
 }
 
 private Value get(Node x,Key key) {
   if (x == null) return null;
   int cmp = key.compareTo(x.key);
   if (cmp < 0) {
     get(x.left, key);
   } else if (cmp > 0) {
     get(x.right, key);
   } else {
     return x.val;
   }
 }

 private Node putHelper(Node x, Key key, Value val) {
   if (x == null) {
     return new Node(key, val, 1);
   }
   int cmp = key.compareTo(x.key);
   if (cmp < 0) { // cmp is negative if this.key > input key
     x.left  = putHelper(x.left, key, val);
   } else if (cmp > 0) {// cmp is positive if this.key < input key
     x.right = putHelper(x.right, key, val);
   } else {
     x.val = val;
   }
   x.size = 1 + size(x.left) + size(x.right);
   return x;
 }


public int size() {
  return size(root);
}

private int size(Node x) {
  if (x == null) return 0;
  else return x.size;
}

 public void clear() {
   root == null
 }





}

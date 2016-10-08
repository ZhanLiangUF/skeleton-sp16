public class WeightedQuickUnion {
  private int[] parent; // parent[i] = parent of i
  private int[] size;  // size[i] = number of sites in subtree rooted at i
  private int count; // number of components

  public static void main(String[] args) {
    WeightedQuickUnion uf = new WeightedQuickUnion(3);
    uf.isConnected(1,2);
  }

  public WeightedQuickUnion(int n) {
    parent = new int[n];
    size = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
      size[i] = 1;
    }
  }

  public boolean isConnected(int p, int q) {
    System.out.print(find(p) == find(q));
    return find(p) == find(q);
  }

  private int find(int p) {
    if (p == parent[p]) {
      return p;
    } else {
      parent[p] = find(parent[p]);
      return parent[p];
    }
  }

  private void connect(int p, int q) {
    int i = find(p);
    int j = find(q);
    if (i ==j) return;
    if (size[i] < size[j]) {
      parent[i] = j; size[j] += size[i];
    } else {
      parent[j] = i; size[i] += size[j];
    }
  }

}

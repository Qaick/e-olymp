package backups;

import java.util.Map;

public class DisjointSet {

    private Map<Integer, Node> map;

    class Node {
        int data;
        Node parent;//null
        int rank;//0

        Node(int data) {
            this.data = data;
        }
    }

    /**
     * Create a set with only one element.
     */
    public void makeSet(int data) {
        map.put(data, new Node(data));
    }

    /**
     * Combines two sets together to one.
     * Does union by rank
     *
     * @return true if data1 and data2 are in different set before union else false.
     */
    public boolean union(int data1, int data2) {//TODO optimize
        Node node1 = map.get(data1);
        Node node2 = map.get(data2);

        Node parent1 = findSet(node1);
        Node parent2 = findSet(node2);

        //if they are part of same set do nothing
        if (parent1.data == parent2.data) {
            return false;
        }

        //else whoever's rank is higher becomes parent of other
        if (parent1.rank >= parent2.rank) {
            //increment rank only if both sets have same rank
            parent1.rank = (parent1.rank == parent2.rank) ? parent1.rank + 1 : parent1.rank;
            parent2.parent = parent1;
        } else {
            parent1.parent = parent2;
        }
        return true;
    }

    /**
     * Finds the representative of this set
     */
    public int findSet(int data) {
        return findSet(map.get(data)).data;
    }

    /**
     * Find the representative recursively and does path
     * compression as well.
     */
//    private Node findSet(Node node) {
//        while (node.parent != null) node = node.parent;
//        return node;
//    }
    //findSet with partly path compression
//    private Node findSet(Node node) {
//        Node root = node;
//        if (root.parent != null) {
//            while (root.parent != null) root = root.parent;
//            node.parent = root;
//        }
//        return root;
//    }
    //full path compression
    private Node findSet(Node node) {
        Node parent = node.parent;
        if (parent == node) {
            return parent;
        }
        node.parent = findSet(node.parent);
        return node.parent;
    }

    public static void main(String args[]) {
        long time = System.currentTimeMillis();
        DisjointSet ds = new DisjointSet();

        StringBuilder answer = new StringBuilder();
        ds.makeSet(1);
        ds.makeSet(2);
        ds.makeSet(3);
        ds.makeSet(4);
        ds.makeSet(5);
        ds.makeSet(6);
        ds.makeSet(7);

        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 5);
        ds.union(6, 7);
        ds.union(5, 6);
        ds.union(3, 7);

        System.out.println(ds.findSet(1));
        System.out.println(ds.findSet(2));
        System.out.println(ds.findSet(3));
        System.out.println(ds.findSet(4));
        System.out.println(ds.findSet(5));
        System.out.println(ds.findSet(6));
        System.out.println(ds.findSet(7));
    }
}
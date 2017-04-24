import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.Stack;
import java.util.TreeMap;

/**
 * Created by deepakp on 5/7/16.
 */
public class DataStructures {

    static class Node {
        public final int value;
        public final List<Node> neighbors;

        public Node(final int value, final List<Node> neighbors) {
            this.value = value;
            this.neighbors = neighbors;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;

            Node node = (Node) o;

            if (value != node.value) return false;
            return neighbors != null ? neighbors.equals(node.neighbors) : node.neighbors == null;

        }

        @Override
        public int hashCode() {
            int result = value;
            result = 31 * result + (neighbors != null ? neighbors.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", neighbors=" + neighbors +
                    '}';
        }
    }

    public static void main(String[] args) {
        SortedMap<String, Integer> sortedMap = new TreeMap<>();
        sortedMap.put("Bobby", 1);
        sortedMap.put("John", 2);
        sortedMap.put("Bob", 5);
        sortedMap.put("Astong", 6);
        System.out.println(sortedMap.subMap("Bob", "Deepak"));

        Node nodeA = new Node(5, Collections.EMPTY_LIST);
        Node nodeB = new Node(6, Collections.EMPTY_LIST);
        List<Node> n1 = new ArrayList<>();
        n1.add(nodeA);
        Node node1 = new Node(2, n1);
        n1.add(nodeB);
        Node node2 = new Node(3, n1);
        List<Node> neighbors = new ArrayList<>();
        neighbors.add(node1);
        neighbors.add(node2);
        Node root = new Node(1, neighbors);
        printDFS(root);
        printDFSRecursive(root, new HashSet<Node>());
    }


    public static void printDFSRecursive(Node root, Set<Node> seenSet) {
        if (root.neighbors.isEmpty()) {
            System.out.println(root);
        } else {
            List<Node> neighbors = root.neighbors;
            for (Node n: neighbors) {
                if (!seenSet.contains(n)) {
                    seenSet.add(n);
                    printDFSRecursive(n, seenSet);
                }
            }
            System.out.println(root);
        }
    }

    public static void printDFS(Node root) {
        if (root == null) {
            throw new IllegalArgumentException("Root is null!");
        }
        Set<Node> seenNodes = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        seenNodes.add(root);

        Stack<String> resultStack = new Stack<>();
        String level = "";
        while (!stack.isEmpty()) {
            Node top = stack.peek();
            List<Node> neighbors = top.neighbors;
            if (neighbors.isEmpty()) {
                level = level + "->";
                resultStack.push(top.value + level);
                stack.pop();
            } else {
                boolean myNeighborsExplored = true;
                for (Node neighbor : neighbors) {
                    if (!seenNodes.contains(neighbor)) {
                        stack.add(neighbor);
                        myNeighborsExplored = false;
                        seenNodes.add(neighbor);
                    }
                }
                if (myNeighborsExplored) {
                    level = level + "->";
                    resultStack.push(top.value + level);
                    stack.pop();
                }
            }
        }

        System.out.println("Topological sort order is :-");
        while (!resultStack.isEmpty()) {
            System.out.println(resultStack.peek());
            resultStack.pop();
        }
    }

}

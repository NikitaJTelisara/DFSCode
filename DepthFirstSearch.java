import java.util.ArrayList;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: NT030798
 * Date: 1/25/17
 * Time: 11:33 AM
 * To change this template use File | Settings | File Templates.
 */
public class DepthFirstSearch {
    /*
    40------>20->50
    |  _ _//  |   |
    v v   v   v   v
    10-->30->60->70

    DFS-> Iterative -> 40 20 50 70 60 30 10
    DFS-> Recursive -> 40 10 30 60 70 20 50
    The recursive version uses the call stack while the iterative version performs
    exactly the same steps, but uses a user-defined stack instead of the call stack.
    There is no difference in the sequence of steps itself
    */

    public static void main(String[] args) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node n1 = new Node(40);
        nodes.add(n1);
        Node n2 = new Node(10);
        nodes.add(n2);
        Node n3 = new Node(20);
        nodes.add(n3);
        Node n4 = new Node(30);
        nodes.add(n4);
        Node n5 = new Node(60);
        nodes.add(n5);
        Node n6 = new Node(50);
        nodes.add(n6);
        Node n7 = new Node(70);
        nodes.add(n7);

        // arrayList = 40 10 20 30 60 50 70

        int[][] adjacentNodes = {
                {0, 1, 1, 0, 0, 0, 0},  // Node 1: 40
                {0, 0, 0, 1, 0, 0, 0},  // Node 2 :10
                {0, 1, 0, 1, 1, 1, 0},  // Node 3: 20
                {0, 0, 0, 0, 1, 0, 0}, // Node 4: 30
                {0, 0, 0, 0, 0, 0, 1}, // Node 5: 60
                {0, 0, 0, 0, 0, 0, 1}, // Node 6: 50
                {0, 0, 0, 0, 0, 0, 0}, // Node 7: 70
        };

        ArrayList neighbours = findNeighbours(adjacentNodes, n1, nodes);
        System.out.println("Neighbours of " + n1.data);
        for (int i = 0; i < neighbours.size(); i++) {
            Node n = (Node) neighbours.get(i);
            System.out.println(n.data);
        }
        System.out.println("dfs using stack");
        dfsUsingStack(n1, adjacentNodes, nodes);
        clearFlags(nodes);
        System.out.println("recursive dfs");
        recursiveDfs(n1, adjacentNodes, nodes);
    }

    public static ArrayList<Node> findNeighbours(int[][] m, Node n, ArrayList<Node> nodes) {
        ArrayList<Node> neighbours = new ArrayList<Node>();
        int nodeIndex = -1;
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i) == n) {
                nodeIndex = i;
            }
        }
        if (nodeIndex != -1) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[nodeIndex][j] == 1) {
                    {
                        neighbours.add(nodes.get(j));
                    }
                }
            }
        }
        return neighbours;
    }

    //Iterative dfs using stack
    public static void dfsUsingStack(Node n, int[][] m, ArrayList<Node> nodes) {
        Stack stack = new Stack();
        stack.push(n);
        n.visited = true;
        while (!stack.empty()) {
            Node element = (Node) stack.pop();
            System.out.println(element.data);
            ArrayList<Node> neighbours = findNeighbours(m, element, nodes);
            for (int i = 0; i < neighbours.size(); i++) {
                Node n1 = neighbours.get(i);
                if (n1 != null && !n1.visited) {
                    stack.push(n1);
                    n1.visited = true;
                }
            }
        }
    }

    //Recursive dfs
    public static void recursiveDfs(Node n, int[][] m, ArrayList<Node> nodes) {
        n.visited = true;
        System.out.println(n.data);
        ArrayList<Node> neighbours = findNeighbours(m, n, nodes);
        for (int i = 0; i < neighbours.size(); i++) {
            Node element = neighbours.get(i);
            if (n != null && !element.visited) {
                recursiveDfs(element, m, nodes);
            }
        }
    }

    //clear Flags
    public static void clearFlags(ArrayList<Node> nodes) {
        for (int i = 0; i < nodes.size(); i++) {
            Node n = nodes.get(i);
            if (n.visited) {
                n.visited = false;
            }
        }
    }
}

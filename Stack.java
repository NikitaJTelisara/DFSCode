package DFS_BFS;



public class Stack {
    Lab top;



    public void push(Lab n1) {
        if (top != null) {
            n1.next = top;
        }
        top = n1;
    }

    public Lab pop() {
        if (top != null) {
            Lab n = top;
            top = top.next;
            return n;
        }
        return null;
    }

    public boolean isEmpty() {
        return (top == null);
    }

    public Lab peek() {
        if (top != null) {
            return top;
        }
        return null;
    }
}

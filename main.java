package DFS_BFS;


import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
        Lab l1 = new Lab(1);
        Lab l2 = new Lab(2);
        Lab l3 = new Lab(3);
        Lab l4 = new Lab(4);
        Lab l5 = new Lab(5);
        Lab l6 = new Lab(6);
        Lab l7 = new Lab(7);
        Lab l8 = new Lab(8);

        l1.addNeigh(l2);

        l2.addNeigh(l3);
        l2.addNeigh(l4);

        l4.addNeigh(l5);

        l5.addNeigh(l6);
        l5.addNeigh(l7);
        l3.addNeigh(l8);

        System.out.print(isPath(l2, l6));
    }

    public static boolean isPath(Lab l1, Lab l2) {
        Stack s = new Stack();
        s.push(l1);
        while (!s.isEmpty()) {
            Lab e = s.pop();
            if (e.roomNumber == l2.roomNumber) {
                return true;
            }
            e.visted = true;

            ArrayList<Lab> list = e.neighbours;
            for (int i = 0; i < list.size(); i++) {
                Lab e1 = list.get(i);
                if (e1 != null && (e1.visted == false)) {
                    s.push(e1);
                }
            }
        }
        return false;
    }


}

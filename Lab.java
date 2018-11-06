package DFS_BFS;
import java.util.ArrayList;
public class Lab {
    int roomNumber;
    boolean visted;
    Lab next;
    ArrayList<Lab> neighbours;

    public Lab(int roomNumber){
        this.roomNumber = roomNumber;
        this.neighbours = new ArrayList<Lab>();
        this.visted = false;
    }

    public void addNeigh(Lab n){
         neighbours.add(n);
    }

    public void removeNeigh(Lab n){
        neighbours.remove(n);
    }
}

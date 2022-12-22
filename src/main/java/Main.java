import model.DivisionHead;
import model.DivisionNode;
import model.sugar.FillingSugar;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DivisionHead divisionHead = new DivisionHead("8256", "3", "2752", "6");
        System.out.println(divisionHead);
        List<DivisionNode> nodes = new ArrayList<>();
        int globalMoveK = 0;

        nodes.add(new DivisionNode("22", "21", globalMoveK));
        nodes.add(new DivisionNode("15", "15", globalMoveK));
        nodes.add(new DivisionNode("06", "2", globalMoveK));
        nodes.add(new DivisionNode("0", globalMoveK));

        for (int i = 0; i < nodes.size(); i++) {System.out.println(nodes.get(i).toString(i));}
    }
}

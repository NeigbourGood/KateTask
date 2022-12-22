import model.CalculatorDto;
import model.DivisionHead;
import model.DivisionNode;
import service.impl.DivisionPrinterService;

import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        DivisionPrinterService divisionPrinterService = new DivisionPrinterService();
        DivisionHead divisionHead = new DivisionHead("8256", "3", "2752", "6");
        List<DivisionNode> nodes = new ArrayList<>();
        int globalMoveK = 0;

        nodes.add(new DivisionNode("22", "21", globalMoveK));
        nodes.add(new DivisionNode("15", "15", globalMoveK));
        nodes.add(new DivisionNode("06", "2", globalMoveK));
        nodes.add(new DivisionNode("0", globalMoveK));
        CalculatorDto calculatorDto = new CalculatorDto(divisionHead, nodes);
        System.out.println(divisionPrinterService.print(calculatorDto));
    }
}

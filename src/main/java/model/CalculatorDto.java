package model;

import java.util.List;

public class CalculatorDto {
    private final DivisionHead head;
    private final List<DivisionNode> divisionNodes;

    public CalculatorDto(DivisionHead head, List<DivisionNode> divisionNodes) {
        this.head = head;
        this.divisionNodes = divisionNodes;
    }

    public DivisionHead getHead() {
        return head;
    }

    public List<DivisionNode> getDivisionNodes() {
        return divisionNodes;
    }
}

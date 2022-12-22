package service.impl;

import model.CalculatorDto;
import model.DivisionNode;
import service.PrinterService;

import java.util.StringJoiner;

public class DivisionPrinterService implements PrinterService {

    @Override
    public String print(CalculatorDto dto) {
        StringJoiner joiner = new StringJoiner("\n");
        String head = dto.getHead().toString();
        int index = 0;
        for(DivisionNode node : dto.getDivisionNodes()) {
            joiner.add(node.toString(index));
           index++;
        }
        return head + joiner;
    }
}

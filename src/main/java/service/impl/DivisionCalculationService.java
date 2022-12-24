package service.impl;

import model.CalculatorDto;
import model.DivisionHead;
import model.DivisionNode;
import service.CalculationService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DivisionCalculationService implements CalculationService {
    @Override
    public CalculatorDto calculateDivision(int dividend, int divisor) {
        int result = dividend / divisor;
        List<Integer> dividedAsList = numberSplit(dividend);
        List<Integer> resultAsList = numberSplit(result);
        int multiplyResult = divisor * resultAsList.get(0);
        return new CalculatorDto(
                new DivisionHead(dividend, divisor, result, multiplyResult),
                calculateNodes(dividedAsList, resultAsList, divisor, multiplyResult)
        );
    }

    private List<DivisionNode> calculateNodes(List<Integer> dividendAsList, List<Integer> resultAsList, int divisor, int initialMultiply) {
        List<DivisionNode> nodes = new ArrayList<>();

        int dividedNumber = resolveDividedNumber(dividendAsList, initialMultiply);
        int minus = dividedNumber - initialMultiply;
        int dividedIndex = String.valueOf(dividedNumber).length();
        int globalMoveK = 0;
        for (int i = 1; i < resultAsList.size(); i++) {
            String number1 = String.valueOf(minus) + dividendAsList.get(dividedIndex);
            String number2 = String.valueOf(divisor * resultAsList.get(i));
            nodes.add(new DivisionNode(
                    number1,
                    number2,
                    globalMoveK)
            );
            minus = Integer.parseInt(number1) - Integer.parseInt(number2);
            dividedIndex++;
            globalMoveK++;
        }
        nodes.add(new DivisionNode("0", globalMoveK));
        return nodes;
    }

    private int resolveDividedNumber(List<Integer> dividendAsList, int multiply) {
        StringBuilder accumulator = new StringBuilder();
        for (int i = 0; accumulator.length() < numberSplit(multiply).size(); i++) {
            accumulator.append(dividendAsList.get(i));
        }
        return Integer.parseInt(accumulator.toString());
    }

    private List<Integer> numberSplit(int number) {
        int result = number;
        ArrayList<Integer> numbers = new ArrayList<>();
        while (result > 0) {
            numbers.add(result % 10);
            result = result / 10;
        }
        Collections.reverse(numbers);
        return numbers;
    }
}
/*
        int loopStartValue = 0;
        int firstIterationNumber = 0;
        if(dividedAsList.get(0) < divisor) {
            String accumulator = "0";
            for(int i = 0; Integer.parseInt(accumulator) < divisor; i++) {
                accumulator += dividedAsList.get(i);
                loopStartValue = i;
            }
            firstIterationNumber = Integer.parseInt(accumulator);
        } else {
            firstIterationNumber = dividedAsList.get(0);
        }
        int multiplyResult = resultAsList.get(0) * divisor;
        int index = 1;
        for(int j = loopStartValue; j < dividedAsList.size(); j++) {
            if(j < dividedAsList.size() - 1) {
            int minusResult = firstIterationNumber - multiplyResult;
            String newNumber = Integer.toString(minusResult) + dividedAsList.get(j + 1);
            int multiplyNextIteration = resultAsList.get(index) * divisor;
                nodes.add(new DivisionNode(newNumber, String.valueOf(multiplyNextIteration), index));
                index++;
        } else {
                int minusResult = firstIterationNumber - multiplyResult;
                String newNumber = Integer.toString(minusResult) + dividedAsList.get(j);
                int multiplyNextIteration = resultAsList.get(index - 1) * divisor;
                nodes.add(new DivisionNode(newNumber, String.valueOf(multiplyNextIteration), index));
            }
        }
 */
package model;

import model.sugar.FillingSugar;

import java.util.StringJoiner;

public class DivisionNode implements FillingSugar {
    private final String number1;
    private final String number2;
    private final int globalMoveK;

    public DivisionNode(String number1, String number2, int globalMoveK) {
        this.number1 = number1;
        this.number2 = number2;
        this.globalMoveK = globalMoveK;
    }

    public DivisionNode(String number1, int globalMoveK) {
        this.number1 = number1;
        this.globalMoveK = globalMoveK;
        this.number2 = null;
    }

    public String toString(int moveK) {
        return number2 != null ? printNode(moveK) : printLastNode(moveK);
    }

    private String printNode(int moveK) {
        return String.format(
                "%s_%s\n%s %s\n%s %s",
                makeMove(moveK, false),
                number1,
                makeMove(moveK, false),
                resolveNumber2(),
                makeMove(moveK, false),
                makeCharacterString(number1.length(), '-')
        );
    }

    private String printLastNode(int moveK) {
        return String.format(
                "%s %s",
                makeMove(moveK, false),
                number1
        );
    }

    private String makeMove(int k, boolean isInternal) {
        int moveCount = isInternal ? k : k + globalMoveK;
        return makeCharacterString(moveCount, ' ');
    }

    private String resolveNumber2() {
        if (number2 == null) {
            return "";
        }
        if (number1.length() != number2.length()) {
            return makeMove((number1.length() - number2.length()), true) + number2;
        } else {
            return number2;
        }
    }
}

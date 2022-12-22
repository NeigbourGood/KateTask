package model;

import model.sugar.FillingSugar;

import java.util.StringJoiner;

public class DivisionHead implements FillingSugar {
    private final String dividend;
    private final String divisor;
    private final String result;
    private final String multiplyResult;

    public DivisionHead(String dividend, String divisor, String result, String multiplyResult) {
        this.dividend = dividend;
        this.divisor = divisor;
        this.result = result;
        this.multiplyResult = multiplyResult;
    }

    @Override
    public String toString() {
        return String.format(
                "_%s|%s\n %s%s|%s\n %s%s|%s\n",
                dividend,
                divisor,
                multiplyResult,
                makeCharacterString(dividend.length() - multiplyResult.length(), ' '),
                makeCharacterString(result.length(), '-'),
                makeCharacterString(multiplyResult.length(), '-'),
                makeCharacterString(dividend.length() - multiplyResult.length(), ' '),
                result
        );
    }
}

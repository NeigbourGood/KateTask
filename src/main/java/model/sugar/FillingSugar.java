package model.sugar;

import java.util.Arrays;

public interface FillingSugar {
    default String makeCharacterString(int counter, char symbol) {
        char[] result = new char[counter];
        Arrays.fill(result, symbol);
        return new String(result);
    }
}

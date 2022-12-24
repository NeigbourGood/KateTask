package service;

import model.CalculatorDto;

public interface CalculationService {
    CalculatorDto calculateDivision(int dividend, int divisor);
}

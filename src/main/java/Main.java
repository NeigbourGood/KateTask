import model.CalculatorDto;
import service.impl.DivisionCalculationService;
import service.impl.DivisionPrinterService;


public class Main {
    public static void main(String[] args) {
        DivisionCalculationService cal = new DivisionCalculationService();
        DivisionPrinterService print = new DivisionPrinterService();
        CalculatorDto calculatorDto = cal.calculateDivision(8256, 3);
        String print1 = print.print(calculatorDto);
        System.out.println(print1);

    }
}

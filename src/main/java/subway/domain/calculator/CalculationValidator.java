package subway.domain.calculator;

import subway.domain.calculator.exception.SameStationException;

public class CalculationValidator {
    private CalculationValidator() {
    }

    public static void validateCalculation(String source, String dest) {
        validateStationName(source, dest);
    }

    private static void validateStationName(String source, String dest) {
        if (source.equals(dest)) {
            throw new SameStationException();
        }
    }
}

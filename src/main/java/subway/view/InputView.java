package subway.view;

import subway.dto.PathRequestDto;
import subway.type.FunctionType;
import subway.type.ManagementType;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_MANAGEMENT_OR_FUNCTION_TYPE = "\n## 원하는 기능을 선택하세요.";
    private static final String INPUT_FIRST_STATION_NAME = "\n## 출발역을 입력하세요.";
    private static final String INPUT_LAST_STATION_NAME = "\n## 도착역을 입력하세요.";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public ManagementType inputManagementType() {
        System.out.println(INPUT_MANAGEMENT_OR_FUNCTION_TYPE);
        String userInput = scanner.nextLine();
        try {
            return ManagementType.findManagementType(userInput);
        } catch (RuntimeException runtimeException) {
            OutputView.printErrorMessage(runtimeException);
            return inputManagementType();
        }
    }

    public FunctionType inputFunctionType(ManagementType managementType) {
        System.out.println(INPUT_MANAGEMENT_OR_FUNCTION_TYPE);
        String userInput = scanner.nextLine();
        try {
            return managementType.findFunctionType(userInput);
        } catch (RuntimeException runtimeException) {
            OutputView.printErrorMessage(runtimeException);
            return inputFunctionType(managementType);
        }
    }

    public PathRequestDto inputPathRequest() {
        System.out.println(INPUT_FIRST_STATION_NAME);
        String firstStationName = scanner.nextLine();
        System.out.println(INPUT_LAST_STATION_NAME);
        String lastStationName = scanner.nextLine();
        return new PathRequestDto(firstStationName, lastStationName);
    }
}

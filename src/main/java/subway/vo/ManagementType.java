package subway.vo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum ManagementType {
    STATION("1", Arrays.asList(FunctionType.SHORTEST_DISTANCE,
            FunctionType.MINIMUM_TIME,
            FunctionType.BACK)),
    QUIT("Q", Collections.emptyList());

    private final String managementNumber;
    private final List<FunctionType> functionTypes;

    ManagementType(String managementNumber, List<FunctionType> functionTypes) {
        this.managementNumber = managementNumber;
        this.functionTypes = functionTypes;
    }

    public static ManagementType findManagementNumber(String managementNumber) {
        return Arrays.stream(values())
                .filter(managementType -> managementType.managementNumber.equals(managementNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 선택한 기능이 없습니다."));
    }

    public FunctionType findFunctionNumber(String functionNumber) {
        return functionTypes.stream()
                .filter(functionType -> functionType.matches(functionNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 선택한 기능이 없습니다."));
    }

    public boolean isRunning() {
        return this != QUIT;
    }
}
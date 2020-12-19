package subway.type;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public enum ManagementType {
    ROUTE_SEARCH("1",
            Arrays.asList(FunctionType.SHORTEST_DISTANCE_ROUTE, FunctionType.MINIMUM_TIME_ROUTE, FunctionType.BACK)),
    EXIT("Q", Collections.emptyList());

    private final String managementLetter;
    private final List<FunctionType> functions;

    private ManagementType(String managementLetter, List<FunctionType> functions) {
        this.managementLetter = managementLetter;
        this.functions = functions;
    }

    public static ManagementType findManagementType(String managementLetter) {
        return Arrays.stream(ManagementType.values())
                .filter(managementType -> managementType.matches(managementLetter))
                .findFirst()
                .orElseThrow(UnsupportedFunctionException::new);
    }

    public FunctionType findFunctionType(String functionLetter) {
        return functions.stream()
                .filter(functionType -> functionType.matches(functionLetter))
                .findFirst()
                .orElseThrow(UnsupportedFunctionException::new);
    }

    private boolean matches(String managementLetter) {
        return Objects.equals(this.managementLetter, managementLetter);
    }
}

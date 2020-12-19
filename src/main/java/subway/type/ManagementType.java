package subway.type;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
}

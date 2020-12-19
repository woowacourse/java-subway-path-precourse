package subway.vo;

import java.util.Arrays;

public enum ManagementType {
    STATION("1"),
    QUIT("Q");

    private final String managementNumber;

    ManagementType(String managementNumber) {
        this.managementNumber = managementNumber;
    }

    public static ManagementType findManagementNumber(String managementNumber) {
        return Arrays.stream(values())
                .filter(managementType -> managementType.managementNumber.equals(managementNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 선택한 기능이 없습니다."));
    }

    public boolean isRunning() {
        return this != QUIT;
    }
}
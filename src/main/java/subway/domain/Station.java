package subway.domain;

import subway.domain.constants.DomainConstant;
import subway.domain.constants.DomainErrorMessage;

public class Station {
    private String name;

    public Station(String name) {
        checkValidName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void checkValidName(String name) {
        checkEndName(name);
    }

    private void checkEndName(String name) {
        String last = name.substring(name.length() - DomainConstant.LAST_LOCATION);

        if (!last.equals(DomainConstant.STATION_STRING)) {
            System.out.println();
            System.out.println(DomainErrorMessage.STATION_FORMAT);
            throw new IllegalArgumentException(DomainErrorMessage.STATION_FORMAT);
        }
    }
}

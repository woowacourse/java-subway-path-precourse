package subway.ui;

import static java.util.stream.Collectors.toMap;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public enum MainMenuEnum {
    SEARCH_PATH("경로 조회", "1") {
        @Override
        public void action(final Scanner scanner) {
        }
    },
    EXIT("종료", "Q") {
        @Override
        public void action(final Scanner scanner) {
        }
    },
    ;

    private static final Map<String, MainMenuEnum> MAP;

    static {
        Map<String, MainMenuEnum> mainMenuEnumMap = Arrays.stream(values())
            .collect(toMap(mainMenuEnum -> mainMenuEnum.shortcut, e -> e));
        MAP = Collections.unmodifiableMap(mainMenuEnumMap);
    }

    private final String name;
    private final String shortcut;

    MainMenuEnum(String name, String shortcut) {
        this.name = name;
        this.shortcut = shortcut;
    }

    public static Optional<MainMenuEnum> of(final String shortcut) {
        return Optional.ofNullable(MAP.get(shortcut));
    }

    public abstract void action(final Scanner scanner);

    public String getName() {
        return name;
    }

    public String getShortcut() {
        return shortcut;
    }
}

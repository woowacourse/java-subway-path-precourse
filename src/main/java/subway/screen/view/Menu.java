package subway.screen.view;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface Menu {
    String getCommand();

    String getName();

    static List<Menu> findAll(Class<? extends Menu> menuClass) {
        Menu[] enumValues = menuClass.getEnumConstants();
        if(enumValues == null) {
            throw new IllegalArgumentException("Enum 형식의 클래스가 아닙니다.");
        }
        return Arrays.stream(enumValues).collect(Collectors.toList());
    }

    static Optional<Menu> findByCommand(Class<? extends Menu> menuClass, String command) {
        List<Menu> menuList = findAll(menuClass);
        for (Menu menu : menuList) {
            if (menu.getCommand().equals(command)) {
                return Optional.of(menu);
            }
        }
        return Optional.empty();
    }
}

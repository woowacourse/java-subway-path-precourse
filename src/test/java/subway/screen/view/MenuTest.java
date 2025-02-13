package subway.screen.view;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MenuTest {
    private static class ClassMenu implements Menu {
        @Override
        public String getCommand() {
            return "";
        }

        @Override
        public String getName() {
            return "";
        }
    }

    private enum EnumMenu implements Menu {
        ITEM("command", "name");

        private final String command;
        private final String name;

        EnumMenu(String command, String name) {
            this.command = command;
            this.name = name;
        }

        @Override
        public String getCommand() {
            return this.command;
        }

        @Override
        public String getName() {
            return this.name;
        }
    }

    @Test
    public void findAll() {
        EnumMenu[] enumMenus = EnumMenu.values();
        assertThat(Menu.findAll(EnumMenu.class)).containsExactly(enumMenus);
    }

    @Test
    public void findAll__NotEnumTypeClassException() {
        String message = "Enum 형식의 클래스가 아닙니다.";
        assertThatThrownBy(() -> Menu.findAll(ClassMenu.class)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
    }

    @Test
    public void findByCommand() {
        EnumMenu item = EnumMenu.ITEM;
        assertThat(Menu.findByCommand(EnumMenu.class, "none")).isNotPresent();
        assertThat(Menu.findByCommand(EnumMenu.class, item.getCommand())).isPresent();
    }
}

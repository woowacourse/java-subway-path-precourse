package subway.screen.view;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MenuEventManagerTest {
    private enum EnumMenu implements Menu {
        ITEM("command", "name"), NONE("", "");

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
    public void addEventListener__NotReceivedMenuException() {
        MenuEventManager menuEventManager = MenuEventManager.builder();
        String message = "메뉴를 전달받지 못하였습니다.";
        assertThatThrownBy(() -> menuEventManager.addEventListener(null, () -> {
        })).isInstanceOf(IllegalArgumentException.class).hasMessage(message);
    }

    @Test
    public void addEventListener__NotReceivedHandlerException() {
        MenuEventManager menuEventManager = MenuEventManager.builder();
        String message = "이벤트 핸들러를 전달받지 못하였습니다.";
        assertThatThrownBy(() -> menuEventManager.addEventListener(EnumMenu.ITEM, null)).isInstanceOf(
            IllegalArgumentException.class).hasMessage(message);
    }

    @Test
    public void select() {
        MenuEventManager menuEventManager = MenuEventManager.builder().addEventListener(EnumMenu.ITEM, () -> {
        });
        assertThat(menuEventManager.select(EnumMenu.NONE)).isNotPresent();
        assertThat(menuEventManager.select(EnumMenu.ITEM)).isPresent();
    }
}

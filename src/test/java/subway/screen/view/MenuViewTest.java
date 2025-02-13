package subway.screen.view;

import static org.assertj.core.api.Assertions.*;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import subway.screen.ui.Console;

public class MenuViewTest {
    private MockedStatic<Console> mockConsole;

    private enum TestMenu implements Menu {
        ITEM("command", "name");

        private final String command;
        private final String name;

        TestMenu(String command, String name) {
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

    private static class TestMenuView extends MenuView {
        public TestMenuView() {
        }

        public TestMenuView(MenuEventManager menuEventManager) {
            super(menuEventManager);
        }

        @Override
        protected Class<? extends Menu> getType() {
            return TestMenu.class;
        }

        @Override
        public String title() {
            return "테스트 화면";
        }
    }

    @BeforeEach
    public void setup() {
        mockConsole = Mockito.mockStatic(Console.class);
    }

    @Test
    public void constructor__NotReceivedEventManagerException() {
        String message = "이벤트 관리자를 전달받지 못하였습니다.";
        assertThatThrownBy(() -> new MenuView(null) {
            @Override
            public String title() {
                return "";
            }

            @Override
            protected Class<? extends Menu> getType() {
                return null;
            }
        }).isInstanceOf(IllegalArgumentException.class).hasMessage(message);
    }

    @Test
    public void show() {
        TestMenu item = TestMenu.ITEM;
        TestMenuView testMenuView = new TestMenuView();
        testMenuView.show();
        this.mockConsole.verify(() -> {
            Console.printHeader(testMenuView.title());
            Console.println(String.format("%s. %s", item.command, item.name));
            Console.println();
        });
    }

    @Test
    public void question() {
        TestMenu item = TestMenu.ITEM;
        TestMenuView testMenuView = new TestMenuView();
        this.mockConsole.when(Console::readline).thenReturn(item.command);
        assertThat(testMenuView.question()).isEqualTo(item);
    }

    @Test
    public void question_CanNotSelectedFunctionException() {
        TestMenu item = TestMenu.ITEM;
        TestMenuView testMenuView = new TestMenuView();
        String message = "선택할 수 없는 기능입니다.";
        this.mockConsole.when(Console::readline).thenReturn("none");
        this.mockConsole.when(Console::readline).thenReturn(item.command);
        testMenuView.question();
        this.mockConsole.verify(() -> {
            Console.println();
            Console.printError(message);
            Console.println();

            Console.println();
        });
    }

    @Test
    public void onEvent() {
        TestMenu item = TestMenu.ITEM;
        AtomicInteger count = new AtomicInteger(0);
        TestMenuView testMenuView = new TestMenuView(
            MenuEventManager.builder().addEventListener(item, count::getAndIncrement));
        testMenuView.onEvent(item);
        assertThat(count.get()).isEqualTo(1);
    }

    @Test
    public void onEvent__CanNotProcessEventHandlerException() {
        TestMenu item = TestMenu.ITEM;
        TestMenuView testMenuView = new TestMenuView();
        String message = "이벤트를 처리할 수 없습니다.";
        assertThatThrownBy(() -> testMenuView.onEvent(null)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
        assertThatThrownBy(() -> testMenuView.onEvent(item)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
    }

    @AfterEach
    public void init() {
        mockConsole.close();
    }
}

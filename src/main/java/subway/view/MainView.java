package subway.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static resource.TextResource.*;

public class MainView extends View {

    private static final String KEY_STATION_MANAGEMENT = "1";
    private static final String KEY_LINE_MANAGEMENT = "2";
    private static final String KEY_SECTION_MANAGEMENT = "3";
    private static final String KEY_ROUTE_MAP_PRINT = "4";

    private List<View> subViewList = new ArrayList<>();

    public interface OnBackListener {

        void onBack();
    }

    public MainView(Scanner scanner) {
        super(scanner);
        initSubView();
        initMenu();
    }

    @Override
    public void startView() {
        System.out.println(HEADER_MAIN_VIEW);
        printMenu();
        String selection = scanner.nextLine();
        try {
            doFunction(selection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            startView();
        }
    }

    private void doFunction(String selection) {
        checkKey(selection);
        if (KEY_QUIT.equals(selection)) {
            System.exit(0);
        }
        int index = Integer.parseInt(selection) - 1;
        subViewList.get(index).startView();
    }

    private void initSubView() {
        subViewList.add(new RouteShowView(scanner, onBackListener));
    }

    private void initMenu() {
        menu.put(KEY_STATION_MANAGEMENT, FUNCTION_ROUTE_SHOWING);
        menu.put(KEY_QUIT, FUNCTION_QUIT);
    }

    private OnBackListener onBackListener = new OnBackListener() {
        @Override
        public void onBack() {
            startView();
        }
    };
}

package subway.domain;

public class OutputView {

    private static final String newLine = "\n";

    public static void printMainMenu() {
        String message = "## 메인 화면" + newLine;
        for (Menu.Main menu : Menu.Main.values()) {
            message += String.format("%s. %s" + newLine, menu.getCode(), menu.getKorean() );
        }
        System.out.println(message);
    }

    public static void printCriteriaMenu() {

    }

    public static void printRouteResult() {

    }

}

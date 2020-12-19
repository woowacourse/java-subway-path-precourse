package subway.view;

public class InformationView {
    protected static final String INFO_SIGN = "[INFO] ";

    protected static void printInfo(String infoMessage) {
        System.out.println(INFO_SIGN + infoMessage);
    }
}

package subway.view;

public class OutputView {

    public void printErrorMessage(String message) {
        print(message);
    }

    public void printInformation(String information) {
        printEmptyLine();
        print(information);
    }

    private void printEmptyLine() {
        print("");
    }

    private void print(String message) {
        System.out.println(message);
    }

}

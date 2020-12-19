package subway.view.output;

public class CommonOutputView {
    public void printExceptionMessage(Exception exception) {
        System.out.println(exception.getMessage() + "\n");
    }
}

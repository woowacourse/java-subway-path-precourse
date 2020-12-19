package subway;

public class MainService {
    public static void view() {
        OutputView.printMainView();
        String answer = InputView.getAnswer();
        if (answer.equals("1")) {
            RouteSearchService.view();
            view();
        }
        if (answer.equals("B")) {
            return;
        }
        throw new IllegalArgumentException("잘못된 옵션의 입력입니다.");
    }
}

package subway.view;

import subway.view.constants.MainInputOption;

public class MainInputView {
    public static void askMainScreen() {
        for (MainInputOption option : MainInputOption.values()) {
            System.out.println(option.getMessage());
        }
    }
}

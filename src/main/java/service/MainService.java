package service;

import view.InputView;

public class MainService {
    private InputView inputView;
    private static final String QUIT = "Q";

    public MainService(InputView inputView) {
        this.inputView = inputView;
    }

    public void start() {
        String choice = inputView.inputChoice();
        if(choice.equals(QUIT)) {
            return;
        }

    }

}

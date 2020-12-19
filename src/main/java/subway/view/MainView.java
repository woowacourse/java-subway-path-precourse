package subway.view;

import subway.exception.InvalidCommandException;

public class MainView extends View {
    private static final MainView instance = new MainView();
    private static final String INQUIRE_SECTION = "1";
    private static final String APPLICATION_SHUT_DOWN = "Q";

    private MainView() {

    }

    static MainView getInstance() {
        return instance;
    }

    @Override
    void printViewGuide() {
        System.out.println("## 메인화면\n1. 경로 조회\nQ. 종료\n");
    }

    @Override
    void validationCommand(String command) {
        if (command.equals(INQUIRE_SECTION) || command.equals(APPLICATION_SHUT_DOWN)) {
            return;
        }

        throw new InvalidCommandException();
    }

    @Override
    void doCommand(String command) {
        if (command.equals(INQUIRE_SECTION)) {
            UserInterface.setView(SectionInquiryView.getInstance());
        }

        if (command.equals(APPLICATION_SHUT_DOWN)) {
            UserInterface.applicationShutDown();
        }
    }
}
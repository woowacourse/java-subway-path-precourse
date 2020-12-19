package subway.view;

import java.util.Scanner;

public class UserInterface {
    private static boolean isApplicationRunning;
    private static View displayedView;

    private final Scanner scanner;

    public UserInterface(Scanner scanner) {
        isApplicationRunning = true;
        displayedView = MainView.getInstance();

        this.scanner = scanner;
        SectionInquiryView.setScanner(scanner);
    }

    static void applicationShutDown() {
        isApplicationRunning = false;
    }

    static void setView(View view) {
        displayedView = view;
    }

    public void runApplication() {
        while (isApplicationRunning) {
            try {
                displayedView.printViewGuide();
                displayedView.printInputGuide();

                String input = scanner.nextLine();
                System.out.println();//공백추가

                displayedView.validationCommand(input);
                displayedView.doCommand(input);
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }

        displayedView.printApplicationShutDown();
    }
}
package subway.view;

import java.util.Scanner;

public class InputView {
    private static final String ASK_COMMAND_MESSAGE = "원하는 기능을 선택하세요.";
    
    private static Scanner scanner;
    
    public static void setScanner(Scanner scannerToSet) {
        scanner = scannerToSet;
    }
    
    public static String askUserCommand() {
        String userCommand;
        
        System.out.println(ViewConstants.NEW_MESSAGE_PREFIX + ASK_COMMAND_MESSAGE);
        userCommand = scanner.nextLine().trim();
        System.out.println(ViewConstants.EMPTY_LINE);
        
        return userCommand;
    }
    
    public static String askName(String message) {
        String name;
        
        System.out.println(message);
        name = scanner.nextLine().trim();
        System.out.println(ViewConstants.EMPTY_LINE);
        
        return name;
    }
}

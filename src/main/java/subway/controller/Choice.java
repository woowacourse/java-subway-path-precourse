package subway.controller;

public class Choice {
    public static final String COMMAND_ONE = "1";
    public static final String COMMAND_TWO = "2";
    public static final String COMMAND_BACK = "B";
    public static final String COMMAND_QUIT = "Q";
    public static final String COMMAND_NOT_SELECTABLE = "선택할 수 없는 기능입니다.";
    
    private static final String COMMAND_MESSAGE_DELIMETER = ". ";
    
    private final String command;
    private final String message;
    private final Runnable function;
    
    public Choice(String command, String message, Runnable function) {
        this.command = command;
        this.message = message;
        this.function = function;
    }
    
    public String toString() {
        return command + COMMAND_MESSAGE_DELIMETER + message;
    }
    
    public boolean commandEquals(String command) {
        return command.equals(this.command);
    }
    
    public void run() {
        function.run();
    }
}

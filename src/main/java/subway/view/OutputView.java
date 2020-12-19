package subway.view;

public class OutputView {
    private static final String DOUBLE_SHARP = "##";
    private static final String SPACE = " ";
    private static final String COMMA = ".";
    private static final String RESULT_START = "[INFO]";
    private static final String ERROR_START = "[ERROR]";


    public static void println() {
        System.out.println();
    }

    public static void println(String value) {
        System.out.println(value);
    }

    public static void printlnGuide(String message) {
        println();
        println(String.join(SPACE, DOUBLE_SHARP, message));
    }

    public static void printTypeList(String command, String typeName) {
        println(String.join(SPACE, command + COMMA, typeName));
    }

    public static void printlnError(String errorMessgae) {
        println();
        println(String.join(SPACE, ERROR_START, errorMessgae));
    }

    public static void printlnResult(String result) {
        println();
        println(String.join(SPACE, RESULT_START, result));
    }

    public static void printlnResult(String result1, String result2) {
        println();
        println(String.join(SPACE, RESULT_START, result1, result2));
    }
}

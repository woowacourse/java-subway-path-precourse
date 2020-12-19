package subway.view;


import static subway.controller.RouteController.sumTime;

import java.util.List;
import java.util.Scanner;
import subway.functionList.Function;
import subway.message.Message;
import subway.message.PrefixMessage;
import subway.message.RouteMessage;
import subway.screen.Screen;

public class UserView {

    private static Scanner scanner;


    public static void defaultScanner(Scanner defaultScanner) {
        scanner = defaultScanner;
    }

    public static void spaceLine() {
        System.out.println();
    }

    public static void displayScreen(Screen screen) {
        guideMessagePrint(screen.getTitle());
        printEnableFunctionList(screen.getFunctions());
    }

    public static void printEnableFunctionList(List<Function> functions) {
        for (Function function : functions) {
            printFunction(function);
        }
        spaceLine();
    }

    private static void printFunction(Function function) {
        String assembledString = String.format(PrefixMessage.FUNCTION_FORMAT.getMessage()
            , function.getCode()
            , function.getTitle());
        System.out.println(assembledString);
    }

    public static void guideMessagePrint(String message) {
        String printedMessage = String.format(PrefixMessage.NOTICE_FORMAT.getMessage(), message);
        System.out.println(printedMessage);
    }

    public static void guideMessagePrint(Message message) {
        String printedMessage = String
            .format(PrefixMessage.NOTICE_FORMAT.getMessage(), message.getMessage());
        System.out.println(printedMessage);
    }

    public static String scanUserInput() {
        String userInput = scanner.nextLine();
        spaceLine();
        return userInput;
    }

    public static void errorDirectPrint(IllegalArgumentException error) {
        String errorMessage = String
            .format(PrefixMessage.ERROR_FORMAT.getMessage(), error.getMessage());
        System.out.println(errorMessage);
        spaceLine();
    }

    public static void info(Message message) {
        String assembledString = String
            .format(PrefixMessage.INFO_FORMAT.getMessage(), message.getMessage());
        System.out.println(assembledString);

    }

    public static void info(String message) {
        String assembledString = String
            .format(PrefixMessage.INFO_FORMAT.getMessage(), message);
        System.out.println(assembledString);

    }

    public static void printDistanceResult(List<String> pathList, int weight) {
        guideMessagePrint(RouteMessage.RESULT);
        info(RouteMessage.LINE);

        String distanceString = String.format(PrefixMessage.KILOMETER_FORMAT.getMessage(),weight);
        info(distanceString);

        //구현 실패
        //String timeString = String.format(PrefixMessage.TIME_FORMAT.getMessage(),sumTime(pathList));
        //info(timeString);

        info(RouteMessage.LINE);
        for(String path:pathList){
            info(path);
        }
    }

    public static void printTimeResult(List<String> pathList, int weight) {
        guideMessagePrint(RouteMessage.RESULT);
        info(RouteMessage.LINE);

        String distanceString = String.format(PrefixMessage.TIME_FORMAT.getMessage(),weight);
        info(distanceString);
        //구현 실패
        //String timeString = String.format(PrefixMessage.TIME_FORMAT.getMessage(),sumTime(pathList));
        //info(timeString);
        info(RouteMessage.LINE);
        for(String path:pathList){
            info(path);
        }
        info(RouteMessage.LINE);
    }
}

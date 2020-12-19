package subway;

import exception.NoneFunctionException;
import inputview.InputView;
import outputview.FindView;
import outputview.FunctionView;
import outputview.MainView;

import java.util.Scanner;

public class SubwayPathFinder {
    private final static String[] BUTTONS = {"1", "Q"};
    private InputView inputView;
    private boolean reTry = true;

    public void run(Scanner scanner) {
        new DefaultData();
        inputView = new InputView(scanner);
        runMain();
    }

    private void runMain() {
        while (reTry) {
            MainView.printMain();
            handleMainException();
        }
    }

    private void handleMainException() {
        while (true) {
            try {
                FunctionView.printFunctionSelect();
                selectFunction(inputView.selectFunction());
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private void selectFunction(String selection) {
        if (selection.equals(BUTTONS[0])) {
            runFindPath();
        }
        if (selection.equals(BUTTONS[1])) {
            reTry = false;
        }
        if (!selection.equals(BUTTONS[0]) && !selection.equals(BUTTONS[1])) {
            throw new NoneFunctionException();
        }
    }

    private void runFindPath() {
        FindView.printFindMenu();
        FunctionView.printFunctionSelect();
        handleFindPathException();
    }

    private void handleFindPathException() {
        while (true) {
            try {
                FindPathService findPathService = new FindPathService(inputView);
                findPathService.runService();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

package subway;

import exception.NoneFunctionException;
import inputview.InputView;
import outputview.FindView;
import outputview.FunctionView;
import outputview.MainView;

import java.util.Scanner;

public class SubwayPathFinder {
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
        if (selection.equals("1")) {
            runFindPath();
        }
        if (selection.equals("Q")) {
            reTry = false;
        }
        if (!selection.equals("1") && !selection.equals("Q")) {
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

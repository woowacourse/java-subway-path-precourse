package subway;

import inputview.InputView;
import outputview.MainView;

import java.util.Scanner;

public class SubwayPathFinder {
    private InputView inputView;
    private boolean reTry = true;

    public void run(Scanner scanner){
        inputView = new InputView(scanner);
        runMain();
    }

    private void runMain(){
        while(reTry) {
            MainView.printMain();
            MainView.printFunctionSelect();
            handleMainException();
        }
    }

    private void handleMainException(){ // try catch 사용
        selectFunction(inputView.selectFunction());
    }

    private void selectFunction(String selection){
        if(selection.equals("1")){

        }
        if(selection.equals("Q")){
            reTry = false;
        }
        if(!selection.equals("1") && !selection.equals("Q")){
            throw new IllegalArgumentException(); //
        }
    }
}

package subway;

import subway.view.Input;
import subway.view.Output;

import java.util.Scanner;

public class Controller {
    private Scanner scanner;
    private static Output output;
    private static Input input;

    public Controller(Scanner scanner){
        this.scanner = scanner;
        output = new Output();
        input = new Input(scanner);
    }

    public static void run(){
        String flag = "";
        do{
            output.printMainFunction();
            flag = input.getMainFunction();
        }while(!flag.equals("Q"));
    }
}

package subway.view;

import java.util.Scanner;

public class InputView {
    private static final int ERROR = -1;
    private static final String QUIT = "Q";
    private static final String BACK = "B";
    private static final int QUIT_NUMBER = 0;
    private static final String INPUT_OPERATION_NUMBER = "## 원하는 기능을 선택하세요.";
    private static final String WRITE_NUMBER = "[ERROR] 화면에 나온 입력값을 입력하세요.\n";

    public static void print(String string){
        System.out.println(string);
    }

    public static int inputOperationNumber(Scanner scanner,int start, int end){
        print(INPUT_OPERATION_NUMBER);
        String tempNumber = scanner.next();
        if(tempNumber.equals(QUIT) || tempNumber.equals(BACK)){
            return QUIT_NUMBER;
        }
        if(!tempNumber.chars().allMatch(Character::isDigit)){
            print(WRITE_NUMBER);
            return ERROR;
        }
        int operationNumber = Integer.parseInt(tempNumber);
        if(operationNumber < start || operationNumber > end){
            print(WRITE_NUMBER);
            return ERROR;
        }
        return 1;
    }
}

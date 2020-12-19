package subway.view.screen;

import subway.view.InputView;

import java.util.Stack;

public class ScreenManager {
    private static final Stack<Screen> stack=new Stack<>();

    public static void push(Screen screen){
        stack.push(screen);
    }

    public static void back(){
        stack.pop();
    }

    public static Screen peek(){
        return stack.peek();
    }

    public static void show(){
        peek().show();
    }

    public static void menuSelect(InputView inputView){
        peek().menuSelect(inputView);
    }

    public static void clear(){
        stack.clear();
    }

    public static void goToFirstScreen(){
        while(stack.size()>1){
            back();
        }
    }

    public static boolean isEmpty(){
        return stack.isEmpty();
    }
}

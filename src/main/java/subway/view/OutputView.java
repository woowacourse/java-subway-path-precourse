package subway.view;

import java.util.List;

public class OutputView {
    private static final String INFO="[INFO] ";
    private static final String ERROR="[ERROR] ";
    private static final String COMA=". ";

    public static void println(){
        System.out.println();
    }

    public static void println(String text){
        System.out.println(text);
    }

    public static void printInfo(String text){
        System.out.println(INFO+text);
    }

    public static void printInfo(int text){
        System.out.print(INFO+text);
    }

    public static void printError(String text){
        System.out.println();
        System.out.println(ERROR+text);
    }

    public static void menuPrint(List<ActionType> types){
        for(int i=0;i<types.size();i++){
            println(i+COMA+types.get(i).name());
        }
    }
}

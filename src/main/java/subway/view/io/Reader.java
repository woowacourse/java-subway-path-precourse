package subway.view.io;

import java.util.Scanner;

public class Reader {
    private final Scanner scanner;
    public Reader(Scanner scanner){
        this.scanner = scanner;
    }

    public String getString(){
        return scanner.nextLine();
    }
}

package subway;

import java.util.Scanner;
import subway.view.MainDisplay;

public class SubwayPath {

    private SubwayPath(){
    }

    public static SubwayPath newSubwayPath() {
        return new SubwayPath();
    }

    public void start() {
        MainDisplay.loadMenu();
    }
}

package subway.controller;

import subway.exception.SubwayException;

public class MainController {
    public static void viewRoute(){
        try{

        }
        catch (SubwayException error){
            System.out.println(error.getMessage());
            viewRoute();
        }
    }

    public static void exit(){
        System.exit(0);
    }
}

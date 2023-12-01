package subway.controller;

import subway.service.SubwayService;
import subway.util.message.InputMessage;
import subway.util.message.Menu;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubwayController {
    private final SubwayService subwayService;
    private final List<String> main = new ArrayList<>(List.of(Menu.SELECT_ROUTINE.getKey(), Menu.EXIT.getKey()));
    private final List<String> routine = new ArrayList<>(List.of(Menu.SHORTEST_DISTANCE.getKey(), Menu.SHORTEST_TIME.getKey(), Menu.BACK.getKey()));
    public SubwayController(){
        subwayService = new SubwayService();
    }

    public void initSubway(){
        subwayService.initSubway();
    }

    public void start(){
        try{
            if(questionIsproceed()){
                questionRoutine();
            };
        } catch(IllegalArgumentException e){
            OutputView.printMessage(e.getMessage());
            start();
        }
    }

    private boolean questionIsproceed(){
        OutputView.printMain();
        String input = InputView.inputKey(main);
        return confirmProceed(input);
    }

    private boolean confirmProceed(final String input){
        if(input.equals(Menu.EXIT.getKey())){
            return false;
        }
        return input.equals(Menu.SELECT_ROUTINE.getKey());
    }

    private void questionRoutine(){
        OutputView.printRoutine();
        String input = InputView.inputKey(routine);
        questionMainNext(input);
    }

    private void questionMainNext(final String input){
        if(input.equals(Menu.SHORTEST_DISTANCE.getKey())){
            getShortestDistance();
        }
        if(input.equals(Menu.SHORTEST_TIME.getKey())){
            //getShortestTime();
        }
        if(input.equals(Menu.BACK.getKey())){
            questionRoutine();
        }
    }

    private void getShortestDistance(){
        String startStationInfo = InputView.inputStation(InputMessage.GET_START_STATION.getValue());
        String endStationInfo = InputView.inputStation(InputMessage.GET_END_STARTION.getValue());
        subwayService.getShortestDistance(startStationInfo, endStationInfo);
    }
}

package subway.controller;

import subway.service.GraphService;
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
    private final GraphService graphService;
    private final List<String> main = new ArrayList<>(List.of(Menu.SELECT_ROUTINE.getKey(), Menu.EXIT.getKey()));
    private final List<String> routine = new ArrayList<>(List.of(Menu.SHORTEST_DISTANCE.getKey(), Menu.SHORTEST_TIME.getKey(), Menu.BACK.getKey()));

    private int totalDistance;
    private int totalTime;
    private List<String> path;
    public SubwayController(){
        subwayService = new SubwayService();
        graphService = new GraphService();
    }

    public void initSubway(){
        subwayService.initSubway();
    }

    public void start(){
        while(questionIsproceed()){
            try{
                questionRoutine();
            } catch(IllegalArgumentException e){
                OutputView.printMessage(e.getMessage());
                questionRoutine();
            }
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
        if(input.equals(Menu.BACK.getKey())){
            questionRoutine();
        }
        List<Integer> totalInfo = new ArrayList<>();
        if(input.equals(Menu.SHORTEST_DISTANCE.getKey())){
            totalInfo = getShortestDistance();
        }
        if(input.equals(Menu.SHORTEST_TIME.getKey())){
            totalInfo = getShortestTime();
        }
        savetotalInfo(totalInfo);
        OutputView.printResult(path, totalDistance, totalTime);
    }

    private List<Integer> getShortestDistance(){
        String startStationInfo = InputView.inputStation(InputMessage.GET_START_STATION.getValue());
        String endStationInfo = InputView.inputStation(InputMessage.GET_END_STARTION.getValue());
        path = graphService.getShortestDistancePath(startStationInfo, endStationInfo);
        return graphService.getTotalShortestDistanceAndShortestTime(path);
    }

    private List<Integer> getShortestTime(){
        String startStationInfo = InputView.inputStation(InputMessage.GET_START_STATION.getValue());
        String endStationInfo = InputView.inputStation(InputMessage.GET_END_STARTION.getValue());
        path = graphService.getShortestTimePath(startStationInfo, endStationInfo);
        return graphService.getTotalShortestDistanceAndShortestTime(path);
    }

    private void savetotalInfo(final List<Integer> totalInfo){
        totalDistance = totalInfo.get(0);
        totalTime = totalInfo.get(1);
    }
}

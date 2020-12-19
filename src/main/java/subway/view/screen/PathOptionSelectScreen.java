package subway.view.screen;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.util.Dijkstra;
import subway.util.SubwayMachine;
import subway.view.ActionType;
import subway.view.InputView;
import subway.view.MenuType;
import subway.view.OutputView;

import java.util.Arrays;

public class PathOptionSelectScreen implements Screen {
    private static final String TILE="## 경로 기준";
    private static final String FIND_RESULT="## 조회 결과";
    private static final String SELECT_TYPE="## 원하는 기능을 선택하세요.";
    private static final String INPUT_START_STATION="## 출발역을 입력하세요.";
    private static final String INPUT_ARRIVE_STATION="## 도착역을 입력하세요.";
    private static final String INPUT_DUPLICATE_STATION="출발역과 도착역이 동일합니다.";
    private static final String COMA=". ";
    private static final String ERROR_MESSAGE="잘못된 입력입니다.";
    private Dijkstra dijkstra;

    public PathOptionSelectScreen(){
        dijkstra=Dijkstra.getInstance();
    }

    @Override
    public void show() {
        OutputView.println(TILE);
        Arrays.stream(ActionType.values()).forEach(menuType -> {
            OutputView.println(menuType.getKey()+COMA+menuType.getName());
        });

        OutputView.println();
    }

    @Override
    public void menuSelect(InputView inputView) {
        String menuType=getMenuInput(inputView);
        if(menuType.equals(ActionType.BACK.getKey())){
            ScreenManager.back();
            return;
        }
        String from=getStartStation(inputView);
        String to=getArriveStation(inputView);
        if(isDuplicateStations(from,to)){
            return;
        }
        OutputView.println(FIND_RESULT);
        getResult(menuType,from,to);
        OutputView.println();
    }

    private String getMenuInput(InputView inputView){
        OutputView.println(SELECT_TYPE);
        while(true){
            String input=inputView.inputRequest();
            if(ActionType.isValidInput(input)){
                OutputView.println();
                return input;
            }
            OutputView.printError(ERROR_MESSAGE);
        }
    }

    private String getStartStation(InputView inputView){
        while(true){
            OutputView.println(INPUT_START_STATION);
            String input=inputView.inputRequest();
            if(StationRepository.isExistByName(input)){
                OutputView.println();
                return input;
            }
            OutputView.printError(ERROR_MESSAGE);
        }
    }

    private String getArriveStation(InputView inputView){
        while(true){
            OutputView.println(INPUT_ARRIVE_STATION);
            String input=inputView.inputRequest();
            if(StationRepository.isExistByName(input)){
                OutputView.println();
                return input;
            }
            System.out.println();
            OutputView.printError(ERROR_MESSAGE);
        }
    }

    private boolean isDuplicateStations(String from,String to){
        boolean result=from.equals(to);
        if(result){
            OutputView.printError(INPUT_DUPLICATE_STATION);
        }
        return result;
    }

    public void getResult(String type,String from,String to){
        if(type.equals(ActionType.SHORTEST_PATH.getKey())){
            dijkstra.getShortestPathResult(from,to);
            return;
        }

        if(type.equals(ActionType.MINIMUM_TIME.getKey())){
            dijkstra.getShortestTimeResult(from,to);
            return;
        }
    }
}

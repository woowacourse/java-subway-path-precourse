package subway.controller;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import subway.domain.*;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;
import java.util.Objects;

import static subway.domain.InitSetting.initSetting;

public class SubwayController {
    public void run(InputView inputView) {
        initSetting();

        while(true) {
            OutputView.printMain();
            if (MainAction.isFinish(inputView.receiveAction())) {
                break;
            }

            OutputView.printPathAction();
            if (PathAction.isBack(inputView.receiveAction())) {
                break;
            }

            Station startStation = StationRepository.findStationByName(inputView.receiveStart());
            Station finishStation = StationRepository.findStationByName(inputView.receiveFinish());

            DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(SubwayPathRepository.subwayPath());


            makeShortestTimeReport(startStation, finishStation);
        }
    }

    private void makeShortestTimeReport(Station startStation, Station finishStation) {
        DijkstraShortestPath dijkstraShortestTime = new DijkstraShortestPath(SubwayTimeRepository.subwayTime());
        GraphPath paths = dijkstraShortestTime.getPath(startStation, finishStation);
        List<Station> stations = paths.getVertexList();
        int totalPath = 0;
        for(int i =0;i<stations.size()-1;i++){
            int dfs = SubwayPathRepository.getEdgeWeightWithTwoStations(stations.get(i), stations.get(i+1));
            totalPath+=dfs;
        }
        System.out.println("총 거리: "+totalPath);
        System.out.println("총 소요 시간: "+paths.getWeight());
        for(Station station: stations){
            System.out.println(station.getName());
        }
    }
}

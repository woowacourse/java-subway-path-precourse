package subway.Controller;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import subway.View.OutputView;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ComputeShortValue {
    private static List<Line> allLine=LineRepository.lines();
    List<String> checkDuplicatedStation=new ArrayList<String>();
    LineRepository lineRepository=new LineRepository();
    WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph = new WeightedMultigraph(DefaultWeightedEdge.class);
    WeightedMultigraph<String, DefaultWeightedEdge> timeGraph = new WeightedMultigraph(DefaultWeightedEdge.class);

    public void setDistanceGraph(String start,String end) {


        setAllLine(distanceGraph);
        setDistanceEdge(distanceGraph);
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(distanceGraph);
        List<String> shortestPath = dijkstraShortestPath.getPath(start, end).getVertexList();

        OutputView outputView =new OutputView();
        outputView.printStation(shortestPath);

    }
    public void setTimeGraph(String start,String end) {
        setAllLine(timeGraph);
        setTimeEdge(timeGraph);
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(distanceGraph);
        List<String> shortestPath = dijkstraShortestPath.getPath(start, end).getVertexList();

        OutputView outputView =new OutputView();
        outputView.printStation(shortestPath);
    }
    public void setDistanceEdge(WeightedMultigraph<String, DefaultWeightedEdge> tmpGraph) {

        for(int i=0;i<allLine.size();i++) {
            Line tmpSaveLine=allLine.get(i);
            for (int j = 0; j < tmpSaveLine.getLineStation().size()-1; j++) {

                tmpGraph.setEdgeWeight(tmpGraph.addEdge(tmpSaveLine.getLineStation().get(j).getName(),tmpSaveLine.getLineStation().get(j+1).getName()),lineRepository.getLine(tmpSaveLine.getName()).getDistance(tmpSaveLine.getLineStation().get(j),tmpSaveLine.getLineStation().get(j+1)));

            }
        }
    }
    public void setTimeEdge(WeightedMultigraph<String, DefaultWeightedEdge> tmpGraph) {

        for(int i=0;i<allLine.size();i++) {
            Line tmpSaveLine=allLine.get(i);
            for (int j = 0; j < tmpSaveLine.getLineStation().size()-1; j++) {

                tmpGraph.setEdgeWeight(tmpGraph.addEdge(tmpSaveLine.getLineStation().get(j).getName(),tmpSaveLine.getLineStation().get(j+1).getName()),lineRepository.getLine(tmpSaveLine.getName()).getDistance(tmpSaveLine.getLineStation().get(j),tmpSaveLine.getLineStation().get(j+1)));

            }
        }
    }
    public void setAllLine(WeightedMultigraph<String, DefaultWeightedEdge> tmpGraph) {

        for(int i=0;i<allLine.size();i++) {

            Line tmpSaveLine=allLine.get(i);
            for(int j=0;j<tmpSaveLine.getLineStation().size();j++) {
                setCheckDuplicatedStation(allLine.get(i).getLineStation().get(j),tmpGraph);
            }
        }
    }
    public void setCheckDuplicatedStation(Station tmpSaveStation,WeightedMultigraph<String, DefaultWeightedEdge> tmpGraph) {
        if(!checkDuplicatedStation.contains(tmpSaveStation.getName())){
            checkDuplicatedStation.add(tmpSaveStation.getName());

            tmpGraph.addVertex(tmpSaveStation.getName());
        }
    }

}

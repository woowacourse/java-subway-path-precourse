package subway.Controller;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ComputeShortValue {
    private static List<Line> allLine=LineRepository.lines();
    List<String> checkDuplicatedStation=new ArrayList<String>();

    WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
    public void setGraph() {


        setAllLine();
        System.out.println("1");
        setEdge();
        System.out.println("2");
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        List<String> shortestPath = dijkstraShortestPath.getPath("교대역", "양재역").getVertexList();

        for (String string : shortestPath) {
            System.out.println(string);
        }

    }
    public void setEdge() {
        System.out.println("setedge");
        for(int i=0;i<allLine.size();i++) {
            Line tmpSaveLine=allLine.get(i);
            for (int j = 0; j < tmpSaveLine.getLineStation().size()-1; j++) {

                graph.setEdgeWeight(graph.addEdge(tmpSaveLine.getLineStation().get(j).getName(),tmpSaveLine.getLineStation().get(j+1).getName()),tmpSaveLine.getDistance(tmpSaveLine.getLineStation().get(j),tmpSaveLine.getLineStation().get(j+1)));
                System.out.println("이부분 오작동");
            }
        }
    }
    public void setAllLine() {
        System.out.println("setaa");
        for(int i=0;i<allLine.size();i++) {
            System.out.println("33333");
            Line tmpSaveLine=allLine.get(i);
            for(int j=0;j<tmpSaveLine.getLineStation().size();j++) {
                setCheckDuplicatedStation(allLine.get(i).getLineStation().get(j));
            }
        }
    }
    public void setCheckDuplicatedStation(Station tmpSaveStation) {
        if(!checkDuplicatedStation.contains(tmpSaveStation.getName())){
            checkDuplicatedStation.add(tmpSaveStation.getName());
            System.out.println("입력잘됩니다"+tmpSaveStation.getName());
            graph.addVertex(tmpSaveStation.getName());
        }
    }

}

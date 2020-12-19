package subway.Controller;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;

import java.util.Arrays;
import java.util.List;

public class ComputeShortValue {
    List<Line> allLine=LineRepository.lines();
    List<String> checkDuplicatedStation= Arrays.asList();

    WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
    public void setGraph() {

    }
    public void setEdge() {
        for(int i=0;i<allLine.size();i++) {
            Line tmpSaveLine=allLine.get(i);
            for (int j = 0; j < tmpSaveLine.getLineStation().size()-1; j++) {
                
            }
        }
    }
    public void setAllLine() {
        for(int i=0;i<allLine.size();i++) {
            for(int j=0;j<allLine.get(i).getLineStation().size();j++) {
                setCheckDuplicatedStation(allLine.get(i).getLineStation().get(j));
            }
        }
    }
    public void setCheckDuplicatedStation(Station tmpSaveStation) {
        if(!checkDuplicatedStation.contains(tmpSaveStation.getName())){
            graph.addVertex(tmpSaveStation.getName());
        }
    }

}

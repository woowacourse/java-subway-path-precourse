package subway.util;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.StationEdgeRepository;
import subway.view.OutputView;

import java.util.List;

public class Dijkstra {
    private static final WeightedMultigraph<String,DefaultWeightedEdge> distanceGraph=new WeightedMultigraph(DefaultWeightedEdge.class);
    private static final WeightedMultigraph<String,DefaultWeightedEdge> timeGraph=new WeightedMultigraph(DefaultWeightedEdge.class);
    private static final String SPLIT="---";
    private static final String TOTAL_DISTANCE="총 거리: ";
    private static final String TOTAL_TIME="총 소요 시간: ";
    private static final String KILOMETER="km";
    private static final String MINUTES="분";
    private static Dijkstra dijkstra;
    private DijkstraShortestPath dijkstraShortestPath;

    private Dijkstra(){}

    public static Dijkstra getInstance(){
        if(dijkstra==null){
            dijkstra=new Dijkstra();
        }
        return dijkstra;
    }

    public void addVertex(String v){
        distanceGraph.addVertex(v);
        timeGraph.addVertex(v);
    }

    public void setEdgeDistanceWeight(String from,String to,double weight){
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(from,to),weight);
    }

    public void setEdgeTimeWeight(String from,String to,double weight){
        timeGraph.setEdgeWeight(timeGraph.addEdge(from,to),weight);
    }

    public void getShortestPathResult(String from,String to){
        dijkstraShortestPath=new DijkstraShortestPath(distanceGraph);
        OutputView.printInfo(SPLIT);
        OutputView.printInfo(TOTAL_DISTANCE+getShortestPath(from,to)+KILOMETER);
        OutputView.printInfo(TOTAL_TIME+getTimeInterval(from,to)+MINUTES);
        OutputView.printInfo(SPLIT);
        getStationList(from,to).forEach(OutputView::printInfo);
    }

    public void getShortestTimeResult(String from,String to){
        dijkstraShortestPath=new DijkstraShortestPath(timeGraph);
        OutputView.printInfo(SPLIT);
        OutputView.printInfo(TOTAL_DISTANCE+getDistanceInterval(from,to)+KILOMETER);
        OutputView.printInfo(TOTAL_TIME+getShortestTime(from,to)+MINUTES);
        OutputView.printInfo(SPLIT);
        getStationList(from,to).forEach(OutputView::printInfo);
    }

    public int getShortestPath(String from,String to){
        return (int)dijkstraShortestPath.getPath(from,to).getWeight();
    }

    public int getShortestTime(String from,String to){
        return (int)dijkstraShortestPath.getPath(from,to).getWeight();
    }

    public int getDistanceInterval(String from,String to){
        List<String> list=getStationList(from,to);
        int sum=0;
        for(int i=0;i<list.size();i++){
            if(i+1<list.size()){
                sum+=StationEdgeRepository.getDistanceInterval(list.get(i),list.get(i+1));
            }
        }
        return sum;
    }

    public int getTimeInterval(String from,String to){
        List<String> list=getStationList(from,to);
        int sum=0;
        for(int i=0;i<list.size();i++){
            try{
                if(i+1<list.size()){
                    sum+=StationEdgeRepository.getTimeInterval(list.get(i),list.get(i+1));
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return sum;
    }

    public List<String> getStationList(String from,String to){
        return dijkstraShortestPath.getPath(from,to).getVertexList();
    }


}

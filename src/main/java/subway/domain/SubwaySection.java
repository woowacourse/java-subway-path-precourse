package subway.domain;

import java.util.List;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class SubwaySection {
	private static final WeightedMultigraph<String, DefaultWeightedEdge> timeGraph = new WeightedMultigraph(DefaultWeightedEdge.class);
	private static final WeightedMultigraph<String, DefaultWeightedEdge> lengthGraph = new WeightedMultigraph(DefaultWeightedEdge.class);
	
	private static final String ERROR_INPUT_MESSAGE = "[ERROR] 잘못된 입력값 입니다.\n";
	
    public static void addSection(String station) {
    	timeGraph.addVertex(station);
    	lengthGraph.addVertex(station);
    }
    public void sectionTime(String startStation, String endStation, int time)
    {
    	if(timeGraph.containsVertex(startStation) && timeGraph.containsVertex(endStation))
    	{
    		timeGraph.setEdgeWeight(timeGraph.addEdge(startStation, endStation), time);
    		return;
    	}
    	System.out.println(ERROR_INPUT_MESSAGE);
    }
    public void sectionLength(String startStation, String endStation, int time)
    {
    	if(lengthGraph.containsVertex(startStation) && lengthGraph.containsVertex(endStation))
    	{
    		lengthGraph.setEdgeWeight(lengthGraph.addEdge(startStation, endStation), time);
    		return;
    	}
    	System.out.println(ERROR_INPUT_MESSAGE);
    }
    
    public void minTimeSection(String startStation, String endStation)
    {
    	DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(timeGraph);
    	List<String> shortestPath = dijkstraShortestPath.getPath(startStation, endStation).getVertexList();
    	System.out.println("[INFO] ---");
    	for(int i=0;i<shortestPath.size();i++)
    	{
    		
    		System.out.println("[INFO] " + shortestPath.get(i));
    	}
    	System.out.println();
    }
    public void minLengthSection(String startStation, String endStation)
    {
    	DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(lengthGraph);
    	List<String> shortestPath = dijkstraShortestPath.getPath(startStation, endStation).getVertexList();
    	System.out.println("[INFO] ---");
    	for(int i=0;i<shortestPath.size();i++)
    	{
    		System.out.println("[INFO] " + shortestPath.get(i));
    	}
    	System.out.println();
    }
}

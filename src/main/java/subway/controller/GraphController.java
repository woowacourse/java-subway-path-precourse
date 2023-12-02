package subway.controller;

import subway.service.GraphService;

public class GraphController {
    private final GraphService graphService;

    public GraphController(){
        graphService = new GraphService();
    }

    public void initGraph(){
        graphService.initGraph();
    }

}

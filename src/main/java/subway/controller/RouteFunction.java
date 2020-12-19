package subway.controller;

import subway.view.output.RouteOutputView;

public class RouteFunction {
    RouteOutputView routeOutputView;

    public RouteFunction(RouteOutputView routeOutputView) {
        this.routeOutputView = routeOutputView;
    }

    public void shortestDistance() {
        System.out.println("최단 거리\n");
    }

    public void shortestTime() {
        System.out.println("최단 시간\n");
    }
}

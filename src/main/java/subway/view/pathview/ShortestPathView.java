package subway.view.pathview;

public class ShortestPathView extends SearchPathView {

    @Override
    protected void requestSearchPath(String startStation, String endStation) {
        /** TODO: 최단 거리 기능 요청 */
    }

    @Override
    public String getName() {
        return "최단 거리";
    }
}

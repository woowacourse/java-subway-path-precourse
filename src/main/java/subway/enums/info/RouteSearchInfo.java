package subway.enums.info;

public enum RouteSearchInfo {
    INPUT_DEPARTURE("## 출발역을 입력하세요."),
    INPUT_ARRIVAL("## 도착역을 입력하세요.");

    String info = "";

    RouteSearchInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}

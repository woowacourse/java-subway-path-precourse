package subway.domain;

import subway.domain.weight.WeightType;

public class SearchPathQuery {
    private WeightType weightType;
    private String startStation;
    private String endStation;

    public SearchPathQuery(WeightType weightType, String startStation, String endStation) {
        this.weightType = weightType;
        this.startStation = startStation;
        this.endStation = endStation;
    }
}

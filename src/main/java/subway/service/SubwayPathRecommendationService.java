package subway.service;

import subway.config.AppConfig;

public class SubwayPathRecommendationService {
    private final AppConfig appConfig;

    public SubwayPathRecommendationService(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    public void setStationsBy(String standardCode) {
        switch (standardCode) {
            case "1":
                appConfig.setStationDistances();
                break;
        }
    }

    public void recommend(String standardCode) {

    }
}

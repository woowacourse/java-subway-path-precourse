package subway.controller;

import subway.domain.SubwayPath;

import java.util.Arrays;
import java.util.List;

public enum InitialPath {
    LINE_NUMBER_2("2호선",
            Arrays.asList(
                    new SubwayPath("교대역", "강남역", 2, 3),
                    new SubwayPath("강남역", "역삼역", 2, 3))
    ),
    LINE_NUMBER_3("3호선",
            Arrays.asList(
                    new SubwayPath("교대역", "남부터미널역", 3, 2),
                    new SubwayPath("남부터미널역", "양재역", 6, 5),
                    new SubwayPath("양재역", "매봉역", 1, 1))
    ),
    SHINBUNDANG_LINE("신분당선",
            Arrays.asList(
                    new SubwayPath("강남역", "양재역", 2, 8),
                    new SubwayPath("양재역", "양재시민의숲역", 10, 3))
    );

    private String linName;
    private List<SubwayPath> subwayPaths;

    InitialPath(String lineName, List<SubwayPath> subwayPaths) {
        this.linName = lineName;
        this.subwayPaths = subwayPaths;
    }

    public String getLinName() {
        return linName;
    }

    public List<SubwayPath> getPaths() {
        return subwayPaths;
    }
}

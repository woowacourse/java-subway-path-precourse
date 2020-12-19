package subway;

import subway.controller.PathController;
import subway.domain.entity.Station;
import subway.domain.repository.StationRepository;
import subway.dto.LineDto;
import subway.dto.SectionDto;

import java.util.Arrays;
import java.util.List;

public class SubwayMapPathInitializer {
    private static final List<String> DEFAULT_STATION_NAMES =
            Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
    private static final List<LineDto> DEFAULT_LINE_DTOS =
            Arrays.asList(new LineDto("2호선", "교대역", "강남역"),
                    new LineDto("3호선", "교대역", "남부터미널역"),
                    new LineDto("신분당선", "강남역", "양재역"));
    private static final List<SectionDto> DEFAULT_SECTION_DTOS =
            Arrays.asList(new SectionDto(2, 3),
                    new SectionDto(3, 2),
                    new SectionDto(2, 8));
    private static final List<LineDto> ADDITIONAL_LINE_DTOS =
            Arrays.asList(new LineDto("2호선", "역삼역"),
                    new LineDto("3호선", "양재역"),
                    new LineDto("3호선", "매봉역"),
                    new LineDto("신분당선", "양재시민의숲역"));
    private static final List<SectionDto> ADDITIONAL_SECTION_DTOS =
            Arrays.asList(new SectionDto(2, 3),
                    new SectionDto(6, 5),
                    new SectionDto(1, 1),
                    new SectionDto(10, 3));
    private static final int ZERO_INDEX = 0;

    private SubwayMapPathInitializer() {
    }

    public static void loadDefaultData(PathController pathController) {
        loadDefaultStations();
        loadDefaultLines(pathController);
        addStationsAtDefaultLines(pathController);
    }

    private static void loadDefaultStations() {
        DEFAULT_STATION_NAMES.forEach(stationName -> StationRepository.addStation(new Station(stationName)));
    }

    private static void loadDefaultLines(PathController pathController) {
        int lineCounts = DEFAULT_LINE_DTOS.size();
        for (int i = ZERO_INDEX; i < lineCounts; i++) {
            LineDto lineDto = DEFAULT_LINE_DTOS.get(i);
            SectionDto sectionDto = DEFAULT_SECTION_DTOS.get(i);
            pathController.addLine(lineDto, sectionDto);
        }
    }

    private static void addStationsAtDefaultLines(PathController pathController) {
        int lineCounts = ADDITIONAL_LINE_DTOS.size();
        for (int i = ZERO_INDEX; i < lineCounts; i++) {
            LineDto lineDto = ADDITIONAL_LINE_DTOS.get(i);
            SectionDto sectionDto = ADDITIONAL_SECTION_DTOS.get(i);
            pathController.addStationAtLine(lineDto, sectionDto);
        }
    }
}

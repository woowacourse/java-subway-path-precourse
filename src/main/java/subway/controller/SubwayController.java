package subway.controller;

import subway.domain.Line.Line;
import subway.domain.Line.LineRepository;
import subway.domain.section.DistanceAndTime;
import subway.domain.section.SectionWithDistanceRepository;
import subway.domain.section.SectionWithTimeRepository;
import subway.domain.section.SectionsAndDistance;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.service.LineService;
import subway.service.SectionService;
import subway.service.StationService;

import java.awt.datatransfer.ClipboardOwner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SubwayController {
    private LineService lineService;
    private StationService stationService;
    SectionService sectionService;

    public SubwayController(LineService lineService, StationService stationService,
                            SectionService sectionService) {
        this.lineService = lineService;
        this.stationService = stationService;
        this.sectionService = sectionService;
    }

    public void run() {
        initialize();
        SectionsAndDistance a =  sectionService.findShortestDistancePathByName("교대역", "양재역");
        System.out.println(a);
    }

    private void initialize() {
        addStations();
        addLines();
    }

    private void addStations() {
        String[] stations = {
                "교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"
        };

        Arrays.stream(stations)
                .forEach(station -> stationService.add(new Station(station)));
    }

    private void addLines() {
        lineService.add("2호선", get2LineSections(),get2LineDistanceAndTime());
        lineService.add("3호선", get3LineSections(),get3LineDistanceAndTime());
        lineService.add("신분당선", getShinLineSections(),getShinLineDistanceAndTime());
    }

    private List<Station> get2LineSections() {
        String[] stations = new String[]{
                "교대역", "강남역", "역삼역"
        };
        return Arrays.stream(stations)
                .map(Station::new)
                .collect(Collectors.toList());
    }

    private List<Station> get3LineSections() {
        String[] stations = new String[]{
                "교대역", "남부터미널역", "양재역", "매봉역"
        };
        return Arrays.stream(stations)
                .map(Station::new)
                .collect(Collectors.toList());
    }

    private List<DistanceAndTime> get2LineDistanceAndTime() {
        return new ArrayList<>() {
            {
                add(new DistanceAndTime(2, 3));
                add(new DistanceAndTime(2, 3));
            }
        };
    }

    private List<DistanceAndTime> get3LineDistanceAndTime() {
        return new ArrayList<>() {
            {
                add(new DistanceAndTime(3, 2));
                add(new DistanceAndTime(6, 5));
                add(new DistanceAndTime(1, 1));
            }
        };
    }

    private List<DistanceAndTime> getShinLineDistanceAndTime() {
        return new ArrayList<>() {
            {
                add(new DistanceAndTime(2, 8));
                add(new DistanceAndTime(10, 3));
            }
        };
    }

    private List<Station> getShinLineSections() {
        String[] stations = new String[]{
                "강남역", "양재역", "양재시민의숲역"
        };
        return Arrays.stream(stations)
                .map(Station::new)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        LineRepository lineRepository = new LineRepository();
        StationRepository stationRepository = new StationRepository();
        SectionWithTimeRepository sectionWithTimeRepository = new SectionWithTimeRepository();
        SectionWithDistanceRepository sectionWithDistanceRepository =
                new SectionWithDistanceRepository();

        LineService lineService = new LineService(lineRepository,
                sectionWithDistanceRepository,
                sectionWithTimeRepository);
        StationService stationService = new StationService(stationRepository);

        SectionService sectionService = new SectionService(sectionWithDistanceRepository, sectionWithTimeRepository);

        SubwayController subwayController = new SubwayController(lineService, stationService, sectionService);
        subwayController.run();
    }
}

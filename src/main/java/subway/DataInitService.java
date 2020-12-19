package subway;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.distanceTime.Distance;
import subway.domain.distanceTime.Time;
import subway.domain.section.SectionService;
import subway.domain.section.dto.SectionSaveReqDto;
import subway.domain.section.dto.SectionStationAddReqDto;
import subway.domain.station.StationService;
import subway.domain.station.dto.StationSaveReqDto;

public class DataInitService {
    private static final String STATION_GYODAE = "교대역";
    private static final String STATION_GANGNAM = "강남역";
    private static final String STATION_YEOKSAM = "역삼역";
    private static final String STATION_SOUTH_TERMINAL = "남부터미널역";
    private static final String STATION_YANGJAE = "양재역";
    private static final String STATION_CITIZEN_FOREST = "양재시민의숲역";
    private static final String STATION_MAEBONG = "매봉역";
    private static final String LINE_TWO = "2호선";
    private static final String LINE_THREE = "3호선";
    private static final String LINE_SINBUNDANG = "신분당선";

    private static final int SECOND = 2;
    private static final int THIRD = 3;

    private static final int KM_ONE = 1;
    private static final int KM_TWO = 2;
    private static final int KM_THREE = 3;
    private static final int KM_SIX = 6;
    private static final int KM_TEN = 10;

    private static final int MINUTE_ONE = 1;
    private static final int MINUTE_TWO = 2;
    private static final int MINUTE_THREE = 3;
    private static final int MINUTE_FIVE = 5;
    private static final int MINUTE_EIGHT = 8;

    private final StationService stationService;
    private final SectionService sectionService;

    public DataInitService(StationService stationService, SectionService sectionService) {
        this.stationService = stationService;
        this.sectionService = sectionService;
    }

    public void init() {
        saveStation();
        saveSection();
        saveDistance();
        saveTime();
    }

    private void saveDistance() {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = getStringDefaultWeightedEdgeWeightedMultigraph();

        graph.setEdgeWeight(graph.addEdge(STATION_GYODAE, STATION_GANGNAM), new Distance(KM_TWO).getKm());
        graph.setEdgeWeight(graph.addEdge(STATION_GANGNAM, STATION_YEOKSAM), new Distance(KM_TWO).getKm());

        graph.setEdgeWeight(graph.addEdge(STATION_GYODAE, STATION_SOUTH_TERMINAL), new Distance(KM_THREE).getKm());
        graph.setEdgeWeight(graph.addEdge(STATION_SOUTH_TERMINAL, STATION_YANGJAE), new Distance(KM_SIX).getKm());
        graph.setEdgeWeight(graph.addEdge(STATION_YANGJAE, STATION_MAEBONG), new Distance(KM_ONE).getKm());

        graph.setEdgeWeight(graph.addEdge(STATION_GANGNAM, STATION_YANGJAE), new Distance(KM_TWO).getKm());
        graph.setEdgeWeight(graph.addEdge(STATION_YANGJAE, STATION_CITIZEN_FOREST), new Distance(KM_TEN).getKm());

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        SearchService.addDijkstraShortestPath(dijkstraShortestPath);
    }

    private void saveTime() {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = getStringDefaultWeightedEdgeWeightedMultigraph();

        graph.setEdgeWeight(graph.addEdge(STATION_GYODAE, STATION_GANGNAM), new Time(MINUTE_THREE).getMinute());
        graph.setEdgeWeight(graph.addEdge(STATION_GANGNAM, STATION_YEOKSAM), new Time(MINUTE_THREE).getMinute());

        graph.setEdgeWeight(graph.addEdge(STATION_GYODAE, STATION_SOUTH_TERMINAL), new Time(MINUTE_TWO).getMinute());
        graph.setEdgeWeight(graph.addEdge(STATION_SOUTH_TERMINAL, STATION_YANGJAE), new Time(MINUTE_FIVE).getMinute());
        graph.setEdgeWeight(graph.addEdge(STATION_YANGJAE, STATION_MAEBONG), new Time(MINUTE_ONE).getMinute());

        graph.setEdgeWeight(graph.addEdge(STATION_GANGNAM, STATION_YANGJAE), new Time(MINUTE_EIGHT).getMinute());
        graph.setEdgeWeight(graph.addEdge(STATION_YANGJAE, STATION_CITIZEN_FOREST), new Time(MINUTE_THREE).getMinute());

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        SearchService.addDijkstraShortestPath(dijkstraShortestPath);
    }

    private WeightedMultigraph<String, DefaultWeightedEdge> getStringDefaultWeightedEdgeWeightedMultigraph() {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
        graph.addVertex(STATION_GYODAE);
        graph.addVertex(STATION_GANGNAM);
        graph.addVertex(STATION_YEOKSAM);
        graph.addVertex(STATION_SOUTH_TERMINAL);
        graph.addVertex(STATION_YANGJAE);
        graph.addVertex(STATION_MAEBONG);
        graph.addVertex(STATION_CITIZEN_FOREST);
        return graph;
    }

    private void saveSection() {
        sectionService.saveSection(new SectionSaveReqDto(LINE_TWO, STATION_GYODAE, STATION_YEOKSAM));
        sectionService.addStation(new SectionStationAddReqDto(LINE_TWO, STATION_GANGNAM, SECOND));

        sectionService.saveSection(new SectionSaveReqDto(LINE_THREE, STATION_GYODAE, STATION_MAEBONG));
        sectionService.addStation(new SectionStationAddReqDto(LINE_THREE, STATION_SOUTH_TERMINAL, SECOND));
        sectionService.addStation(new SectionStationAddReqDto(LINE_THREE, STATION_YANGJAE, THIRD));

        sectionService.saveSection(new SectionSaveReqDto(LINE_SINBUNDANG, STATION_GANGNAM, STATION_CITIZEN_FOREST));
        sectionService.addStation(new SectionStationAddReqDto(LINE_SINBUNDANG, STATION_YANGJAE, SECOND));
    }

    private void saveStation() {
        String[] stationNames = {STATION_GYODAE, STATION_GANGNAM, STATION_YEOKSAM, STATION_SOUTH_TERMINAL, STATION_YANGJAE, STATION_CITIZEN_FOREST, STATION_MAEBONG};
        for (String stationName : stationNames) {
            stationService.saveStation(new StationSaveReqDto(stationName));
        }
    }
}

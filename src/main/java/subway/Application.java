package subway;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.controller.Initializer;
import subway.controller.SubwayController;
import subway.domain.Line.LineRepository;
import subway.domain.section.SectionWithDistanceRepository;
import subway.domain.section.SectionWithTimeRepository;
import subway.domain.station.StationRepository;
import subway.service.LineService;
import subway.service.SectionService;
import subway.service.StationService;
import subway.view.InputView;

import java.util.List;
import java.util.Scanner;

public class Application {
    static StationService stationService;
    static LineService lineService;
    static SectionService sectionService;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        initialize();

        SubwayController subwayController = new SubwayController(lineService, stationService,
                sectionService, new InputView(scanner));
        subwayController.run();
    }

    public static void initialize() {
        LineRepository lineRepository = new LineRepository();
        StationRepository stationRepository = new StationRepository();
        SectionWithTimeRepository sectionWithTimeRepository = new SectionWithTimeRepository();
        SectionWithDistanceRepository sectionWithDistanceRepository =
                new SectionWithDistanceRepository();

        lineService = new LineService(lineRepository,
                sectionWithDistanceRepository,
                sectionWithTimeRepository);

        stationService = new StationService(stationRepository);
        sectionService = new SectionService(sectionWithDistanceRepository, sectionWithTimeRepository);

        Initializer initializer = new Initializer(stationService, lineService);
        initializer.initialize();
    }
}

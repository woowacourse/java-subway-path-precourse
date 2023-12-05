package subway;

import java.util.Scanner;
import subway.controller.InitController;
import subway.controller.InputController;
import subway.controller.SubwayController;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.service.LineService;
import subway.service.MinimumTimeService;
import subway.service.ShortestPathService;
import subway.service.StationService;
import subway.validation.EndStationValidation;
import subway.validation.MainFunctionValidation;
import subway.validation.SelectRouteValidation;
import subway.validation.StartStationValidation;
import subway.view.Input.InputView;
import subway.view.output.OutputView;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        // 객체 생성
        InputView inputView = createInputView();
        OutputView outputView = new OutputView();

        StationService stationService = createStationService(new StationRepository());
        LineService lineService = createLineService(new LineRepository());
        ShortestPathService shortestPathService = new ShortestPathService();
        MinimumTimeService minimumTimeService = new MinimumTimeService();

        InitController initController = createInitController(stationService, lineService);
        InputController inputController = createInputController(inputView, outputView, scanner);
        SubwayController subwayController = createSubwayController(shortestPathService, minimumTimeService, outputView);

        // 메서드 호출
        executeControllers(initController, inputController, subwayController);
    }

    private static InputView createInputView() {
        MainFunctionValidation mainFunctionValidation = new MainFunctionValidation();
        SelectRouteValidation selectRouteValidation = new SelectRouteValidation();
        StartStationValidation startStationValidation = new StartStationValidation();
        EndStationValidation endStationValidation = new EndStationValidation();
        return new InputView(mainFunctionValidation, selectRouteValidation, startStationValidation,
                endStationValidation);
    }

    private static StationService createStationService(StationRepository stationRepository) {
        return StationService.createStationService(stationRepository);
    }

    private static LineService createLineService(LineRepository lineRepository) {
        return LineService.createLineService(lineRepository);
    }


    private static InitController createInitController(StationService stationService, LineService lineService) {
        return InitController.createInitController(stationService, lineService);
    }

    private static InputController createInputController(InputView inputView, OutputView outputView, Scanner scanner) {
        return InputController.createInputController(inputView, outputView, scanner);
    }

    private static SubwayController createSubwayController(ShortestPathService shortestPathService,
                                                           MinimumTimeService minimumTimeService,
                                                           OutputView outputView) {
        return SubwayController.createSubwayController(shortestPathService, minimumTimeService, outputView);
    }


    private static void executeControllers(InitController initController, InputController inputController,
                                           SubwayController subwayController) {
        initController.init();

        while (true) {
            String mainFunc = inputController.inputMainFunc();
            if (mainFunc.equals("Q")) {
                System.exit(0);
            }

            if (mainFunc.equals("1")) {
                executeRouteSelection(inputController, subwayController);
            }
        }
    }

    private static void executeRouteSelection(InputController inputController, SubwayController subwayController) {
        String selectRouteFunc = inputController.inputSelectRoute();
        if (selectRouteFunc.equals("B")) {
            return;
        }

        Station start = inputStartStation(inputController);
        Station end = inputEndStation(inputController, start);

        subwayController.calculateAndPrintRoute(selectRouteFunc, start, end);
    }

    private static Station inputStartStation(InputController inputController) {
        String stationName = inputController.inputStartStation();
        return new Station(stationName);
    }

    private static Station inputEndStation(InputController inputController, Station start) {
        String stationName = inputController.inputEndStation(start.getName());
        return new Station(stationName);
    }
}


package subway.view.screen.action.path;

import subway.CategoryType;
import subway.domain.Path.dto.PathResponseDto;
import subway.domain.Path.service.PathService;
import subway.domain.line.service.LineService;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.screen.action.BaseActionScreen;

public class ShortestTimePathActionScreen extends BaseActionScreen {

    public static final String START_STATION_NAME_INPUT_MESSAGE = "출발역을 입력하세요.";
    public static final String END_STATION_NAME_INPUT_MESSAGE = "도착역을 입력하세요.";

    public ShortestTimePathActionScreen(CategoryType selectedCategoryType) {
        super(selectedCategoryType);
    }

    @Override
    public void visualize() {
    }

    @Override
    protected void action(InputView inputView) {
        OutputView.printTitle(START_STATION_NAME_INPUT_MESSAGE);
        String sourceStationName = inputView.readCommand();

        OutputView.printTitle(END_STATION_NAME_INPUT_MESSAGE);
        String targetStationName = inputView.readCommand();

        PathResponseDto responseDto = PathService
            .getShortestDistanceGraphPath(sourceStationName, targetStationName);

        OutputView.printTitle(RESULT_MESSAGE);
        OutputView.printResult(COLUMN_LINE);
        OutputView.printResult(TOTAL_TIME_MESSAGE + DOT_DOT + responseDto.getTotalWeight() + MINUTE_MESSAGE);
        OutputView.printResult(COLUMN_LINE);
        responseDto.getStations().forEach(
            lineResponseDto -> OutputView.printResult(lineResponseDto.getName()));
    }
}

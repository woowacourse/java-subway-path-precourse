package subway.domain.global;

import subway.domain.graph.GraphController;
import subway.domain.line.LineRepository;
import subway.domain.station.StationRepository;
import subway.domain.util.ExceptionHandler;
import subway.view.InputView;
import subway.view.OutputView;

import static subway.domain.global.SystemCommand.*;

public class SystemController {
    private boolean systemContinue = true;
    private final GraphController graphController = new GraphController();

    public SystemController() {
        StationRepository.setUp();
        LineRepository.setUp();
        graphController.setUp();
    }

    // 프로그램 전체 진행 중, 유효하지 않은 입력값은 즉시 재입력을 받지만
    // 이외의 예측 가능한 오류 발생시 오류메시지 출력 후 메인 페이지로 복귀
    public void run() {
        while (systemContinue) {
            try {
                OutputView.printMainPage();
                String input = ExceptionHandler.repeatForValidInput(InputView::readMainCommand);
                executeMainCommand(input);
            } catch (IllegalArgumentException e) {
                OutputView.print(e.getMessage());
            }
        }
    }

    private void executeMainCommand(String input) {
        SystemCommand command = convertToCommand(input);

        if (command == FIND_PATH) graphController.run();
        if (command == QUIT) systemContinue = false;
    }

}

package subway.view.pathview;

import subway.domain.StationRepository;
import subway.error.StationNotExistException;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.View;

public abstract class SearchPathView implements View {

    @Override
    public void setVisible() {
        while (true) {
            try {
                OutputView.printInputStartStationGuideMessage();
                String startStation = inputStation();
                OutputView.printInputEndStationGuideMessage();
                String endStation = inputStation();
                requestSearchPath(startStation, endStation);
                return;
            } catch (RuntimeException e) {
                OutputView.printExceptionMessage(e);
            }
        }
    }

    private String inputStation() {
        String input = InputView.inputStation();
        return input;
    }

    protected abstract void requestSearchPath(String startStation, String endStation);
}

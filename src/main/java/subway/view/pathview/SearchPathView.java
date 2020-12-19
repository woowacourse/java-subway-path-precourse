package subway.view.pathview;

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
        /** TODO: StationRepository로부터 역이 존재하는지 확인 (예외 던져야함) */
        return input;
    }

    protected abstract void requestSearchPath(String startStation, String endStation);
}

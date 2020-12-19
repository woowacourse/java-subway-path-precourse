package subway.controller;

import subway.domain.Basis;
import subway.exception.InvalidInputException;
import subway.service.PathService;
import subway.view.InputView;
import subway.view.OutputView;

import static subway.view.resource.Information.*;

public class PathController extends SubwayController {

    private PathService pathService;

    public PathController(InputView inputView, OutputView outputView) {
        super(inputView, outputView);
        pathService = new PathService();
    }

    @Override
    public void start() {
        run();
    }

    private void run() {
        try {
            Basis basis = new Basis(getSelectedBasis(), getSrcStation(), getDstStation());
            String result = pathService.searchPath(basis);
            getOutputView().printInformation(result);
        } catch (InvalidInputException e) {
            getOutputView().printErrorMessage(e.getMessage());
        }
    }

    private String getSelectedBasis() {
        getOutputView().printInformation(BASIS_INFO);
        return getInputView().getSelectedBasisInput();
    }

    private String getSrcStation() {
        getOutputView().printInformation(SRC_INFO);
        return getInputView().getSrcStationInput();
    }

    private String getDstStation() {
        getOutputView().printInformation(DST_INFO);
        return getInputView().getDstStationInput();
    }
}
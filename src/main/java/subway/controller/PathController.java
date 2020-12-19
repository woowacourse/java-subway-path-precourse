package subway.controller;

import subway.domain.Basis;
import subway.domain.BasisChoice;
import subway.exception.InvalidInputException;
import subway.view.InputView;
import subway.view.OutputView;

import static subway.view.resource.Information.BASIS_INFO;

public class PathController extends SubwayController {

    public PathController(InputView inputView, OutputView outputView) {
        super(inputView, outputView);
    }

    @Override
    public void start() {
        run();
    }

    private void run() {
        try {
            String selectedBasis = getSelectedBasis();
            BasisChoice.validate(selectedBasis);
            Basis basis = new Basis(selectedBasis, null, null);
        } catch (InvalidInputException e) {
            getOutputView().printErrorMessage(e.getMessage());
        }
    }

    private String getSelectedBasis() {
        getOutputView().printInformation(BASIS_INFO);
        return getInputView().getSelectedBasisInput();
    }
}
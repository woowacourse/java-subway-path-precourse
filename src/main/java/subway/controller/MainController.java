package subway.controller;

import subway.domain.FunctionChoice;
import subway.exception.InvalidInputException;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.service.MainService;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

import static subway.view.resource.Information.MAIN_INFO;

public class MainController extends SubwayController {

    private MainService mainService;
    private PathController pathController;

    private boolean isContinue = true;

    public MainController(Scanner scanner) {
        super(new InputView(scanner), new OutputView());
        mainService = new MainService();
        initController();
        initData();
    }

    private void initController() {
        pathController = new PathController(getInputView(), getOutputView());
    }

    private void initData() {
        StationRepository.initStations();
        LineRepository.initLines();
    }

    @Override
    public void start() {
        while (isContinue)
            run();
    }

    private void run() {
        try {
            String selectedFunction = getSelectedFunction();
            mainService.validate(selectedFunction);
            runSelectedService(selectedFunction);
        } catch (InvalidInputException e) {
            getOutputView().printErrorMessage(e.getMessage());
        }
    }

    private String getSelectedFunction() {
        getOutputView().printInformation(MAIN_INFO);
        return getInputView().getSelectedFunctionInput();
    }

    private void runSelectedService(String selectedService) {
        if (selectedService.equals(FunctionChoice.PATH.getCode()))
            pathController.start();
        if (selectedService.equals(FunctionChoice.QUIT.getCode()))
            isContinue = false;
    }
}

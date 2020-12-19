package subway.controller;

import subway.constant.Service;
import subway.exception.InvalidInputException;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

import static subway.view.resource.Information.MAIN_INFO;

public class MainController extends Controller {

    private PathController pathController;

    private boolean isContinue = true;

    public MainController(Scanner scanner) {
        super(new InputView(scanner), new OutputView());
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

    public void start() {
        while (isContinue)
            run();
    }

    private void run() {
        try {
            String selectedService = getSelectedService();
            Service.validate(selectedService);
            runSelectedService(selectedService);
        } catch (InvalidInputException e) {
            getOutputView().printErrorMessage(e.getMessage());
        }
    }

    private String getSelectedService() {
        getOutputView().printInformation(MAIN_INFO);
        return getInputView().getSelectedServiceInput();
    }

    private void runSelectedService(String selectedService) {
        if (selectedService.equals(Service.PATH.getCode()))
            pathController.run();
        if (selectedService.equals(Service.QUIT.getCode()))
            isContinue = false;
    }
}

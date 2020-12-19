package subway.controller;

import java.util.Scanner;
import subway.controller.constants.QuestionNumber;
import subway.controller.constants.SelectOptionConstants;
import subway.controller.option.EntireOption;
import subway.view.MainInputView;

public class EntirePathSystem {
    private Scanner scanner;

    public EntirePathSystem(Scanner scanner) {
        this.scanner = scanner;
    }

    public void runProgram() {
        String sector;
        do {
            MainInputView.askMainScreen();
            sector = scanner.nextLine();
            isValidSector(sector);
            goSector(sector);
        } while (!sector.equals(QuestionNumber.TERMINATE.getOption()));
    }

    private void isValidSector(String sector) {
        try {
            isContainSectorList(sector);
        } catch (Exception error) {
            System.out.println();
            System.out.println(SelectOptionConstants.OPTION_ERROR);
        }
    }

    private void isContainSectorList(String sector) {
        if (!SelectOptionConstants.MAIN.contains(sector)) {
            throw new IllegalArgumentException(SelectOptionConstants.OPTION_ERROR);
        }
    }

    private void goSector(String sector) {
        for (EntireOption entireOption : EntireOption.values()) {
            filterSector(entireOption, scanner, sector);
        }
    }

    private void filterSector(EntireOption candidate, Scanner scanner, String option) {
        if (candidate.getOption().equals(option)) {
            candidate.processSector(scanner);
        }
    }

}

package subway.pathfind;

import java.util.Scanner;
import subway.common.CommonErrorChecker;
import subway.common.CommonPrinter;

public class PathCriteriaSelector {
    public static void start(Scanner scanner) {
        while (true) {
            PathCriteriaSelectionType criteriaType;
            try {
                criteriaType = printAndGetUserCriteriaSelectionInput(scanner);
            } catch (IllegalArgumentException e) {
                continue;
            }
            if (criteriaType == PathCriteriaSelectionType.GO_BACK) {
                return;
            }
            PathCalculator.start(scanner, criteriaType);
            return;
        }
    }

    private static PathCriteriaSelectionType printAndGetUserCriteriaSelectionInput(
        Scanner scanner) throws IllegalArgumentException {
        PathCriteriaSelectionScreenPrinter.printMenu();
        CommonPrinter.printUserSelectionMessage();
        String userSelectionInput = scanner.nextLine();
        CommonErrorChecker.validateMenuSelectionInput(userSelectionInput,
            CommonErrorChecker.FIND_WAY_SELECTION_PATTERN);
        return getUserSelectionType(userSelectionInput);
    }

    private static PathCriteriaSelectionType getUserSelectionType(String userSelectionInput) {
        if (userSelectionInput.equals(PathCriteriaSelectionType.SHORTEST_DISTANCE.getStrValue())) {
            return PathCriteriaSelectionType.SHORTEST_DISTANCE;
        }
        if (userSelectionInput.equals(PathCriteriaSelectionType.MINIMUM_TIME.getStrValue())) {
            return PathCriteriaSelectionType.MINIMUM_TIME;
        }
        return PathCriteriaSelectionType.GO_BACK;
    }
}

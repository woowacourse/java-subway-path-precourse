package subway.controller;

import subway.controller.validation.PathValidation;
import subway.service.DistanceMapService;
import subway.service.TimeMapService;
import subway.type.ExceptionType;
import subway.type.InformationType;
import subway.type.InputType;
import subway.type.TextType;
import subway.view.InputView;

import java.util.List;
import java.util.Scanner;

public class PathController implements OptionInterface {
    public static void startPath(Scanner scanner) {
        PathController pathController = new PathController();

        while (true) {
            String pathInput = InputView.scanPathInput(scanner);
            System.out.println();

            if (isBack(pathInput)) {
                return;
            }
            pathController.chooseOption(pathInput, scanner);
        }
    }

    public static boolean isBack(String pathInput) {
        return pathInput.equals(InputType.BACK.getInput());
    }

    @Override
    public void chooseOption(String input, Scanner scanner) {
        if (input.equals(InputType.ONE.getInput())) {
            getPathByShortestDistance(scanner);
            return;
        }
        if (input.equals(InputType.TWO.getInput())) {
            getPathByShortestTime(scanner);
            return;
        }
        System.out.println(ExceptionType.INVALID_OPTION_CHOICE.getException());
    }

    public static void getPathByShortestDistance(Scanner scanner) {
        String originInput = InputView.scanOriginInput(scanner);
        System.out.println();
        String destinationInput = InputView.scanDestinationInput(scanner);
        System.out.println();

        if (PathValidation.isValidStations(originInput, destinationInput)) {
            double shortestDistance = DistanceMapService.getShortestDistance(originInput, destinationInput);
            List<String> shortestDistanceStations
                    = DistanceMapService.getShortestDistanceStations(originInput, destinationInput);

            System.out.println(showPathByShortestDistance(shortestDistance, shortestDistanceStations));
        }
    }

    public static String showPathByShortestDistance(double shortestDistance, List<String> shortestDistanceStations) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(InformationType.INFORMATION_WITH_LINES.getInformation())
                .append(InformationType.INFORMATION.getInformation())
                .append(TextType.TOTAL_DISTANCE.getText())
                .append((int) shortestDistance)
                .append(TextType.KILOMETER.getText())
                .append(InformationType.INFORMATION_WITH_LINES.getInformation());

        for (String shortestDistanceStation : shortestDistanceStations) {
            stringBuilder.append(InformationType.INFORMATION.getInformation())
                    .append(shortestDistanceStation)
                    .append(TextType.NEW_LINE.getText());
        }
        return stringBuilder.toString();
    }

    public static void getPathByShortestTime(Scanner scanner) {
        String originInput = InputView.scanOriginInput(scanner);
        System.out.println();
        String destinationInput = InputView.scanDestinationInput(scanner);
        System.out.println();

        if (PathValidation.isValidStations(originInput, destinationInput)) {
            double timeMap = TimeMapService.getShortestTime(originInput, destinationInput);
            List<String> shortestTimeStations
                    = TimeMapService.getShortestTimeStations(originInput, destinationInput);

            System.out.println(showPathByShortestTime(timeMap, shortestTimeStations));
        }
    }

    public static String showPathByShortestTime(double timeMap, List<String> shortestTimeStations) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(InformationType.INFORMATION_WITH_LINES.getInformation())
                .append(InformationType.INFORMATION.getInformation())
                .append(TextType.TOTAL_TIME.getText())
                .append((int) timeMap)
                .append(TextType.MINUTE.getText())
                .append(InformationType.INFORMATION_WITH_LINES.getInformation());

        for (String shortestTimeStation : shortestTimeStations) {
            stringBuilder.append(InformationType.INFORMATION.getInformation())
                    .append(shortestTimeStation)
                    .append(TextType.NEW_LINE.getText());
        }
        return stringBuilder.toString();
    }
}

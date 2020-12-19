package subway.view;

import subway.domain.Sections;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.SubwayGraph;
import subway.exception.InvalidCommandException;

import java.util.Objects;
import java.util.Scanner;

public class SectionInquiryView extends View {
    private static final SectionInquiryView instance = new SectionInquiryView();
    private static final String MINIMUM_DISTANCE = "1";
    private static final String MINIMUM_DURATION = "2";
    private static final String GO_MAIN_VIEW = "B";

    private static Scanner scanner;

    private SectionInquiryView() {

    }

    static SectionInquiryView getInstance() {
        return instance;
    }

    static void setScanner(Scanner scannerObject) {
        scanner = scannerObject;
    }

    @Override
    void printViewGuide() {
        System.out.println("## 경로 기준\n1. 최단 거리\n2. 최소 시간\nB. 돌아가기\n");
    }

    @Override
    void validationCommand(String command) {
        if (command.equals(MINIMUM_DISTANCE)) {
            return;
        }
        if (command.equals(MINIMUM_DURATION)) {
            return;
        }
        if (command.equals(GO_MAIN_VIEW)) {
            return;
        }
        throw new InvalidCommandException();
    }

    @Override
    void doCommand(String command) {
        if (command.equals(MINIMUM_DISTANCE)) {
            doMinimumCommand(true);
            return;
        }
        if (command.equals(MINIMUM_DURATION)) {
            doMinimumCommand(false);
            return;
        }
        if (command.equals(GO_MAIN_VIEW)) {
            UserInterface.setView(MainView.getInstance());
        }
    }

    private void doMinimumCommand(boolean isDinstance) {
        Station departue = getDepartureStation();
        Station arrival = getArrivalStation();

        validateDepartueAndArrival(departue, arrival);

        printSections(SubwayGraph.getMinimumSections(isDinstance, departue, arrival));
    }

    private Station getDepartureStation() {
        System.out.println("## 출발역을 입력하세요.");

        return StationRepository.getStation(scanner.nextLine());
    }

    private Station getArrivalStation() {
        System.out.println("## 도착역을 입력하세요.");

        return StationRepository.getStation(scanner.nextLine());
    }

    private void validateDepartueAndArrival(Station departue, Station arrival) {
        if (Objects.equals(departue.getName(), arrival.getName())) {
            throw new IllegalArgumentException("[ERROR] 출발역과 도착역이 동일합니다.");
        }
    }

    private void printSections(Sections sections) {
        StringBuilder outputBuilder = new StringBuilder("## 조회 결과\n");

        outputBuilder.append("[INFO]---\n");
        outputBuilder.append("[INFO] 총 거리: ").append(sections.getTotalDistance()).append("km\n")
                .append("[INFO] 총 소요 시간: ").append(sections.getTotalDuration()).append("분\n");

        outputBuilder.append("[INFO]---\n");
        sections.getStationsName().forEach(stationName -> outputBuilder.append("[INFO] ").append(stationName).append("\n"));

        System.out.println(outputBuilder.toString());
    }
}
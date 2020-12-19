package subway.controller;

import subway.controller.constants.InitialNewBoonDangLine;
import subway.controller.constants.InitialNewBoonDangLineDistance;
import subway.controller.constants.InitialNewBoonDangLineTime;
import subway.controller.constants.InitialSecondLine;
import subway.controller.constants.InitialSecondLineDistance;
import subway.controller.constants.InitialSecondLineTime;
import subway.controller.constants.InitialThirdLine;
import subway.controller.constants.InitialThirdLineDistance;
import subway.controller.constants.InitialThirdLineTime;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationDistanceRespository;
import subway.domain.StationRepository;
import subway.domain.StationTimeRepository;
import subway.controller.constants.InitialStations;

public class Initiator {
    private static final String SECOND_LINE = "2호선";
    private static final String THIRD_LINE = "3호선";
    private static final String NEW_BOONDANG_LINE = "신분당선";

    public static void intiateSet() {
        initiateStation();
        initiateLine();
        initiatePath();
    }

    private static void initiateStation() {
        for (InitialStations initialStation : InitialStations.values()) {
            String stationTitle = initialStation.getName();
            Station insertedStation = new Station(stationTitle);
            StationRepository.addStation(insertedStation);
            StationDistanceRespository.addStationTitle(stationTitle);
            StationTimeRepository.addStationTitle(stationTitle);
        }
    }

    private static void initiateLine() {
        initiateSecondLine();
        initiateThirdLine();
        initiateNewBoonDangLine();
    }

    private static void initiateSecondLine() {
        Line secondLine = new Line(SECOND_LINE);

        for (InitialSecondLine eachStation : InitialSecondLine.values()) {
            int order = eachStation.getOrder();
            Station insertedStation = new Station(eachStation.getName());
            secondLine.insertStation(order, insertedStation);
        }

        LineRepository.addLine(secondLine);
    }

    private static void initiateThirdLine() {
        Line thirdLine = new Line(THIRD_LINE);

        for (InitialThirdLine eachStation : InitialThirdLine.values()) {
            int order = eachStation.getOrder();
            Station insertedStation = new Station(eachStation.getName());
            thirdLine.insertStation(order, insertedStation);
        }

        LineRepository.addLine(thirdLine);
    }

    private static void initiateNewBoonDangLine() {
        Line newBoonDangLine = new Line(NEW_BOONDANG_LINE);

        for (InitialNewBoonDangLine eachStation : InitialNewBoonDangLine.values()) {
            int order = eachStation.getOrder();
            Station insertedStation = new Station(eachStation.getName());
            newBoonDangLine.insertStation(order, insertedStation);
        }

        LineRepository.addLine(newBoonDangLine);
    }

    private static void initiatePath() {
        initiateSecondLinePath();
        initiateThirdLinePath();
        initiateNewBoonDangLinePath();
    }

    private static void initiateSecondLinePath() {
        initiateSecondLineDistancePath();
        initiateSecondLineTimePath();
    }

    private static void initiateSecondLineDistancePath() {
        for (InitialSecondLineDistance eachPath : InitialSecondLineDistance.values()) {
            String departure = eachPath.getDepartureName();
            String terminal = eachPath.getTerminalName();
            int distance = eachPath.getDistance();
            StationDistanceRespository.addStationIntervalDistance(departure, terminal, distance);
        }
    }

    private static void initiateSecondLineTimePath() {
        for (InitialSecondLineTime eachPath : InitialSecondLineTime.values()) {
            String departure = eachPath.getDepartureName();
            String terminal = eachPath.getTerminalName();
            int time = eachPath.getTime();
            StationTimeRepository.addStationIntervalTime(departure, terminal, time);
        }
    }

    private static void initiateThirdLinePath() {
        initiateThirdLineDistancePath();
        initiateThirdLineTimePath();
    }

    private static void initiateThirdLineDistancePath() {
        for (InitialThirdLineDistance eachPath : InitialThirdLineDistance.values()) {
            String departure = eachPath.getDepartureName();
            String terminal = eachPath.getTerminalName();
            int distance = eachPath.getDistance();
            StationDistanceRespository.addStationIntervalDistance(departure, terminal, distance);
        }
    }


    private static void initiateThirdLineTimePath() {
        for (InitialThirdLineTime eachPath : InitialThirdLineTime.values()) {
            String departure = eachPath.getDepartureName();
            String terminal = eachPath.getTerminalName();
            int time = eachPath.getTime();
            StationTimeRepository.addStationIntervalTime(departure, terminal, time);
        }
    }

    private static void initiateNewBoonDangLinePath() {
        initiateNewBoonDangLineDistancePath();
        initiateNewBoonDangLineTimePath();
    }

    private static void initiateNewBoonDangLineDistancePath() {
        for (InitialNewBoonDangLineDistance eachPath : InitialNewBoonDangLineDistance.values()) {
            String departure = eachPath.getDepartureName();
            String terminal = eachPath.getTerminalName();
            int distance = eachPath.getDistance();
            StationDistanceRespository.addStationIntervalDistance(departure, terminal, distance);
        }
    }

    private static void initiateNewBoonDangLineTimePath() {
        for (InitialNewBoonDangLineTime eachPath : InitialNewBoonDangLineTime.values()) {
            String departure = eachPath.getDepartureName();
            String terminal = eachPath.getTerminalName();
            int time = eachPath.getTime();
            StationTimeRepository.addStationIntervalTime(departure, terminal, time);
        }
    }
}

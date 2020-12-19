package subway;

import exception.NoneFunctionException;
import exception.SameStationException;
import inputview.InputView;
import outputview.FindView;
import subway.domain.EndStation;
import subway.domain.Order;
import subway.domain.StartStation;

import java.util.List;

public class FindPathService {
    private final InputView inputView;

    public FindPathService(InputView inputView) {
        this.inputView = inputView;
    }

    public void runService() {
        String select = inputView.selectFunction();
        if (select.equals("1")) {
            shortestWay();
        }
        if (select.equals("2")) {
            shortestTime();
        }
        if (select.equals("B")) {

        }
        if (!select.equals("B") && !select.equals("2") && !select.equals("1")) {
            throw new NoneFunctionException();
        }
    }

    private void shortestWay() {
        FindView.printStartStation();
        StartStation startStation = new StartStation(inputView.selectStation());
        FindView.printEndStation();
        EndStation endStation = new EndStation(inputView.selectStation());
        Order order = new Order(startStation, endStation);
        FindView.printResult(order.findLengthResult(), order.calculateLength(), order.calculateTime());
    }

    private void shortestTime() {
        FindView.printStartStation();
        StartStation startStation = new StartStation(inputView.selectStation());
        FindView.printEndStation();
        EndStation endStation = new EndStation(inputView.selectStation());
        validateSameStation(startStation.getStationName(), endStation.getStationName());
        Order order = new Order(startStation, endStation);
        FindView.printResult(order.findTimeResult(), order.calculateLength(), order.calculateTime());
    }

    private void validateSameStation(String firstName, String secondName) {
        if (firstName.equals(secondName)) {
            throw new SameStationException();
        }
    }
}

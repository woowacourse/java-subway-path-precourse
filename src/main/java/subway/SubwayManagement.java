package subway;

import subway.domain.StationRepository;

public class SubwayManagement {

    private User user;

    public SubwayManagement(User user) {
        this.user = user;
    }

    public void start() {

        InitSetting.initSetting();

        while (true) {
            PrintScreen.printMain();
            String select = user.getInput();
            try {
                checkMainSelect(select);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            if (select.equals(Constants.FUNCTION_ONE)) {
                findPathFunction();
            }
            if (select.equals(Constants.FUNCTION_Q)) {
                break;
            }
        }
    }

    private void checkMainSelect(String select) {
        if (!select.equals(Constants.FUNCTION_Q) && !select.equals(Constants.FUNCTION_ONE)) {
            throw new IllegalArgumentException("[ERROR] 선택할 수 없는 기능입니다.\n");
        }
    }

    private void findPathFunction() {
        PrintScreen.selectStandard();
        String select = user.getInput();
        try {
            checkFindPathSelect(select);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        if (select.equals(Constants.FUNCTION_ONE) || select.equals(Constants.FUNCTION_TWO)) {
            selectFindPathFunction(select);
        }
    }

    private void checkFindPathSelect(String select) {
        if (!select.equals(Constants.FUNCTION_ONE) && !select.equals(Constants.FUNCTION_TWO) && !select.equals(Constants.FUNCTION_B)) {
            throw new IllegalArgumentException("[ERROR] 선택할 수 없는 기능입니다.\n");
        }
    }

    private void selectFindPathFunction(String select) {
        PrintScreen.printInputStartStation();
        String startStation = user.getInput();
        PrintScreen.printInputArriveStation();
        String arriveStation = user.getInput();

        try {
            checkFindPathInput(startStation, arriveStation);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        FindPath.start(select, startStation, arriveStation);
    }

    private void checkFindPathInput(String startStation, String arriveStation) {
        if (!StationRepository.isContain(startStation) || !StationRepository.isContain(arriveStation)) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 역입니다.\n");
        }
        if (startStation.equals(arriveStation)) {
            throw new IllegalArgumentException("[ERROR] 출발역과 도착역은 같을 수 없습니다.\n");
        }
    }
}

package subway;

public class SubwayManagement {

    private User user;

    public SubwayManagement(User user) {
        this.user = user;
    }

    public void start() {
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
            System.out.println(select);
        }
    }

    private void checkFindPathSelect(String select) {
        if(!select.equals(Constants.FUNCTION_ONE) && !select.equals(Constants.FUNCTION_TWO) && !select.equals(Constants.FUNCTION_B)){
            throw new IllegalArgumentException("[ERROR] 선택할 수 없는 기능입니다.\n");
        }
    }
}

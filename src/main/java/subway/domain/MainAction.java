package subway.domain;

public enum MainAction {
    RESEARCH_PATH("1", "경로 조회"),
    FINISH("Q", "종료");

    private String actionNumber;
    private String actionName;

    MainAction(String actionNumber, String actionName) {
        this.actionNumber = actionNumber;
        this.actionName = actionName;
    }

    public boolean isFinish(String inputNumber) {
        if (FINISH.actionName.equals(inputNumber)) {
            return true;
        }
        if (RESEARCH_PATH.actionName.equals(inputNumber)) {
            return false;
        }
        throw new IllegalArgumentException("옳지 않은 메인 기능입니다.");
    }

    public String getActionNumber() {
        return actionNumber;
    }

    public String getActionName() {
        return actionName;
    }
}

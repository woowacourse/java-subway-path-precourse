package subway.menu;

public enum MainMenu {

    FIND("1", "경로 조회"), END("Q", "종료");

    final private String order;
    final private String menuMessage;

    MainMenu(String order, String menuMessage) {
        this.order = order;
        this.menuMessage = menuMessage;
    }

    public String getOrder() {
        return order;
    }

    public String getMenuMessage() {
        return menuMessage;
    }
}

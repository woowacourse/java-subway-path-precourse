package subway.menu;

public enum PathRuleMenu {
    MINIMUM_DISTANCE("1", "최단 거리"), MINIMUM_TIME("2", "최소 시간"), BACK("B", "돌아가기");

    final private String order;
    final private String menuMessage;

    PathRuleMenu(String order, String menuMessage) {
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

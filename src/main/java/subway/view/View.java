package subway.view;

public interface View {
    static final String VIEW_PREFIX = "## ";

    void setVisible();
    String getName();
}

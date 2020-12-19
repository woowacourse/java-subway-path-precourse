package subway.screen;

public interface Screen {

    Screen getValue(String input);

    Screen run();

    Screen[] getValues();

    String getTitle();
}

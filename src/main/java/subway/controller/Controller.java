package subway.controller;

import subway.util.InputUtils;

public interface Controller {

    void run(InputUtils inputUtils);

    String getTitle();
}

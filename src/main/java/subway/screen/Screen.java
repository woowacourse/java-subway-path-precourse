package subway.screen;

import java.util.List;
import subway.functionList.Function;

public interface Screen {
    String getTitle();

    List<Function> getFunctions();
}

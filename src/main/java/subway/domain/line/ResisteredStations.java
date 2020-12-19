package subway.domain.line;

import java.util.Collections;
import java.util.List;

public class ResisteredStations {
    private List<String> stations;

    public ResisteredStations(List<String> initialStations) {
        stations = initialStations;
    }

    public List<String> stations(){
        return Collections.unmodifiableList(stations);
    }
}

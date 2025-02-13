package subway.presentation;

import java.util.List;
import java.util.Map;

import subway.infrastructure.FileParser;
import subway.infrastructure.XmlFileParser;

public class IntroViewController implements ViewController {
    private final MainViewController mainViewController = new MainViewController();
    private final LineController lineController = new LineController();
    private final StationController stationController = new StationController();
    private final SectionController sectionController = new SectionController();

    @Override
    public void execute() {
        this.setup();
        mainViewController.execute();
    }

    private void setup() {
        this.loadLineData();
        this.loadStationData();
        this.loadSectionData();
    }

    private void loadLineData() {
        FileParser fileParser = new XmlFileParser("line.xml");
        List<Map<String, Object>> dataList = fileParser.parser();
        for (Map<String, Object> data : dataList) {
            String lineName = data.get("name").toString();
            this.lineController.addLine(lineName);
        }
    }

    private void loadStationData() {
        FileParser fileParser = new XmlFileParser("station.xml");
        List<Map<String, Object>> dataList = fileParser.parser();
        for (Map<String, Object> data : dataList) {
            String stationName = data.get("name").toString();
            this.stationController.addStation(stationName);
        }
    }

    private void loadSectionData() {
        FileParser fileParser = new XmlFileParser("section.xml");
        List<Map<String, Object>> dataList = fileParser.parser();
        for (Map<String, Object> data : dataList) {
            Map<String, Object> line = (Map<String, Object>)data.get("line");
            String lineName = line.get("name").toString();
            Map<String, Object> source = (Map<String, Object>)data.get("source");
            String sourceName = source.get("name").toString();
            Map<String, Object> sink = (Map<String, Object>)data.get("sink");
            String sinkName = sink.get("name").toString();
            String distance = data.get("distance").toString();
            String time = data.get("time").toString();
            this.sectionController.addSection(lineName, sourceName, sinkName, distance, time);
        }
    }
}

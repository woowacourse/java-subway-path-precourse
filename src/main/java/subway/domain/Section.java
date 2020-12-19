package subway.domain;

public class Section {
    private Station preStation;
    private Station nextStation;
    private String distance;
    private String time;

    public Section(String section) {
       String[] info = section.split(",");
       preStation = StationRepository.findByName(info[0]);
       nextStation = StationRepository.findByName(info[1]);
       String[] sectionInfo = info[2].split("/");
       distance = sectionInfo[0];
       time = sectionInfo[1];
    }

    public Station getPreStation() {
        return preStation;
    }

    public Station getNextStation() {
        return nextStation;
    }

    public String getDistance() {
        return distance;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Section{" +
                "preStation=" + preStation +
                ", nextStation=" + nextStation +
                ", distance='" + distance + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}

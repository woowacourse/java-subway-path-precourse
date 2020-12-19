package subway.domain;

import java.util.List;

public class Path {
    private int totalTime;
    private int totalLength;
    private List<Station> pathList;

    public Path(int totalTime, int totalLength, List<Station> pathList){
        this.totalTime = totalTime;
        this.totalLength = totalLength;
        this.pathList = pathList;
    }

    public int getTotalTime(){
        return totalTime;
    }

    public int getTotalLength(){
        return totalLength;
    }

    public List<Station> getPathList(){
        return pathList;
    }
}

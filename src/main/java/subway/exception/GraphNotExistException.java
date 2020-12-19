package subway.exception;

public class GraphNotExistException extends RuntimeException {

    private final String graphName;

    public GraphNotExistException(String graphName) {
        this.graphName = graphName;
    }

    @Override
    public String getMessage() {
        return "[ERROR] " + graphName + "은 없는 그래프입니다.";
    }
}

package subway.domain;

import java.util.LinkedList;

import static resource.TextResource.ERROR_ORDER_NOT_VALID;

public class Paths {
    private LinkedList<Path> paths;

    public Paths(LinkedList<Path> paths) {
        this.paths = paths;
    }

    public void addPath(Path path, int order, int limit) {
        int position = order - 1;
        if (position < 1 || position > limit - 1) {
            throw new IllegalArgumentException(ERROR_ORDER_NOT_VALID);
        }
        paths.add(order - 1, path);
    }

    public int getSize() {
        return paths.size();
    }
}

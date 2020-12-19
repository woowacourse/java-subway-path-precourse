package subway.domain.selector;

public abstract class Selector {

    protected String id;
    protected String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

}

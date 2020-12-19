package subway.domain;

public class Station {
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    @Override
    public boolean equals(Object obj) {
        if (((Station)obj).getName().equals(name)) {
            return true;
        }
        return false;
    }
}

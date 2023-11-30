package subway.util.constants;

public enum DistanceInfo implements EnumUtil<String, Integer>{
    GYODAE_GANGNAM_DISTANCE(2),
    GANGNAM_YEOKSAM_DISTANCE(2),
    GYODAE_SOUTH_TERMINAL_DISTANCE(3),
    SOUTH_TERMINAL_YANGJAE_DISTANCE(6),
    YANGJAE_MAEBONG_DISTANCE(1),
    GANGNAM_YANGJAE_DISTANCE(2),
    YANGJAE_YANGJAE_CITIZEN_FORESET_DISTANCE(10);

    private int distance;
    DistanceInfo(int distance){
        this.distance = distance;
    }

    @Override
    public String getKey() {
        return name();
    }

    @Override
    public Integer getValue() {
        return distance;
    }
}

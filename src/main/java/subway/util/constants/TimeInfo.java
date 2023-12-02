package subway.util.constants;

public enum TimeInfo implements EnumUtil<String, Integer>{
    GYODAE_GANGNAM_TIME(3),
    GANGNAM_YEOKSAM_TIME(3),
    GYODAE_SOUTH_TERMINAL_TIME(2),
    SOUTH_TERMINAL_YANGJAE_TIME(5),
    YANGJAE_MAEBONG_TIME(1),
    GANGNAM_YANGJAE_TIME(8),
    YANGJAE_YANGJAE_CITIZEN_FORESET_TIME(3);

    private int time;
    TimeInfo(int time){
        this.time = time;
    }
    @Override
    public String getKey() {
        return name();
    }

    @Override
    public Integer getValue() {
        return time;
    }
}

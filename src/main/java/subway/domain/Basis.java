package subway.domain;

public class Basis {

    private String basis;
    private Station srcStation;
    private Station dstStation;

    public Basis(String basis, Station srcStation, Station dstStation) {
        this.basis = basis;
        this.srcStation = srcStation;
        this.dstStation = dstStation;
    }
}

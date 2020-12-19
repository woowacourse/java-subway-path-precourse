package subway.view.resource;

public enum FunctionCode {
    ONE("1"),
    TWO("2"),
    BACK("B"),
    QUIT("Q");

    private String code;

    FunctionCode(String code){
        this.code = code;
    }

    public boolean isSameCode(String code){
        if (this.code.toString().equals(code)){
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return code;
    }
}

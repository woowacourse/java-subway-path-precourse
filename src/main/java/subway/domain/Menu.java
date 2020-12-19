package subway.domain;

public class Menu {
    public enum Main {
        ROUTE_INQUIRY("1", "경로조회"),
        QUIT("Q", "종료"),
        ;

        private String code;
        private String korean;

        Main(String code, String korean) {
            this.code = code;
            this.korean = korean;
        }

        public String getCode() {
            return code;
        }

        public String getKorean() {
            return korean;
        }
    }

    public enum ROUTE_CRITERIA {
        SHORTEST_PATH,
        SHORTEST_TIME,
        BACK,
    }
}

package subway.controller.button;

public enum MainButton {

        FIND_PATH("1", "경로 조회", null),
        EXIT("Q", "종료", null),
        ;

        private final String input;
        private final String description;
        private final Runnable method;

        MainButton(String input, String description, Runnable method) {
            this.input = input;
            this.description = description;
            this.method = method;
        }
}

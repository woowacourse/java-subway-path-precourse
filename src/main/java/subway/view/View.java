package subway.view;

public abstract class View {
    abstract void printViewGuide();

    abstract void validationCommand(String command);

    abstract void doCommand(String command);

    void printInputGuide() {
        System.out.println("## 원하는 기능을 선택하세요.");
    }

    void printApplicationShutDown() {
        System.out.println("[INFO] 애플리케이션을 종료합니다.");
    }
}
package subway;

import subway.page.MainPage;

/**
 * @author yhh1056
 * @since 2020/12/19
 */
public class SubwayApplication {
    private MainPage mainPage;

    public SubwayApplication() {
        this.mainPage = new MainPage();
    }

    public void run() {
        mainPage.start();
    }
}

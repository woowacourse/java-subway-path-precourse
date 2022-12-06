package subway.domain.section;

public class LineSectionController {
    private static final LineSectionService lineSectionService = new LineSectionService();

    public void setUp() {
        lineSectionService.setUp();
    }
}
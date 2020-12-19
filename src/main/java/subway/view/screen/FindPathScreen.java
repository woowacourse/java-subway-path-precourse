package subway.view.screen;

import subway.SectionService;
import subway.WeightType;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;

public class FindPathScreen {
    private static final String WEIGHT_STANDARD = "경로 기준";

    public void show() {
        OutputView.printlnGuide(WEIGHT_STANDARD);
        Arrays.stream(WeightType.values())
                .forEach(type -> OutputView.printTypeList(type.getCommand(), type.getTypeName()));
    }

    public void logic(InputView inputView) {
        SectionService sectionService = new SectionService();
        String command = inputView.scanWeithTypeCommand();
        sectionService.findPath(command, inputView);
    }
}

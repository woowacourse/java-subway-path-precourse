package subway.view.screen;

import org.jgrapht.GraphPath;
import subway.view.OutputView;
import subway.view.Prefix;

import java.util.Arrays;
import java.util.List;

public class SearchView {
    private static final String MAIN = Prefix.SHARP.getPrefix() + "경로 기준";
    private static final String DISTANCE = Prefix.ONE.getPrefix() + "최단 거리";
    private static final String TIME = Prefix.TWO.getPrefix() + "최소 시간";
    private static final String BACK = Prefix.BACK.getPrefix() + "돌아가기";
    private static final String PRINT_ADD = "출발역을 입력하세요.";
    private static final String PRINT_ADD_SECOND = "도착역을 입력하세요.";
    private static final String PRINT_AFTER_ADD = "조회결과";

    private final OutputView outputView;

    public SearchView(OutputView outputView) {
        this.outputView = outputView;
    }

    public void showOptions() {
        outputView.printOptions(new String[]{MAIN, DISTANCE, TIME, BACK});
    }

    public void printAdd() {
        outputView.printSharp(PRINT_ADD);
    }

    public void printAfterAdd() {
        outputView.printSharp(PRINT_AFTER_ADD);
    }

    public void printSecondAdd() {
        outputView.printSharp(PRINT_ADD_SECOND);
    }

    public void printList(GraphPath path, double pathWeight) {
        outputView.printInfos(Prefix.CONTOUR.getPrefix());
        outputView.printInfos("총 거리: " + pathWeight + "km");
        outputView.printInfos(Prefix.CONTOUR.getPrefix());

        String paths = path.getEdgeList().toString();
        String[] split = paths.split(" : ");

        for (String singlePath : split) {
            outputView.printInfos(singlePath);
        }
    }
}

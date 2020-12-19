package subway.controller;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import subway.domain.*;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;
import java.util.Objects;

import static subway.domain.InitSetting.initSetting;

public class SubwayController {
    public void run(InputView inputView) {
        initSetting();

        while(true) {
            OutputView.printMain();
            if (MainAction.isFinish(inputView.receiveAction())) {
                break;
            }

            OutputView.printPathAction();
            if (PathAction.isBack(inputView.receiveAction())) {
                break;
            }

        }
    }
}

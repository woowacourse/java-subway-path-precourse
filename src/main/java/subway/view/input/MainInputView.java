package subway.view.input;

import subway.util.MainViewUtil;
import subway.view.component.InputViewComponent;

import java.util.Scanner;

public class MainInputView {
    private final Scanner scanner;

    public MainInputView(Scanner scanner){
        this.scanner = scanner;
    }

    public String getTargetFeature(){
        System.out.println("## 원하는 기능을 선택하세요.");
        String feature = scanner.nextLine();
        if(!feature.equals(MainViewUtil.getBtnExit()) && !feature.equals(MainViewUtil.getBtnSelectPath())){
            // TODO throw unsupported Input exception
        }
        return feature;
    }
}

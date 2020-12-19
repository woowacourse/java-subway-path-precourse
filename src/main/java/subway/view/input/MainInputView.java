package subway.view.input;

import subway.exception.UnsupportedFeatureException;
import subway.util.MainViewUtil;

import java.util.Scanner;

public class MainInputView {
    private final Scanner scanner;

    public MainInputView(Scanner scanner){
        this.scanner = scanner;
    }

    public String getMenuTargetFeature(){
        System.out.println("## 원하는 기능을 선택하세요.");
        String feature = scanner.nextLine();
        System.out.println();
        if(!feature.equals(MainViewUtil.getBtnExit()) && !feature.equals(MainViewUtil.getBtnSelectPath())){
            throw new UnsupportedFeatureException();
        }
        return feature;
    }
}

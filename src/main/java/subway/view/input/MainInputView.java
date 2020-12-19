package subway.view.input;

import subway.exception.UnsupportedFeatureException;
import subway.util.MainViewUtil;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MainInputView {
    private final Scanner scanner;
    private Set<String> allowedMenuInput = new HashSet<>();

    public MainInputView(Scanner scanner){
        this.scanner = scanner;
        allowedMenuInput.add(MainViewUtil.getBtnSelectPath());
        allowedMenuInput.add(MainViewUtil.getBtnSelectPath());
    }

    public String getMenuTargetFeature(){
        System.out.println("## 원하는 기능을 선택하세요.");
        String feature = scanner.nextLine();
        System.out.println();
        if(!allowedMenuInput.contains(feature)){
            throw new UnsupportedFeatureException();
        }
        return feature;
    }
}

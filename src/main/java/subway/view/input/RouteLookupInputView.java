package subway.view.input;

import subway.exception.UnsupportedFeatureException;
import subway.util.RouteLookupViewUtil;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RouteLookupInputView {
    private final Scanner scanner;
    private Set<String> allowedMenuInput = new HashSet<>();

    public RouteLookupInputView(Scanner scanner){
        this.scanner = scanner;
        allowedMenuInput.add(RouteLookupViewUtil.getBtnMinimumDistance());
        allowedMenuInput.add(RouteLookupViewUtil.getBtnMinimumTime());
        allowedMenuInput.add(RouteLookupViewUtil.getBtnBack());
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

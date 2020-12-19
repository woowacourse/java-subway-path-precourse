package subway.output;

import java.util.List;

/**
 * @author yhh1056
 * @since 2020/12/19
 */
public class OutputView {

    public static void printPage(List<String> mainPageItem) {
        for (String item : mainPageItem) {
            System.out.println(item);
        }
    }
}

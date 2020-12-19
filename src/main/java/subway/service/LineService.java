package subway.service;

import java.util.Arrays;
import java.util.List;
import subway.domain.Line;
import subway.domain.LineRepository;

/*
 * 지하철 노선에 관련된 기능을 관리하는 클래스
 *
 * @author 483759@naver.com / 윤이진
 * @version 1.0 2020/12/19
 * */
public class LineService {

    private static final List<String> lineNameList = Arrays
        .asList("2호선", "3호선", "신분당선");

    public LineService() {
        initialize();
    }

    public static void initialize() {
        for (String lineName : lineNameList) {
            if (LineRepository.contains(lineName)) {
                continue;
            }
            if (!validateName(lineName)) {
                continue;
            }
            Line line = new Line(lineName);
            LineRepository.addLine(line);
        }
    }

    public static boolean validateName(String name) {
        Character lastCharacter = name.charAt(name.length() - 1);
        if (lastCharacter.equals('선')) {
            return true;
        }
        return false;
    }
}

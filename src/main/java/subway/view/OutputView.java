package subway.view;

import subway.dto.PathResponseDto;

import java.util.List;

public class OutputView {
    private static final String MAIN_DISPLAY = "\n## 메인 화면\n1. 경로 조회\nQ. 종료";
    private static final String PATH_SEARCH_DISPLAY = "\n## 경로 기준\n1. 최단 거리\n2. 최소 시간\nB. 돌아가기";
    private static final String RESULT_PRINT_HEADER = "\n## 조회 결과";
    private static final String TOTAL_DISTANCE_FORMAT = "\n[INFO] 총 거리 : %dkm";
    private static final String TOTAL_TIME_FORMAT = "\n[INFO] 총 소요 시간 : %d분";
    private static final String RESULT_PRINT_DELIMITER = "\n[INFO] ---";
    private static final String INFORMATION_MESSAGE_FORMAT = "\n[INFO] %s";
    private static final String ERROR_MESSAGE_FORMAT = "\n[ERROR] %s\n";

    private OutputView() {
    }

    public static void printMainDisplay() {
        System.out.println(MAIN_DISPLAY);
    }

    public static void printPathSearchDisplay() {
        System.out.println(PATH_SEARCH_DISPLAY);
    }

    public static void printErrorMessage(RuntimeException runtimeException) {
        System.out.printf(ERROR_MESSAGE_FORMAT, runtimeException.getMessage());
    }

    public static void printPathResult(PathResponseDto pathResponseDto) {
        System.out.print(RESULT_PRINT_HEADER);
        System.out.print(RESULT_PRINT_DELIMITER);
        System.out.printf(TOTAL_DISTANCE_FORMAT, pathResponseDto.getDistanceTotal());
        System.out.printf(TOTAL_TIME_FORMAT, pathResponseDto.getTimeTotal());
        System.out.print(RESULT_PRINT_DELIMITER);
        List<String> stationNames = pathResponseDto.getStationNames();
        stationNames.forEach(stationName -> System.out.printf(INFORMATION_MESSAGE_FORMAT, stationName));
        System.out.println();
    }
}

package subway;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import subway.validator.Validator;

import java.util.Scanner;

public class ValidatorTest {
    static Scanner unableInput;
    static Scanner wrongStation;
    static Scanner equalStation;

    @BeforeAll
    public static void setUp() {
        unableInput = new Scanner("4");
        wrongStation = new Scanner("홍대입구역");
        equalStation = new Scanner("강남역");
    }

    @AfterAll
    public static void tearDown() {
        unableInput.close();
        wrongStation.close();
        equalStation.close();
    }

    @Test
    public void isInputRightTest() {
        String input = unableInput.next();

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> {Validator.isInputRight(input);})
                .withMessage("[ERROR] 선택할 수 없는 기능입니다.");
    }

    @Test
    public void isMainInputRightTest() {
        String input = unableInput.next();

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> {Validator.isMainInputRight(input);})
                .withMessage("[ERROR] 선택할 수 없는 기능입니다.");
    }

    @Test
    public void isStationExistTest() {
        String input = wrongStation.next();

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> {Validator.isStationExist(input);})
                .withMessage("[ERROR] 등록되지 않은 역 이름입니다.");
    }

    @Test
    public void isStationEqualsTest() {
        String input = equalStation.next();

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> {Validator.isStationEquals(input, input);})
                .withMessage("[ERROR] 출발역과 도착역이 동일합니다.");
    }
}

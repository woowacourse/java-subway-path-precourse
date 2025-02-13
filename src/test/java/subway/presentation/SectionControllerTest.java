package subway.presentation;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SectionControllerTest {
    private final SectionController sectionController = new SectionController();

    @Test
    public void addSection__InputEssentialDistanceException() {
        String lineName = "line";
        String sourceName = "source";
        String sinkName = "sink";
        String time = "0";
        String message = "거리 입력은 필수입니다.";
        assertThatThrownBy(
            () -> this.sectionController.addSection(lineName, sourceName, sinkName, null, time)).isInstanceOf(
            IllegalArgumentException.class).hasMessage(message);
        assertThatThrownBy(
            () -> this.sectionController.addSection(lineName, sourceName, sinkName, "", time)).isInstanceOf(
            IllegalArgumentException.class).hasMessage(message);
    }

    @Test
    public void addSection__OnlyPossibleNumericInputDistanceException() {
        String lineName = "line";
        String sourceName = "source";
        String sinkName = "sink";
        String time = "0";
        String message = "거리는 숫자 형식의 입력만 가능합니다.";
        assertThatThrownBy(
            () -> this.sectionController.addSection(lineName, sourceName, sinkName, "distance", time)).isInstanceOf(
            IllegalArgumentException.class).hasMessage(message);
    }

    @Test
    public void addSection__InputEssentialTimeException() {
        String lineName = "line";
        String sourceName = "source";
        String sinkName = "sink";
        String distance = "0";
        String message = "시간 입력은 필수입니다.";
        assertThatThrownBy(
            () -> this.sectionController.addSection(lineName, sourceName, sinkName, distance, null)).isInstanceOf(
            IllegalArgumentException.class).hasMessage(message);
        assertThatThrownBy(
            () -> this.sectionController.addSection(lineName, sourceName, sinkName, distance, "")).isInstanceOf(
            IllegalArgumentException.class).hasMessage(message);
    }

    @Test
    public void addSection__OnlyPossibleNumericInputTimeException() {
        String lineName = "line";
        String sourceName = "source";
        String sinkName = "sink";
        String distance = "0";
        String message = "시간은 숫자 형식의 입력만 가능합니다.";
        assertThatThrownBy(
            () -> this.sectionController.addSection(lineName, sourceName, sinkName, distance, "time")).isInstanceOf(
            IllegalArgumentException.class).hasMessage(message);
    }
}

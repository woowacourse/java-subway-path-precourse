package subway.application.section.service;

import static org.assertj.core.api.Assertions.*;

import org.jgrapht.GraphPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import subway.domain.line.Line;
import subway.domain.section.Section;
import subway.domain.station.Station;

public class ShortDistanceServiceTest {
    private final Line line = new Line("line");
    private final Station source = new Station("source");
    private final Station sink = new Station("sink");

    private final ShortDistanceService shortDistanceService = new ShortDistanceService();

    @Test
    public void addNode() {
        assertThat(this.shortDistanceService.findAllNode()).hasSize(0);
        this.shortDistanceService.addNode(this.source);
        assertThat(this.shortDistanceService.findAllNode()).hasSize(1);
    }

    @Test
    public void addNode_AlreadyExistsNodeException() {
        String message = "이미 등록되어있는 노드입니다.";
        this.shortDistanceService.addNode(this.source);
        assertThatThrownBy(() -> this.shortDistanceService.addNode(this.source)).isInstanceOf(
            IllegalArgumentException.class).hasMessage(message);
    }

    @Test
    public void addEdge() {
        Section section = new Section(this.line, this.source, this.sink, 0, 0);
        this.shortDistanceService.addNode(this.source);
        this.shortDistanceService.addNode(this.sink);
        assertThat(this.shortDistanceService.findAllEdge()).hasSize(0);
        this.shortDistanceService.addEdge(section);
        assertThat(this.shortDistanceService.findAllEdge()).hasSize(1);
    }

    @Test
    public void addEdge_NotExistsSourceNodeException() {
        Section section = new Section(this.line, this.source, this.sink, 0, 0);
        String message = "존재하지 않은 시작노드입니다.";
        this.shortDistanceService.addNode(this.sink);
        assertThatThrownBy(() -> this.shortDistanceService.addEdge(section)).isInstanceOf(
            IllegalArgumentException.class).hasMessage(message);
    }

    @Test
    public void addEdge_NotExistsSinkNodeException() {
        Section section = new Section(this.line, this.source, this.sink, 0, 0);
        String message = "존재하지 않은 종료노드입니다.";
        this.shortDistanceService.addNode(this.source);
        assertThatThrownBy(() -> this.shortDistanceService.addEdge(section)).isInstanceOf(
            IllegalArgumentException.class).hasMessage(message);
    }

    @Test
    public void addEdge_AlreadyExistsEdgeException() {
        Section section = new Section(this.line, this.source, this.sink, 0, 0);
        String message = "이미 등록되어있는 간선입니다.";
        this.shortDistanceService.addNode(this.source);
        this.shortDistanceService.addNode(this.sink);
        this.shortDistanceService.addEdge(section);
        assertThatThrownBy(() -> this.shortDistanceService.addEdge(section)).isInstanceOf(
            IllegalArgumentException.class).hasMessage(message);
    }

    @Test
    public void compute() {
        int distance = 7;
        Section section = new Section(this.line, this.source, this.sink, distance, 0);
        this.shortDistanceService.addNode(this.source);
        this.shortDistanceService.addNode(this.sink);
        this.shortDistanceService.addEdge(section);
        GraphPath<Station, DefaultWeightedEdge> graphPath = this.shortDistanceService.compute(this.source, this.sink);
        assertThat(graphPath.getWeight()).isEqualTo(distance);
        assertThat(graphPath.getVertexList()).containsExactly(this.source, this.sink);
    }

    @Test
    public void compute__NotExistsSourceNodeException() {
        String message = "존재하지 않은 시작노드입니다.";
        this.shortDistanceService.addNode(this.sink);
        assertThatThrownBy(() -> this.shortDistanceService.compute(this.source, this.sink)).isInstanceOf(
            IllegalArgumentException.class).hasMessage(message);
    }

    @Test
    public void compute__NotExistsSinkNodeException() {
        String message = "존재하지 않은 종료노드입니다.";
        this.shortDistanceService.addNode(this.source);
        assertThatThrownBy(() -> this.shortDistanceService.compute(this.source, this.sink)).isInstanceOf(
            IllegalArgumentException.class).hasMessage(message);
    }

    @AfterEach
    public void init() {
        this.shortDistanceService.deleteAll();
    }
}

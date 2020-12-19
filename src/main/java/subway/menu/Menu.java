package subway.menu;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.SectionRepository;

import java.util.List;

public class Menu {
    public enum Main {
        ROUTE_INQUIRY("1", "경로조회"),
        QUIT("Q", "종료");

        private String code;
        private String korean;

        Main(String code, String korean) {
            this.code = code;
            this.korean = korean;
        }

        public String getCode() {
            return code;
        }

        public String getKorean() {
            return korean;
        }
    }

    public enum ROUTE_CRITERIA {
        SHORTEST_PATH("1", "최단 거리"),
        SHORTEST_TIME("2", "최소 시간"),
        BACK("B", "돌아가기");

        private String code;
        private String korean;

        ROUTE_CRITERIA(String code, String korean) {
            this.code = code;
            this.korean = korean;
        }

        public String getCode() {
            return code;
        }

        public String getKorean() {
            return korean;
        }
    }
}

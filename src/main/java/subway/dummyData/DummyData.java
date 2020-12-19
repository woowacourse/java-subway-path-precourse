package subway.dummyData;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class DummyData {
	private static final String GYODAE_STATION = "교대역";
	private static final String GANNAM_STATION = "강남역";
	private static final String YEOKSAM_STATION = "역삼역";
	private static final String SOUTH_TERMINAL_STATION = "남부터미널역";
	private static final String YANGJAE_STATION = "양재역";
	private static final String MAEBONG_STATION = "매봉역";
	private static final String YANGJAE_CITIZENS_FOREST_STATION = "양재시민의숲역";

	private static final String LINE_TWO = "2호선";
	private static final String LINE_THREE = "3호선";
	private static final String LINE_SINBUNDANG = "신분당선";

	Station station0 = new Station(GYODAE_STATION);
	Station station1 = new Station(GANNAM_STATION);
	Station station2 = new Station(YEOKSAM_STATION);
	Station station3 = new Station(SOUTH_TERMINAL_STATION);
	Station station4 = new Station(YANGJAE_STATION);
	Station station5 = new Station(MAEBONG_STATION);
	Station station6 = new Station(YANGJAE_CITIZENS_FOREST_STATION);

	Line lineTwo = new Line(LINE_TWO);
	Line lineThree = new Line(LINE_THREE);
	Line lineSinbundang = new Line(LINE_SINBUNDANG);

	public void init() {

		StationRepository.addStation(station0);
		StationRepository.addStation(station1);
		StationRepository.addStation(station2);
		StationRepository.addStation(station3);
		StationRepository.addStation(station4);
		StationRepository.addStation(station5);
		StationRepository.addStation(station6);
		LineRepository.addLine(lineTwo);
		LineRepository.addLine(lineThree);
		LineRepository.addLine(lineSinbundang);

		lineTwo.addSection(GYODAE_STATION);
		lineTwo.addSection(GANNAM_STATION);
		lineTwo.addSection(YEOKSAM_STATION);

		lineThree.addSection(GYODAE_STATION);
		lineThree.addSection(SOUTH_TERMINAL_STATION);
		lineThree.addSection(YANGJAE_STATION);
		lineThree.addSection(MAEBONG_STATION);

		lineSinbundang.addSection(GANNAM_STATION);
		lineSinbundang.addSection(YANGJAE_STATION);
		lineSinbundang.addSection(YANGJAE_CITIZENS_FOREST_STATION);

	}
}

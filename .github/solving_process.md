# 🧐 지하철 노선도 경로 조회 미션

[우아한테크코스](https://github.com/woowacourse) precourse 문제
중 [지하철 노선도 경로 조회 미션](https://github.com/woowacourse/java-subway-path-precourse) 풀이 기록하기.

DDD 구조와 MVC 패턴을 적용하여 TDD 방식으로 개발하고, 입출력 및 프로그래밍 요구사항을 부합하도록 풀어 볼 예정.

## 0. 설계

### application

|  비즈니스   | 기능                                                                |
|:-------:|:------------------------------------------------------------------|
| section | - 구간 CRUD<br/> - 그래프 노드 추가<br/> - 최단거리 경로 구하기 <br/> - 최소시간 경로 구하기 |

### domain

|  비즈니스   | 기능                     |
|:-------:|:-----------------------|
|  line   | - 노선 객체<br/> - 노선 CRUD |
| section | - 구간 객체<br/> - 구간 CRUD |
| station | - 역 객체<br/> - 역 CRUD   |

### infrastructure

|      클래스      | 기능                      |
|:-------------:|:------------------------|
|  FileParser   | - abstract<br/> - 파일 검증 |
| XmlFileParser | - xml 파일 로드 및 데이터 파싱    |

### presentation

|         클래스         | 기능                             |
|:-------------------:|:-------------------------------|
|   ViewController    | - interface                    |
| IntroViewController | - 도메인 데이터 초기화<br/> - 인트로 화면 제어 |
| MainViewController  | - 메인 화면 제어                     |
| PathViewController  | - 경로 기준(화면) 제어                 |
|   LineController    | - 노선 비즈니스 처리                   |
|  SectionController  | - 구간 비즈니스 처리                   |
|  StationController  | - 역 비즈니스 처리                    |
| ShortCostController | - 최단(최소) 경로 처리                 |

### ui

|   클래스   | 기능          |
|:-------:|:------------|
| Console | - 콘솔 입출력 처리 |

### view

|        클래스        | 기능                                              |
|:-----------------:|:------------------------------------------------|
|       View        | - interface                                     |
|     MenuView      | - 메뉴 출력<br/> - 항목 입력 <br/> - 메뉴 선택 이벤트 발생       |
|       Menu        | - interface<br/> - 메뉴 목록 조회<br/> - 명령어 기준 단건 조회 |
| MenuEventRegister | - 메뉴 선택 이벤트 처리 등록                               |

### util

|    클래스     | 기능          |
|:----------:|:------------|
| Validation | - 공통 유효성 검증 |

## 1. Line CRUD

```java
// LineDTOTest.java

package subway.domain.line;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LineDTOTest {
    @Test
    public void constructor__LineNameEssentialException() {
        String message = "노선 이름은 필수입니다.";
        assertThatThrownBy(() -> new LineDTO(null)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
        assertThatThrownBy(() -> new LineDTO("")).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
    }
}
```

```java
// LineDTO.java

package subway.domain.line;

public class LineDTO {
    private static final String LINE_NAME_ESSENTIAL_MESSAGE = "노선 이름은 필수입니다.";

    private final String name;

    public LineDTO(String name) {
        this.validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(LINE_NAME_ESSENTIAL_MESSAGE);
        }
    }

    public String getName() {
        return this.name;
    }
}
```

다양한 계층에서 쓰일 기본 LineDTO 구현.

```java
// LineService.java

package subway.domain.line;

import java.util.List;

public class LineService {
    public List<Line> findAll() {
        return LineRepository.lines();
    }

    public void deleteAll() {
        LineRepository.deleteAll();
    }
}
```

기본 전체 조회 및 삭제 기능 생성.

### 1-1. CREATE

```java
// LineRepositoryTest.java

package subway.domain.line;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LineRepositoryTest {
    @Test
    public void exists() {
        Line line = new Line("test");
        assertThat(LineRepository.exists(line)).isEqualTo(false);
        LineRepository.addLine(line);
        assertThat(LineRepository.exists(line)).isEqualTo(true);
    }

    @AfterEach
    public void init() {
        LineRepository.deleteAll();
    }
}
```

```java
// LineRepository.java

package subway.domain.line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    public static boolean exists(Line other) {
        return lines.stream().anyMatch(line -> line.getName().equals(other.getName()));
    }
}
```

노선 중복 생성 방지를 위해 이름 기준으로 존재 여부 확인 기능 구현.

```java
// LineServiceTest.java

package subway.domain.line;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LineServiceTest {
    private final LineService lineService = new LineService();

    @Test
    public void addLine() {
        LineDTO lineDTO = new LineDTO("test");
        assertThat(lineService.findAll()).hasSize(0);
        this.lineService.addLine(lineDTO);
        assertThat(lineService.findAll()).hasSize(1);
    }

    @Test
    public void addLine__AlreadyExistsLineException() {
        LineDTO lineDTO = new LineDTO("test");
        String message = "이미 등록되어있는 노선입니다.";
        this.lineService.addLine(lineDTO);
        assertThatThrownBy(() -> this.lineService.addLine(lineDTO)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
    }

    @AfterEach
    public void init() {
        this.lineService.deleteAll();
    }
}
```

```java
// LineService.java

package subway.domain.line;

import java.util.List;

public class LineService {
    private static final String ALREADY_EXISTS_LINE_MESSAGE = "이미 등록되어있는 노선입니다.";

    public void addLine(LineDTO lineDTO) {
        Line line = new Line(lineDTO.getName());
        if (LineRepository.exists(line)) {
            throw new IllegalArgumentException(ALREADY_EXISTS_MESSAGE);
        }
        LineRepository.addLine(line);
    }
}
```

노선 추가 기능 구현.

```java
// LineController.java

package subway.presentation;

import subway.domain.line.LineDTO;
import subway.domain.line.LineService;

public class LineController {
    private final LineService lineService = new LineService();

    public void addLine(String lineName) {
        LineDTO lineDTO = new LineDTO(lineName);
        this.lineService.addLine(lineDTO);
    }
}
```

제어 계층에 노선 추가 기능 매핑.

### 1-2. READ

```java
// LineRepositoryTest.java

package subway.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import subway.domain.line.Line;
import subway.domain.line.LineRepository;

public class LineRepositoryTest {
    @Test
    public void findByName() {
        String name = "test";
        Line line = new Line(name);
        assertThat(LineRepository.findByName(name)).isNotPresent();
        LineRepository.addLine(line);
        assertThat(LineRepository.findByName(name)).isPresent();
    }
}
```

```java
// LineRepository.java

package subway.domain.line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class LineRepository {
    public static Optional<Line> findByName(String name) {
        return lines.stream().filter(line -> line.getName().equals(name)).findFirst();
    }
}
```

```java
// LineServiceTest.java

package subway.domain.line;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LineServiceTest {
    @Test
    public void findOneByName() {
        String name = "test";
        LineDTO lineDTO = new LineDTO(name);
        this.lineService.addLine(lineDTO);
        Line line = this.lineService.findOneByName(name);
        assertThat(line.getName()).isEqualTo(name);
    }

    @Test
    public void findOneByName__NotExistsLineException() {
        String message = "존재하지 않은 노선입니다.";
        assertThatThrownBy(() -> this.lineService.findOneByName("test")).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
    }
}
```

```java
// LineService.java

package subway.domain.line;

import java.util.List;

public class LineService {
    private static final String NOT_EXISTS_LINE_MESSAGE = "존재하지 않은 노선입니다.";

    public Line findOneByName(String name) {
        return LineRepository.findByName(name).orElseThrow(() -> new IllegalArgumentException(NOT_EXISTS_MESSAGE));
    }
}
```

노선 이름 기준 단건 조회 기능 구현.

## 2. Station CRUD

```java
// StationDTOTest.java

package subway.domain.station;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StationDTOTest {
    @Test
    public void constructor__StationNameEssentialException() {
        String message = "역 이름은 필수입니다.";
        assertThatThrownBy(() -> new StationDTO(null)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
        assertThatThrownBy(() -> new StationDTO("")).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
    }
}
```

```java
// StationDTO.java

package subway.domain.station;

public class StationDTO {
    private static final String STATION_NAME_ESSENTIAL_MESSAGE = "역 이름은 필수입니다.";

    private final String name;

    public StationDTO(String name) {
        this.validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(STATION_NAME_ESSENTIAL_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }
}
```

다양한 계층에서 쓰일 기본 StationDTO 구현.

```java
// StationService.java

package subway.domain.station;

import java.util.List;

public class StationService {
    public List<Station> findAll() {
        return StationRepository.stations();
    }

    public void deleteAll() {
        StationRepository.deleteAll();
    }
}

```

기본 전체 조회 및 삭제 기능 생성.

### 2-1. CREATE

```java
// StationRepositoryTest.java

package subway.domain.station;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StationRepositoryTest {
    @Test
    public void exists() {
        Station station = new Station("test");
        assertThat(StationRepository.exists(station)).isEqualTo(false);
        StationRepository.addStation(station);
        assertThat(StationRepository.exists(station)).isEqualTo(true);
    }

    @AfterEach
    public void init() {
        StationRepository.deleteAll();
    }
}
```

```java
// StationRepository.java

package subway.domain.station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class StationRepository {
    public static boolean exists(Station other) {
        return stations().stream().anyMatch(station -> station.getName().equals(other.getName()));
    }
}
```

역 중복 생성 방지를 위해 이름 기준으로 존재 여부 확인 기능 구현.

```java
// StationServiceTest.java

package subway.domain.station;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StationServiceTest {
    private final StationService stationService = new StationService();

    @Test
    public void addStation() {
        StationDTO stationDTO = new StationDTO("test");
        assertThat(this.stationService.findAll()).hasSize(0);
        this.stationService.addStation(stationDTO);
        assertThat(this.stationService.findAll()).hasSize(1);
    }

    @Test
    public void addStation__AlreadyExistsStationException() {
        StationDTO stationDTO = new StationDTO("test");
        String message = "이미 등록되어있는 역입니다.";
        this.stationService.addStation(stationDTO);
        assertThatThrownBy(() -> this.stationService.addStation(stationDTO)).isInstanceOf(
            IllegalArgumentException.class).hasMessage(message);
        this.stationService.deleteAll();
    }

    @AfterEach
    public void init() {
        this.stationService.deleteAll();
    }
}
```

```java
// StationService.java

package subway.domain.station;

import java.util.List;

public class StationService {
    private static final String ALREADY_EXISTS_STATION_MESSAGE = "이미 등록되어있는 역입니다.";

    public void addStation(StationDTO stationDTO) {
        Station station = new Station(stationDTO.getName());
        if (StationRepository.exists(station)) {
            throw new IllegalArgumentException(ALREADY_EXISTS_STATION_MESSAGE);
        }
        StationRepository.addStation(station);
    }
}
```

역 추가 기능 구현.

```java
// StationController.java

package subway.presentation;

import subway.domain.station.StationDTO;
import subway.domain.station.StationService;

public class StationController {
    private final StationService stationService = new StationService();

    public void addStation(String name) {
        StationDTO stationDTO = new StationDTO(name);
        stationService.addStation(stationDTO);
    }
}
```

제어 계층에 역 추가 기능 매핑.

### 2-2. READ

```java
// StationRepositoryTest.java

package subway.domain.station;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StationRepositoryTest {
    @Test
    public void findByName() {
        String name = "test";
        Station station = new Station(name);
        assertThat(StationRepository.findByName(name)).isNotPresent();
        StationRepository.addStation(station);
        assertThat(StationRepository.findByName(name)).isPresent();
    }
}
```

```java
// StationRepository.java

package subway.domain.station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class StationRepository {
    public static Optional<Station> findByName(String name) {
        return stations.stream().filter(station -> station.getName().equals(name)).findFirst();
    }
}
```

```java
// StationRepositoryTest.java

package subway.domain.station;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StationServiceTest {
    @Test
    public void findOneByName() {
        String name = "test";
        StationDTO stationDTO = new StationDTO(name);
        this.stationService.addStation(stationDTO);
        Station station = this.stationService.findOneByName(name);
        assertThat(station.getName()).isEqualTo(name);
    }

    @Test
    public void findOneByName__NotExistsStationException() {
        String message = "존재하지 않은 역입니다.";
        assertThatThrownBy(() -> this.stationService.findOneByName("test")).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
    }
}
```

```java
// StationService.java

package subway.domain.station;

import java.util.List;

public class StationService {
    private static final String NOT_EXISTS_STATION_MESSAGE = "존재하지 않은 역입니다.";

    public Station findOneByName(String name) {
        return StationRepository.findByName(name)
            .orElseThrow(() -> new IllegalArgumentException(NOT_EXISTS_STATION_MESSAGE));
    }
}
```

역 이름 기준 단건 조회 기능 구현.

## 3. Section CRUD

```java
// Section.java

package subway.domain.section;

import subway.domain.line.Line;
import subway.domain.station.Station;

public class Section {
    private final Line line;
    private final Station source;
    private final Station sink;
    private final int distance;
    private final int time;

    public Section(Line line, Station source, Station sink, int distance, int time) {
        this.line = line;
        this.source = source;
        this.sink = sink;
        this.distance = distance;
        this.time = time;
    }

    public Line getLine() {
        return line;
    }

    public Station getSource() {
        return source;
    }

    public Station getSink() {
        return sink;
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }
}
```

구간 객체 생성.

```java
// LineTest.java

package subway.domain.line;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import subway.domain.section.Section;
import subway.domain.station.Station;

public class LineTest {
    @Test
    public void addSection() {
        Line line = new Line("line");
        Station source = new Station("source");
        Station sink = new Station("sink");
        Section section = new Section(line, source, sink, 0, 0);
        assertThat(line.getSectionList()).hasSize(0);
        line.addSection(section);
        assertThat(line.getSectionList()).hasSize(1);
    }

    @Test
    public void addSection__SectionAddingOtherLineReceiveException() {
        Line line = new Line("line");
        Line other = new Line("other");
        Station source = new Station("source");
        Station sink = new Station("sink");
        Section section = new Section(other, source, sink, 0, 0);
        String message = "구간 추가시 다른 노선을 받았습니다.";
        assertThatThrownBy(() -> line.addSection(section)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
    }
}
```

```java
// Line.java

package subway.domain.line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import subway.domain.section.Section;

public class Line {
    private static final String SECTION_ADDING_OTHER_LINE_RECEIVE_MESSAGE = "구간 추가시 다른 노선을 받았습니다.";

    private final List<Section> sectionList = new ArrayList<>();

    public void addSection(Section section) {
        this.validateSection(section);
        this.sectionList.add(section);
    }

    private void validateSection(Section section) {
        if (this != section.getLine()) {
            throw new IllegalArgumentException(SECTION_ADDING_OTHER_LINE_RECEIVE_MESSAGE);
        }
    }
}
```

Line 1 : N 매칭.

Section 추가 기능 구현.

```java
// StationTest.java

package subway.domain.station;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import subway.domain.line.Line;
import subway.domain.section.Section;

public class StationTest {
    @Test
    public void addSection() {
        Line line = new Line("line");
        Station source = new Station("source");
        Station sink = new Station("sink");
        Section section = new Section(line, source, sink, 0, 0);
        assertThat(source.getSectionList()).hasSize(0);
        source.addSection(section);
        assertThat(source.getSectionList()).hasSize(1);
    }

    @Test
    public void addSection__SectionAddingOtherSourceStationReceiveException() {
        Line line = new Line("line");
        Station source = new Station("source");
        Station other = new Station("other");
        Station sink = new Station("sink");
        Section section = new Section(line, other, sink, 0, 0);
        String message = "구간 추가시 다른 시작역을 받았습니다.";
        assertThatThrownBy(() -> source.addSection(section)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
    }
}
```

```java
// Station.java

package subway.domain.station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import subway.domain.section.Section;

public class Station {
    private static final String SECTION_ADDING_OTHER_SOURCE_STATION_RECEIVE_MESSAGE = "구간 추가시 다른 시작역을 받았습니다.";

    private final List<Section> sectionList = new ArrayList<>();

    public List<Section> getSectionList() {
        return Collections.unmodifiableList(this.sectionList);
    }

    public void addSection(Section section) {
        this.validateSection(section);
        this.sectionList.add(section);
    }

    public void validateSection(Section section) {
        if (this != section.getSource()) {
            throw new IllegalArgumentException(SECTION_ADDING_OTHER_SOURCE_STATION_RECEIVE_MESSAGE);
        }
    }
}
```

Station 1 : N 매칭.

Section 추가 기능 구현.

```java
// SectionDTOTest.java

package subway.application.section.dto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import subway.domain.line.LineDTO;
import subway.domain.station.StationDTO;

public class SectionDTOTest {
    @Test
    public void constructor__SectionAddingLineInfoEssentialException() {
        StationDTO sourceDTO = new StationDTO("source");
        StationDTO sinkDTO = new StationDTO("sink");
        String message = "구간 생성시 노선 정보는 필수입니다.";
        assertThatThrownBy(() -> new SectionDTO(null, sourceDTO, sinkDTO)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
    }

    @Test
    public void constructor__SectionAddingSourceStationInfoEssentialException() {
        LineDTO lineDTO = new LineDTO("line");
        StationDTO sinkDTO = new StationDTO("sink");
        String message = "구간 생성시 시작역 정보는 필수입니다.";
        assertThatThrownBy(() -> new SectionDTO(lineDTO, null, sinkDTO)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
    }

    @Test
    public void constructor__SectionAddingSinkStationInfoEssentialException() {
        LineDTO lineDTO = new LineDTO("line");
        StationDTO sourceDTO = new StationDTO("source");
        String message = "구간 생성시 종료역 정보는 필수입니다.";
        assertThatThrownBy(() -> new SectionDTO(lineDTO, sourceDTO, null)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
    }
}
```

```java
// SectionDTO.java

package subway.application.section.dto;

import subway.domain.line.LineDTO;
import subway.domain.station.StationDTO;

public class SectionDTO {
    private static final String SECTION_ADDING_LINE_INFO_ESSENTIAL_MESSAGE = "구간 생성시 노선 정보는 필수입니다.";
    private static final String SECTION_ADDING_SOURCE_STATION_INFO_ESSENTIAL_MESSAGE = "구간 생성시 시작역 정보는 필수입니다.";
    private static final String SECTION_ADDING_SINK_STATION_INFO_ESSENTIAL_MESSAGE = "구간 생성시 종료역 정보는 필수입니다.";

    private final LineDTO lineDTO;
    private final StationDTO sourceDTO;
    private final StationDTO sinkDTO;
    private int distance;
    private int time;

    public SectionDTO(LineDTO lineDTO, StationDTO sourceDTO, StationDTO sinkDTO) {
        this(lineDTO, sourceDTO, sinkDTO, 0, 0);
    }

    public SectionDTO(LineDTO lineDTO, StationDTO sourceDTO, StationDTO sinkDTO, int distance, int time) {
        this.validate(lineDTO, sourceDTO, sinkDTO);
        this.lineDTO = lineDTO;
        this.sourceDTO = sourceDTO;
        this.sinkDTO = sinkDTO;
        this.distance = distance;
        this.time = time;
    }

    private void validate(LineDTO lineDTO, StationDTO sourceDTO, StationDTO sinkDTO) {
        if (lineDTO == null) {
            throw new IllegalArgumentException(SECTION_ADDING_LINE_INFO_ESSENTIAL_MESSAGE);
        }
        if (sourceDTO == null) {
            throw new IllegalArgumentException(SECTION_ADDING_SOURCE_STATION_INFO_ESSENTIAL_MESSAGE);
        }
        if (sinkDTO == null) {
            throw new IllegalArgumentException(SECTION_ADDING_SINK_STATION_INFO_ESSENTIAL_MESSAGE);
        }
    }

    public LineDTO getLineDTO() {
        return lineDTO;
    }

    public StationDTO getSourceDTO() {
        return sourceDTO;
    }

    public StationDTO getSinkDTO() {
        return sinkDTO;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
```

다양한 계층에서 쓰일 기본 SectionDTO 구현.

```java
// SectionRepository.java

package subway.domain.section;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SectionRepository {
    private static final List<Section> sections = new ArrayList<>();

    public static List<Section> sections() {
        return Collections.unmodifiableList(sections);
    }

    public static void deleteAll() {
        sections.clear();
    }
}
```

```java
// SectionService.java

package subway.application.section.service;

import java.util.List;

import subway.domain.section.Section;
import subway.domain.section.SectionRepository;

public class SectionService {
    public List<Section> findAll() {
        return SectionRepository.sections();
    }

    public void deleteAll() {
        SectionRepository.deleteAll();
    }
}
```

기본 전체 조회 및 삭제 기능 생성.

### 3-1. CREATE

```java
// SectionRepositoryTest.java

package subway.domain.section;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import subway.domain.line.Line;
import subway.domain.station.Station;

public class SectionRepositoryTest {
    @Test
    public void exists() {
        Line line = new Line("line");
        Station source = new Station("source");
        Station sink = new Station("sink");
        Section section = new Section(line, source, sink, 0, 0);
        assertThat(SectionRepository.exists(section)).isEqualTo(false);
        SectionRepository.addSection(section);
        assertThat(SectionRepository.exists(section)).isEqualTo(true);
    }

    @AfterEach
    public void init() {
        SectionRepository.deleteAll();
    }
}
```

```java
// SectionRepository.java

package subway.domain.section;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SectionRepository {
    public static void addSection(Section section) {
        sections.add(section);
    }

    public static boolean exists(Section other) {
        return sections.stream()
            .anyMatch(section -> section.getLine() == other.getLine() && section.getSource() == other.getSource()
                && section.getSink() == other.getSink());
    }
}
```

구간 데이터 추가 기능 구현.

구간 중복 생성 방지를 위해 노선, 시작역, 종료역 기준으로 존재 여부 확인 기능 구현.

```java
// SectionServiceTest.java

package subway.application.section.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import subway.application.section.dto.SectionDTO;
import subway.domain.line.Line;
import subway.domain.line.LineDTO;
import subway.domain.line.LineService;
import subway.domain.station.Station;
import subway.domain.station.StationDTO;
import subway.domain.station.StationService;

public class SectionServiceTest {
    private final LineDTO lineDTO = new LineDTO("line");
    private final StationDTO sourceDTO = new StationDTO("source");
    private final StationDTO sinkDTO = new StationDTO("sink");

    private final LineService lineService = new LineService();
    private final StationService stationService = new StationService();
    private final SectionService sectionService = new SectionService();

    @BeforeEach
    public void setup() {
        this.lineService.addLine(lineDTO);
        this.stationService.addStation(sourceDTO);
        this.stationService.addStation(sinkDTO);
    }

    @Test
    public void addSection() {
        Line line = this.lineService.findOneByName(lineDTO.getName());
        Station source = this.stationService.findOneByName(sourceDTO.getName());
        SectionDTO sectionDTO = new SectionDTO(lineDTO, sourceDTO, sinkDTO);
        assertThat(this.sectionService.findAll()).hasSize(0);
        assertThat(line.getSectionList()).hasSize(0);
        assertThat(source.getSectionList()).hasSize(0);
        this.sectionService.addSection(sectionDTO);
        assertThat(this.sectionService.findAll()).hasSize(1);
        assertThat(line.getSectionList()).hasSize(1);
        assertThat(source.getSectionList()).hasSize(1);
    }

    @Test
    public void addSection__AlreadyExistsSectionException() {
        SectionDTO sectionDTO = new SectionDTO(lineDTO, sourceDTO, sinkDTO);
        String message = "이미 등록되어있는 구간입니다.";
        this.sectionService.addSection(sectionDTO);
        assertThatThrownBy(() -> this.sectionService.addSection(sectionDTO)).isInstanceOf(
                IllegalArgumentException.class)
            .hasMessage(message);
    }

    @AfterEach
    public void init() {
        lineService.deleteAll();
        stationService.deleteAll();
        sectionService.deleteAll();
    }
}
```

```java
// SectionService.java

package subway.application.section.service;

import java.util.List;

import subway.application.section.dto.SectionDTO;
import subway.domain.line.Line;
import subway.domain.line.LineService;
import subway.domain.section.Section;
import subway.domain.section.SectionRepository;
import subway.domain.station.Station;
import subway.domain.station.StationService;

public class SectionService {
    private static final String ALREADY_EXISTS_SECTION_MESSAGE = "이미 등록되어있는 구간입니다.";

    private final LineService lineService = new LineService();
    private final StationService stationService = new StationService();

    public void addSection(SectionDTO sectionDTO) {
        Line line = this.lineService.findOneByName(sectionDTO.getLineDTO().getName());
        Station source = this.stationService.findOneByName(sectionDTO.getSourceDTO().getName());
        Station sink = this.stationService.findOneByName(sectionDTO.getSinkDTO().getName());
        Section section = new Section(line, source, sink, sectionDTO.getDistance(), sectionDTO.getTime());
        if (SectionRepository.exists(section)) {
            throw new IllegalArgumentException(ALREADY_EXISTS_SECTION_MESSAGE);
        }
        SectionRepository.addSection(section);
        line.addSection(section);
        source.addSection(section);
    }
}
```

구간 추가 기능 구현.

```java
// ValidationTest.java

package subway.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ValidationTest {
    @Test
    public void isNumeric() {
        assertThat(Validation.isNumeric("1")).isEqualTo(true);
        assertThat(Validation.isNumeric("")).isEqualTo(false);
        assertThat(Validation.isNumeric("number")).isEqualTo(false);
    }
}
```

```java
// Validation.java

package subway.util;

import java.util.regex.Pattern;

public final class Validation {
    private Validation() {
    }

    public static boolean isNumeric(String str) {
        return str != null && !str.isEmpty() && Pattern.matches("^[0-9]*$", str);
    }
}
```

숫자 형식의 문자열 확인 기능 구현.

```java
// SectionController.java

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
```

```java
// SectionController.java

package subway.presentation;

import subway.application.section.dto.SectionDTO;
import subway.application.section.service.SectionService;
import subway.domain.line.LineDTO;
import subway.domain.station.StationDTO;
import subway.util.Validation;

public class SectionController {
    private static final String INPUT_ESSENTIAL_DISTANCE_MESSAGE = "거리 입력은 필수입니다.";
    private static final String ONLY_POSSIBLE_NUMERIC_INPUT_DISTANCE_MESSAGE = "거리는 숫자 형식의 입력만 가능합니다.";
    private static final String INPUT_ESSENTIAL_TIME_MESSAGE = "시간 입력은 필수입니다.";
    private static final String ONLY_POSSIBLE_NUMERIC_INPUT_TIME_MESSAGE = "시간은 숫자 형식의 입력만 가능합니다.";

    private final SectionService sectionService = new SectionService();

    public void addSection(String lineName, String sourceName, String sinkName, String _distance, String _time) {
        LineDTO lineDTO = new LineDTO(lineName);
        StationDTO sourceDTO = new StationDTO(sourceName);
        StationDTO sinkDTO = new StationDTO(sinkName);
        this.validateDistance(_distance);
        int distance = Integer.parseInt(_distance);
        this.validateTime(_time);
        int time = Integer.parseInt(_time);
        SectionDTO sectionDTO = new SectionDTO(lineDTO, sourceDTO, sinkDTO, distance, time);
        this.sectionService.addSection(sectionDTO);
    }

    private void validateDistance(String distance) {
        if (distance == null || distance.trim().isEmpty()) {
            throw new IllegalArgumentException(INPUT_ESSENTIAL_DISTANCE_MESSAGE);
        }
        if (!Validation.isNumeric(distance)) {
            throw new IllegalArgumentException(ONLY_POSSIBLE_NUMERIC_INPUT_DISTANCE_MESSAGE);
        }
    }

    private void validateTime(String time) {
        if (time == null || time.trim().isEmpty()) {
            throw new IllegalArgumentException(INPUT_ESSENTIAL_TIME_MESSAGE);
        }
        if (!Validation.isNumeric(time)) {
            throw new IllegalArgumentException(ONLY_POSSIBLE_NUMERIC_INPUT_TIME_MESSAGE);
        }
    }
}
```

제어 계층에 구간 추가 기능 매핑.

## 4. 최단 거리 노드, 간선 추가

### 4-1. 노드

```java
// ShortDistanceService.java

package subway.application.section.service;

import java.util.Collections;
import java.util.Set;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.DirectedWeightedMultigraph;

import subway.domain.station.Station;

class shortDistanceService {
    private static final DirectedWeightedMultigraph<Station, DefaultWeightedEdge> graph = new DirectedWeightedMultigraph<>(
        DefaultWeightedEdge.class);

    protected Set<Station> findAllNode() {
        return Collections.unmodifiableSet(graph.vertexSet());
    }

    protected void deleteAllNode() {
        Set<Station> nodes = new HashSet<>(this.findAllNode());
        graph.removeAllVertices(nodes);
    }
}
```

기본 전체 조회 및 삭제 기능 생성.

```java
// ShortDistanceServiceTest.java

package subway.application.section.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import subway.domain.station.Station;

class shortDistanceServiceTest {
    private final Station source = new Station("source");

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

    @AfterEach
    public void init() {
        this.shortDistanceService.deleteAllNode();
    }
}
```

```java
// ShortDistanceService.java

package subway.application.section.service;

import java.util.Collections;
import java.util.Set;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.DirectedWeightedMultigraph;

import subway.domain.station.Station;

class shortDistanceService {
    private static final String ALREADY_EXISTS_NODE_MESSAGE = "이미 등록되어있는 노드입니다.";

    protected void addNode(Station station) {
        if (graph.containsVertex(station)) {
            throw new IllegalArgumentException(ALREADY_EXISTS_NODE_MESSAGE);
        }
        graph.addVertex(station);
    }
}
```

노선 추가 기능 구현.

```java
// SectionService.java

package subway.application.section.service;

import java.util.List;

import subway.application.section.dto.SectionDTO;
import subway.domain.line.Line;
import subway.domain.line.LineService;
import subway.domain.section.Section;
import subway.domain.section.SectionRepository;
import subway.domain.station.Station;
import subway.domain.station.StationDTO;
import subway.domain.station.StationService;

public class SectionService {
    private final ShortDistanceService shortDistanceService = new ShortDistanceService();

    public void addNode(StationDTO stationDTO) {
        Station station = this.stationService.findOneByName(stationDTO.getName());
        this.shortDistanceService.addNode(station);
    }
}
```

무분별한 노드 추가를 방지하기 위해 Section Service 계층을 통해서만 처리되도록 함.

## 4-2. 간선

```java
// ShortDistanceService.java

package subway.application.section.service;

import java.util.Collections;
import java.util.Set;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.DirectedWeightedMultigraph;

import subway.domain.station.Station;

class shortDistanceService {
    protected Set<DefaultWeightedEdge> findAllEdge() {
        return Collections.unmodifiableSet(graph.edgeSet());
    }

    protected void deleteAllEdge() {
        graph.removeAllEdges(graph.edgeSet());
    }

    protected void deleteAll() {
        this.deleteAllEdge();
        this.deleteAllNode();
    }
}
```

기본 전체 조회 및 삭제 기능 생성.

```java
// ShortDistanceServiceTest.java

package subway.application.section.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import subway.domain.line.Line;
import subway.domain.section.Section;
import subway.domain.station.Station;

class shortDistanceServiceTest {
    private final Line line = new Line("line");
    private final Station sink = new Station("sink");

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

    @AfterEach
    public void init() {
        this.shortDistanceService.deleteAll();
    }
}
```

```java
// ShortDistanceService.java

package subway.application.section.service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.DirectedWeightedMultigraph;

import subway.domain.section.Section;
import subway.domain.station.Station;

class shortDistanceService {
    private static final String NOT_EXISTS_SOURCE_NODE_MESSAGE = "존재하지 않은 시작노드입니다.";
    private static final String NOT_EXISTS_SINK_NODE_MESSAGE = "존재하지 않은 종료노드입니다.";
    private static final String ALREADY_EXISTS_EDGE_MESSAGE = "이미 등록되어있는 간선입니다.";

    protected void addEdge(Section section) {
        Station source = section.getSource();
        Station sink = section.getSink();
        this.validateSource(source);
        this.validateSink(sink);
        if (graph.containsEdge(source, sink)) {
            throw new IllegalArgumentException(ALREADY_EXISTS_EDGE_MESSAGE);
        }
        graph.setEdgeWeight(graph.addEdge(source, sink), section.getDistance());
    }

    private void validateSource(Station source) {
        if (!graph.containsVertex(source)) {
            throw new IllegalArgumentException(NOT_EXISTS_SOURCE_NODE_MESSAGE);
        }
    }

    private void validateSink(Station sink) {
        if (!graph.containsVertex(sink)) {
            throw new IllegalArgumentException(NOT_EXISTS_SINK_NODE_MESSAGE);
        }
    }
}
```

간선 추가 기능 구현.

```java
// SectionService.java

package subway.application.section.service;

import java.util.List;

import subway.application.section.dto.SectionDTO;
import subway.domain.line.Line;
import subway.domain.line.LineService;
import subway.domain.section.Section;
import subway.domain.section.SectionRepository;
import subway.domain.station.Station;
import subway.domain.station.StationDTO;
import subway.domain.station.StationService;

public class SectionService {
    public void addSection(SectionDTO sectionDTO) {
        Line line = this.lineService.findOneByName(sectionDTO.getLineDTO().getName());
        Station source = this.stationService.findOneByName(sectionDTO.getSourceDTO().getName());
        Station sink = this.stationService.findOneByName(sectionDTO.getSinkDTO().getName());
        Section section = new Section(line, source, sink, sectionDTO.getDistance(), sectionDTO.getTime());
        if (SectionRepository.exists(section)) {
            throw new IllegalArgumentException(ALREADY_EXISTS_SECTION_MESSAGE);
        }
        SectionRepository.addSection(section);
        +shortDistanceService.addEdge(section);
        line.addSection(section);
        source.addSection(section);
    }
}
```

무분별한 간선 추가를 방지하기 위해 Section Service 계층을 통해서만 처리되도록 함.

## 5. 최단 거리 경로 구하기

```java
// ShortDistanceServiceTest.java

package subway.application.section.service;

import static org.assertj.core.api.Assertions.*;

import org.jgrapht.GraphPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import subway.domain.line.Line;
import subway.domain.section.Section;
import subway.domain.station.Station;

class shortDistanceServiceTest {
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
}
```

```java
// ShortDistanceService.java

package subway.application.section.service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.DirectedWeightedMultigraph;

import subway.domain.section.Section;
import subway.domain.station.Station;

class shortDistanceService {
    protected GraphPath<Station, DefaultWeightedEdge> compute(Station source, Station sink) {
        this.validateSource(source);
        this.validateSink(sink);
        DijkstraShortestPath<Station, DefaultWeightedEdge> dijkstraShortestPath = new DijkstraShortestPath<>(graph);
        return dijkstraShortestPath.getPath(source, sink);
    }
}
```

최단 거리 경로 반환 기능 구현.

```java
// ShortCostRequestTest.java

package subway.application.section.dto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import subway.domain.station.StationDTO;

public class ShortCostRequestTest {
    @Test
    public void constructor__SourceStationInfoEssentialException() {
        StationDTO sinkDTO = new StationDTO("sink");
        String message = "시작역 정보는 필수입니다.";
        assertThatThrownBy(() -> new ShortCostRequest(null, sinkDTO)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
    }

    @Test
    public void constructor__SinkStationInfoEssentialException() {
        StationDTO sourceDTO = new StationDTO("source");
        String message = "종료역 정보는 필수입니다.";
        assertThatThrownBy(() -> new ShortCostRequest(sourceDTO, null)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
    }

    @Test
    public void constructor__SameSourceAndSinkStationException() {
        StationDTO sourceDTO = new StationDTO("same");
        StationDTO sinkDTO = new StationDTO("same");
        String message = "출발역과 도착역이 동일합니다.";
        assertThatThrownBy(() -> new ShortCostRequest(sourceDTO, sinkDTO)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
    }
}
```

```java
// StationDTO.java

package subway.domain.station;

import java.util.Objects;

public class StationDTO {
    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (!(object instanceof StationDTO))
            return false;
        StationDTO other = (StationDTO)object;
        return Objects.equals(this.name, other.name);
    }
}
```

동일 체크를 위해 이름 기준으로 비교되도록 equal 오버라이딩.

```java
// ShortCostRequest.java

package subway.application.section.dto;

import subway.domain.station.StationDTO;

public class ShortCostRequest {
    private static final String SOURCE_STATION_INFO_ESSENTIAL_MESSAGE = "시작역 정보는 필수입니다.";
    private static final String SINK_STATION_INFO_ESSENTIAL_MESSAGE = "종료역 정보는 필수입니다.";
    private static final String SAME_SOURCE_AND_SINK_STATION_MESSAGE = "출발역과 도착역이 동일합니다.";

    private final StationDTO sourceDTO;
    private final StationDTO sinkDTO;

    public ShortCostRequest(StationDTO sourceDTO, StationDTO sinkDTO) {
        this.validate(sourceDTO, sinkDTO);
        this.sourceDTO = sourceDTO;
        this.sinkDTO = sinkDTO;
    }

    private void validate(StationDTO sourceDTO, StationDTO sinkDTO) {
        if (sourceDTO == null) {
            throw new IllegalArgumentException(SOURCE_STATION_INFO_ESSENTIAL_MESSAGE);
        }
        if (sinkDTO == null) {
            throw new IllegalArgumentException(SINK_STATION_INFO_ESSENTIAL_MESSAGE);
        }
        if (sourceDTO.equals(sinkDTO)) {
            throw new IllegalArgumentException(SAME_SOURCE_AND_SINK_STATION_MESSAGE);
        }
    }

    public StationDTO getSourceDTO() {
        return sourceDTO;
    }

    public StationDTO getSinkDTO() {
        return sinkDTO;
    }
}
```

최단(최소) 경로 계산 요청 DTO 구현.

```java
// ShortCostResponseTest.java

package subway.application.section.dto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import subway.domain.line.Line;
import subway.domain.section.Section;
import subway.domain.station.Station;

public class ShortCostResponseTest {
    @Test
    public void constructor() {
        Line line = new Line("line");
        Station source = new Station("source");
        Station sink = new Station("sink");
        List<Station> stationList = Arrays.asList(source, sink);
        int distance = 1;
        int time = 8;
        Section section = new Section(line, source, sink, distance, time);
        source.addSection(section);
        ShortCostResponse shortCostResponse = new ShortCostResponse(stationList);
        assertThat(shortCostResponse.getTotalDistance()).isEqualTo(distance);
        assertThat(shortCostResponse.getTotalTime()).isEqualTo(time);
        assertThat(shortCostResponse.getStationNameList()).containsExactly(source.getName(), sink.getName());
    }
}
```

```java
// StationTest.java

package subway.domain.station;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import subway.domain.line.Line;
import subway.domain.section.Section;

public class StationTest {
    @Test
    public void findDistanceTo() {
        Line line = new Line("line");
        Station source = new Station("source");
        Station sink = new Station("sink");
        int distance = 1;
        Section section = new Section(line, source, sink, distance, 0);
        source.addSection(section);
        assertThat(source.findDistanceTo(sink)).isEqualTo(distance);
    }

    @Test
    public void findDistanceTo__NotExistsPathToSinkStationException() {
        Station source = new Station("source");
        Station sink = new Station("sink");
        String message = "종료역까지 경로가 존재하지 않습니다.";
        assertThatThrownBy(() -> source.findDistanceTo(sink)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
    }

    @Test
    public void findTimeTo() {
        Line line = new Line("line");
        Station source = new Station("source");
        Station sink = new Station("sink");
        int time = 8;
        Section section = new Section(line, source, sink, 0, time);
        source.addSection(section);
        assertThat(source.findTimeTo(sink)).isEqualTo(time);
    }

    @Test
    public void findTimeTo__NotExistsPathToSinkStationException() {
        Station source = new Station("source");
        Station sink = new Station("sink");
        String message = "종료역까지 경로가 존재하지 않습니다.";
        assertThatThrownBy(() -> source.findTimeTo(sink)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
    }
}
```

```java
// Station.java

package subway.domain.station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import subway.domain.section.Section;

public class Station {
    private static final String NOT_EXISTS_PATH_TO_SINK_STATION_MESSAGE = "종료역까지 경로가 존재하지 않습니다.";

    public int findDistanceTo(Station sink) {
        return this.sectionList.stream()
            .filter(section -> section.getSink() == sink)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(NOT_EXISTS_PATH_TO_SINK_STATION_MESSAGE))
            .getDistance();
    }

    public int findTimeTo(Station sink) {
        return this.sectionList.stream()
            .filter(section -> section.getSink() == sink)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(NOT_EXISTS_PATH_TO_SINK_STATION_MESSAGE))
            .getTime();
    }
}
```

지정 경로까지의 거리와 시간을 계산하기 위해 기능 구현.

```java
// ShortCostResponse.java

package subway.application.section.dto;

import java.util.ArrayList;
import java.util.List;

import subway.domain.station.Station;

public class ShortCostResponse {
    private int totalDistance;
    private int totalTime;
    private final List<String> stationNameList;

    public ShortCostResponse(List<Station> stationList) {
        this.stationNameList = new ArrayList<>();
        int length = stationList.size();
        for (int index = 0; index < length; index++) {
            Station source = stationList.get(index);
            if (index + 1 < length) {
                Station sink = stationList.get(index + 1);
                totalDistance += source.findDistanceTo(sink);
                totalTime += source.findTimeTo(sink);
            }
            stationNameList.add(source.getName());
        }
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(int totalDistance) {
        this.totalDistance = totalDistance;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public List<String> getStationNameList() {
        return stationNameList;
    }
}
```

지정 경로까지 총 거리, 시간과 위치 정보를 반환 할 수 있도록 구현.

```java
// SectionServiceTest.java

package subway.application.section.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import subway.application.section.dto.SectionDTO;
import subway.application.section.dto.ShortCostRequest;
import subway.application.section.dto.ShortCostResponse;
import subway.domain.line.Line;
import subway.domain.line.LineDTO;
import subway.domain.line.LineService;
import subway.domain.station.Station;
import subway.domain.station.StationDTO;
import subway.domain.station.StationService;

public class SectionServiceTest {
    private final ShortDistanceService shortDistanceService = new ShortDistanceService();

    @Test
    public void computeShortDistance() {
        int distance = 1;
        int time = 8;
        SectionDTO sectionDTO = new SectionDTO(this.lineDTO, this.sourceDTO, this.sinkDTO, distance, time);
        ShortCostRequest shortCostRequest = new ShortCostRequest(this.sourceDTO, this.sinkDTO);
        this.sectionService.addNode(this.sourceDTO);
        this.sectionService.addNode(this.sinkDTO);
        this.sectionService.addSection(sectionDTO);
        ShortCostResponse shortCostResponse = this.sectionService.computeShortDistance(shortCostRequest);
        assertThat(shortCostResponse.getTotalDistance()).isEqualTo(distance);
        assertThat(shortCostResponse.getTotalTime()).isEqualTo(time);
        assertThat(shortCostResponse.getStationNameList()).containsExactly(this.sourceDTO.getName(),
            this.sinkDTO.getName());
    }

    @Test
    public void computeShortDistance__NotExistsSourceStationException() {
        StationDTO otherDTO = new StationDTO("other");
        ShortCostRequest shortCostRequest = new ShortCostRequest(otherDTO, this.sinkDTO);
        String message = "존재하지 않은 시작역입니다.";
        assertThatThrownBy(() -> this.sectionService.computeShortDistance(shortCostRequest)).isInstanceOf(
            IllegalArgumentException.class).hasMessage(message);
    }

    @Test
    public void computeShortDistance__NotExistsSinkStationException() {
        StationDTO otherDTO = new StationDTO("other");
        ShortCostRequest shortCostRequest = new ShortCostRequest(this.sourceDTO, otherDTO);
        String message = "존재하지 않은 종료역입니다.";
        assertThatThrownBy(() -> this.sectionService.computeShortDistance(shortCostRequest)).isInstanceOf(
            IllegalArgumentException.class).hasMessage(message);
    }

    @Test
    public void computeShortDistance__NotConnectedSourceAndSinkStationException() {
        ShortCostRequest shortCostRequest = new ShortCostRequest(this.sourceDTO, this.sinkDTO);
        String message = "시작 지점과 종료역이 연결되어 있지 않습니다.";
        this.sectionService.addNode(this.sourceDTO);
        this.sectionService.addNode(this.sinkDTO);
        assertThatThrownBy(() -> this.sectionService.computeShortDistance(shortCostRequest)).isInstanceOf(
            IllegalArgumentException.class).hasMessage(message);
    }

    @AfterEach
    public void init() {
        this.lineService.deleteAll();
        this.stationService.deleteAll();
        this.sectionService.deleteAll();
        this.shortDistanceService.deleteAll();
    }
}
```

```java
// StationService.java

package subway.domain.station;

import java.util.List;
import java.util.Optional;

public class StationService {
    public Optional<Station> findByName(String name) {
        return StationRepository.findByName(name);
    }
}
```

```java
// SectionService.java

package subway.application.section.service;

import java.util.List;

import org.jgrapht.GraphPath;
import org.jgrapht.graph.DefaultWeightedEdge;

import subway.application.section.dto.SectionDTO;
import subway.application.section.dto.ShortCostRequest;
import subway.application.section.dto.ShortCostResponse;
import subway.domain.line.Line;
import subway.domain.line.LineService;
import subway.domain.section.Section;
import subway.domain.section.SectionRepository;
import subway.domain.station.Station;
import subway.domain.station.StationDTO;
import subway.domain.station.StationService;

public class SectionService {
    private static final String NOT_EXISTS_SOURCE_STATION_MESSAGE = "존재하지 않은 시작역입니다.";
    private static final String NOT_EXISTS_SINK_STATION_MESSAGE = "존재하지 않은 종료역입니다.";
    private static final String NOT_CONNECTED_SOURCE_AND_SINK_STATION_MESSAGE = "시작 지점과 종료역이 연결되어 있지 않습니다.";

    public ShortCostResponse computeShortDistance(ShortCostRequest shortCostRequest) {
        Station source = this.stationService.findByName(shortCostRequest.getSourceDTO().getName())
            .orElseThrow(() -> new IllegalArgumentException(NOT_EXISTS_SOURCE_STATION_MESSAGE));
        Station sink = this.stationService.findByName(shortCostRequest.getSinkDTO().getName())
            .orElseThrow(() -> new IllegalArgumentException(NOT_EXISTS_SINK_STATION_MESSAGE));
        GraphPath<Station, DefaultWeightedEdge> graphPath = this.shortDistanceService.compute(source, sink);
        if (graphPath == null) {
            throw new IllegalArgumentException(NOT_CONNECTED_SOURCE_AND_SINK_STATION_MESSAGE);
        }
        return new ShortCostResponse(graphPath.getVertexList());
    }
}
```

최단 거리 계산 구현.

```java
// SectionController.java

package subway.presentation;

import subway.application.section.dto.SectionDTO;
import subway.application.section.dto.ShortCostRequest;
import subway.application.section.dto.ShortCostResponse;
import subway.application.section.service.SectionService;
import subway.domain.line.LineDTO;
import subway.domain.station.StationDTO;
import subway.util.Validation;

public class SectionController {
    public ShortCostResponse computeShortDistance(String sourceName, String sinkName) {
        ShortCostRequest shortCostRequest = this.createShortCostRequest(sourceName, sinkName);
        return this.sectionService.computeShortDistance(shortCostRequest);
    }

    private ShortCostRequest createShortCostRequest(String sourceName, String sinkName) {
        StationDTO sourceDTO = new StationDTO(sourceName);
        StationDTO sinkDTO = new StationDTO(sinkName);
        return new ShortCostRequest(sourceDTO, sinkDTO);
    }
}
```

제어 계층에 최단 거리 계산 기능 매핑.

## 6. 그래프 관련 기능 통합

```java
// ShortCostService.java

package subway.application.section.service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.AbstractBaseGraph;
import org.jgrapht.graph.DefaultWeightedEdge;

import subway.domain.section.Section;
import subway.domain.station.Station;

abstract class ShortCostService {
    private final AbstractBaseGraph<Station, DefaultWeightedEdge> graph;

    public ShortCostService(AbstractBaseGraph<Station, DefaultWeightedEdge> graph) {
        this.graph = graph;
    }

    private static final String ALREADY_EXISTS_NODE_MESSAGE = "이미 등록되어있는 노드입니다.";
    private static final String NOT_EXISTS_SOURCE_NODE_MESSAGE = "존재하지 않은 시작노드입니다.";
    private static final String NOT_EXISTS_SINK_NODE_MESSAGE = "존재하지 않은 종료노드입니다.";
    private static final String ALREADY_EXISTS_EDGE_MESSAGE = "이미 등록되어있는 간선입니다.";

    protected Set<Station> findAllNode() {
        return Collections.unmodifiableSet(graph.vertexSet());
    }

    protected Set<DefaultWeightedEdge> findAllEdge() {
        return Collections.unmodifiableSet(graph.edgeSet());
    }

    protected void addNode(Station station) {
        if (graph.containsVertex(station)) {
            throw new IllegalArgumentException(ALREADY_EXISTS_NODE_MESSAGE);
        }
        graph.addVertex(station);
    }

    protected void addEdge(Section section) {
        Station source = section.getSource();
        Station sink = section.getSink();
        this.validateSource(source);
        this.validateSink(sink);
        if (graph.containsEdge(source, sink)) {
            throw new IllegalArgumentException(ALREADY_EXISTS_EDGE_MESSAGE);
        }
        graph.setEdgeWeight(graph.addEdge(source, sink), this.getWeight(section));
    }

    protected abstract double getWeight(Section section);

    protected GraphPath<Station, DefaultWeightedEdge> compute(Station source, Station sink) {
        this.validateSource(source);
        this.validateSink(sink);
        DijkstraShortestPath<Station, DefaultWeightedEdge> dijkstraShortestPath = new DijkstraShortestPath<>(graph);
        return dijkstraShortestPath.getPath(source, sink);
    }

    protected void validateSource(Station source) {
        if (!graph.containsVertex(source)) {
            throw new IllegalArgumentException(NOT_EXISTS_SOURCE_NODE_MESSAGE);
        }
    }

    protected void validateSink(Station sink) {
        if (!graph.containsVertex(sink)) {
            throw new IllegalArgumentException(NOT_EXISTS_SINK_NODE_MESSAGE);
        }
    }

    protected void deleteAllNode() {
        Set<Station> nodes = new HashSet<>(this.findAllNode());
        graph.removeAllVertices(nodes);
    }

    protected void deleteAllEdge() {
        graph.removeAllEdges(graph.edgeSet());
    }

    protected void deleteAll() {
        this.deleteAllEdge();
        this.deleteAllNode();
    }
}

```

```java
// ShortDistanceService.java

package subway.application.section.service;

import org.jgrapht.graph.AbstractBaseGraph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.DirectedWeightedMultigraph;

import subway.domain.section.Section;
import subway.domain.station.Station;

class ShortDistanceService extends ShortCostService {
    private static final AbstractBaseGraph<Station, DefaultWeightedEdge> graph = new DirectedWeightedMultigraph<>(
        DefaultWeightedEdge.class);

    public ShortDistanceService() {
        super(graph);
    }

    @Override
    protected double getWeight(Section section) {
        return section.getDistance();
    }
}
```

이후에 구현될 최소 시간 경로와 그래프 관련 기능은 유사하기 때문에 따로 추상 공통 클래스를 생성하여 코드 중복 방지.

## 7. 최소 시간 경로 구하기

```java
// ShortTimeService.java

package subway.application.section.service;

import org.jgrapht.graph.AbstractBaseGraph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.DirectedWeightedMultigraph;

import subway.domain.section.Section;
import subway.domain.station.Station;

class ShortTimeService extends ShortCostService {
    private static final AbstractBaseGraph<Station, DefaultWeightedEdge> graph = new DirectedWeightedMultigraph<>(
        DefaultWeightedEdge.class);

    public ShortTimeService() {
        super(graph);
    }

    @Override
    protected double getWeight(Section section) {
        return section.getTime();
    }
}
```

최소 시간 경로 반환 기능 구현.

```java
// SectionService.java

package subway.application.section.service;

import java.util.List;

import org.jgrapht.GraphPath;
import org.jgrapht.graph.DefaultWeightedEdge;

import subway.application.section.dto.SectionDTO;
import subway.application.section.dto.ShortCostRequest;
import subway.application.section.dto.ShortCostResponse;
import subway.domain.line.Line;
import subway.domain.line.LineService;
import subway.domain.section.Section;
import subway.domain.section.SectionRepository;
import subway.domain.station.Station;
import subway.domain.station.StationDTO;
import subway.domain.station.StationService;

public class SectionService {
    private final ShortTimeService shortTimeService = new ShortTimeService();

    public void addNode(StationDTO stationDTO) {
        Station station = this.stationService.findOneByName(stationDTO.getName());
        this.shortDistanceService.addNode(station);
+       this.shortTimeService.addNode(station);
    }

    public void addSection(SectionDTO sectionDTO) {
        Line line = this.lineService.findOneByName(sectionDTO.getLineDTO().getName());
        Station source = this.stationService.findOneByName(sectionDTO.getSourceDTO().getName());
        Station sink = this.stationService.findOneByName(sectionDTO.getSinkDTO().getName());
        Section section = new Section(line, source, sink, sectionDTO.getDistance(), sectionDTO.getTime());
        if (SectionRepository.exists(section)) {
            throw new IllegalArgumentException(ALREADY_EXISTS_SECTION_MESSAGE);
        }
        SectionRepository.addSection(section);
        this.shortDistanceService.addEdge(section);
+       this.shortTimeService.addEdge(section);
        line.addSection(section);
        source.addSection(section);
    }
    
    public ShortCostResponse computeShortTime(ShortCostRequest shortCostRequest) {
        Station source = this.stationService.findByName(shortCostRequest.getSourceDTO().getName())
            .orElseThrow(() -> new IllegalArgumentException(NOT_EXISTS_SOURCE_STATION_MESSAGE));
        Station sink = this.stationService.findByName(shortCostRequest.getSinkDTO().getName())
            .orElseThrow(() -> new IllegalArgumentException(NOT_EXISTS_SINK_STATION_MESSAGE));
        GraphPath<Station, DefaultWeightedEdge> graphPath = this.shortDistanceService.compute(source, sink);
        if (graphPath == null) {
            throw new IllegalArgumentException(NOT_CONNECTED_SOURCE_AND_SINK_STATION_MESSAGE);
        }
        return new ShortCostResponse(graphPath.getVertexList());
    }
}
```

최소 시간 그래프도 같이 노드, 간선 추가에 포함.

최소 시간 계산 구현.

```java
// SectionServiceTest.java

package subway.application.section.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import subway.application.section.dto.SectionDTO;
import subway.application.section.dto.ShortCostRequest;
import subway.application.section.dto.ShortCostResponse;
import subway.domain.line.Line;
import subway.domain.line.LineDTO;
import subway.domain.line.LineService;
import subway.domain.station.Station;
import subway.domain.station.StationDTO;
import subway.domain.station.StationService;

public class SectionServiceTest {
    private final ShortTimeService shortTimeService = new ShortTimeService();

    @AfterEach
    public void init() {
        this.lineService.deleteAll();
        this.stationService.deleteAll();
        this.sectionService.deleteAll();
        this.shortDistanceService.deleteAll();
+       this.shortTimeService.deleteAll();
    }
}
```

최소 시간 기능 도입으로 인한 테스트 초기화 소스 변경.

```java
// SectionController.java

package subway.presentation;

import subway.application.section.dto.SectionDTO;
import subway.application.section.dto.ShortCostRequest;
import subway.application.section.dto.ShortCostResponse;
import subway.application.section.service.SectionService;
import subway.domain.line.LineDTO;
import subway.domain.station.StationDTO;
import subway.util.Validation;

public class SectionController {
    public ShortCostResponse computeShortTime(String sourceName, String sinkName) {
        ShortCostRequest shortCostRequest = this.createShortCostRequest(sourceName, sinkName);
        return this.sectionService.computeShortTime(shortCostRequest);
    }
}
```

제어 계층에 최소 시간 계산 기능 매핑.

```java
// StationController.java

package subway.presentation;

import subway.application.section.service.SectionService;import subway.domain.station.StationDTO;
import subway.domain.station.StationService;

public class StationController {
    private final SectionService sectionService = new SectionService();

    public void addStation(String name) {
        StationDTO stationDTO = new StationDTO(name);
        stationService.addStation(stationDTO);
+       this.sectionService.addNode(stationDTO);
    }
}
```

역과 같이 노드도 같이 추가되도록 변경.

## 8. Screen Layer Skeleton

### Ui

```java
// Console.java

package subway.screen.ui;

import java.io.PrintStream;
import java.util.Scanner;

public final class Console {
    private static final Scanner scanner = new Scanner(System.in);
    private static final PrintStream printer = System.out;

    private static final String HEADER_OUTPUT_FORMAT = "## %s";
    private static final String INFO_OUTPUT_FORMAT = "[INFO] %s";
    private static final String ERROR_OUTPUT_FORMAT = "[ERROR] %s";

    public static String readline() {
        return scanner.nextLine();
    }

    public static void println() {
        printer.println();
    }

    public static void println(String message) {
        printer.println(message);
    }

    public static void printHeader(String message) {
        println(String.format(HEADER_OUTPUT_FORMAT, message));
    }

    public static void printInfo(String message) {
        println(String.format(INFO_OUTPUT_FORMAT, message));
    }

    public static void printError(String message) {
        println(String.format(ERROR_OUTPUT_FORMAT, message));
    }

}
```

콘솔 입출력 기능 구현.

### View

```java
// View.java

package subway.screen.view;

public interface View {
    String title();
    void show();
}
```

화면 기본 기능 정의.

```java
// MenuTest.java

package subway.screen.view;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MenuTest {
    private static class ClassMenu implements Menu {
        @Override
        public String getCommand() {
            return "";
        }

        @Override
        public String getName() {
            return "";
        }
    }

    private enum EnumMenu implements Menu {
        ITEM("command", "name");

        private final String command;
        private final String name;

        EnumMenu(String command, String name) {
            this.command = command;
            this.name = name;
        }

        @Override
        public String getCommand() {
            return this.command;
        }

        @Override
        public String getName() {
            return this.name;
        }
    }

    @Test
    public void findAll() {
        EnumMenu[] enumMenus = EnumMenu.values();
        assertThat(Menu.findAll(EnumMenu.class)).containsExactly(enumMenus);
    }

    @Test
    public void findAll__NotEnumTypeClassException() {
        String message = "Enum 형식의 클래스가 아닙니다.";
        assertThatThrownBy(() -> Menu.findAll(ClassMenu.class)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
    }

    @Test
    public void findByCommand() {
        EnumMenu item = EnumMenu.ITEM;
        assertThat(Menu.findByCommand(EnumMenu.class, "none")).isNotPresent();
        assertThat(Menu.findByCommand(EnumMenu.class, item.getCommand())).isPresent();
    }
}
```

```java
// Menu.java

package subway.screen.view;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface Menu {
    String getCommand();

    String getName();

    static List<Menu> findAll(Class<? extends Menu> menuClass) {
        Menu[] enumValues = menuClass.getEnumConstants();
        if(enumValues == null) {
            throw new IllegalArgumentException("Enum 형식의 클래스가 아닙니다.");
        }
        return Arrays.stream(enumValues).collect(Collectors.toList());
    }

    static Optional<Menu> findByCommand(Class<? extends Menu> menuClass, String command) {
        List<Menu> menuList = findAll(menuClass);
        for (Menu menu : menuList) {
            if (menu.getCommand().equals(command)) {
                return Optional.of(menu);
            }
        }
        return Optional.empty();
    }
}
```

메뉴 기본 기능 정의.

메뉴 목록 조회 기능 구현.

명령어 기준 단건 조회 기능 구현.

```java
// MenuEventManagerTest.java

package subway.screen.view;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MenuEventManagerTest {
    private enum EnumMenu implements Menu {
        ITEM("command", "name"), NONE("", "");

        private final String command;
        private final String name;

        EnumMenu(String command, String name) {
            this.command = command;
            this.name = name;
        }

        @Override
        public String getCommand() {
            return this.command;
        }

        @Override
        public String getName() {
            return this.name;
        }
    }

    @Test
    public void addEventListener__NotReceivedMenuException() {
        MenuEventManager menuEventManager = MenuEventManager.builder();
        String message = "메뉴를 전달받지 못하였습니다.";
        assertThatThrownBy(() -> menuEventManager.addEventListener(null, () -> {
        })).isInstanceOf(IllegalArgumentException.class).hasMessage(message);
    }

    @Test
    public void addEventListener__NotReceivedHandlerException() {
        MenuEventManager menuEventManager = MenuEventManager.builder();
        String message = "이벤트 핸들러를 전달받지 못하였습니다.";
        assertThatThrownBy(() -> menuEventManager.addEventListener(EnumMenu.ITEM, null)).isInstanceOf(
            IllegalArgumentException.class).hasMessage(message);
    }

    @Test
    public void select() {
        MenuEventManager menuEventManager = MenuEventManager.builder().addEventListener(EnumMenu.ITEM, () -> {
        });
        assertThat(menuEventManager.select(EnumMenu.NONE)).isNotPresent();
        assertThat(menuEventManager.select(EnumMenu.ITEM)).isPresent();
    }
}
```

```java
// MenuEventManager.java

package subway.screen.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class MenuEventManager {
    private static final String NOT_RECEIVED_MENU_MESSAGE = "메뉴를 전달받지 못하였습니다.";
    private static final String NOT_RECEIVED_HANDLER_MESSAGE = "이벤트 핸들러를 전달받지 못하였습니다.";

    private final Map<Menu, Runnable> handlerMap = new HashMap<>();

    private MenuEventManager() {
    }

    public static MenuEventManager builder() {
        return new MenuEventManager();
    }

    public MenuEventManager addEventListener(Menu menu) {
        return this.addEventListener(menu, () -> {
        });
    }

    public MenuEventManager addEventListener(Menu menu, Runnable handler) {
        this.validate(menu, handler);
        this.handlerMap.put(menu, handler);
        return this;
    }

    private void validate(Menu menu, Runnable runnable) {
        if (menu == null) {
            throw new IllegalArgumentException(NOT_RECEIVED_MENU_MESSAGE);
        }
        if (runnable == null) {
            throw new IllegalArgumentException(NOT_RECEIVED_HANDLER_MESSAGE);
        }
    }

    public void removeEventListener(Menu menu) {
        this.handlerMap.remove(menu);
    }

    public void removeAllEventListener() {
        this.handlerMap.clear();
    }

    Optional<Runnable> select(Menu menu) {
        return Optional.ofNullable(this.handlerMap.get(menu));
    }
}
```

메뉴 이벤트 등록 및 삭제할 수 있는 기능 구현.

```java
// MenuViewTest.java

package subway.screen.view;

import static org.assertj.core.api.Assertions.*;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import subway.screen.ui.Console;

public class MenuViewTest {
    private MockedStatic<Console> mockConsole;

    private enum TestMenu implements Menu {
        ITEM("command", "name");

        private final String command;
        private final String name;

        TestMenu(String command, String name) {
            this.command = command;
            this.name = name;
        }

        @Override
        public String getCommand() {
            return this.command;
        }

        @Override
        public String getName() {
            return this.name;
        }
    }

    private static class TestMenuView extends MenuView {
        public TestMenuView() {
        }

        public TestMenuView(MenuEventManager menuEventManager) {
            super(menuEventManager);
        }

        @Override
        protected Class<? extends Menu> getType() {
            return TestMenu.class;
        }

        @Override
        public String title() {
            return "테스트 화면";
        }
    }

    @BeforeEach
    public void setup() {
        mockConsole = Mockito.mockStatic(Console.class);
    }

    @Test
    public void constructor__NotReceivedEventManagerException() {
        String message = "이벤트 관리자를 전달받지 못하였습니다.";
        assertThatThrownBy(() -> new MenuView(null) {
            @Override
            public String title() {
                return "";
            }

            @Override
            protected Class<? extends Menu> getType() {
                return null;
            }
        }).isInstanceOf(IllegalArgumentException.class).hasMessage(message);
    }

    @Test
    public void show() {
        TestMenu item = TestMenu.ITEM;
        TestMenuView testMenuView = new TestMenuView();
        testMenuView.show();
        this.mockConsole.verify(() -> {
            Console.printHeader(testMenuView.title());
            Console.println(String.format("%s. %s", item.command, item.name));
            Console.println();
        });
    }

    @Test
    public void question() {
        TestMenu item = TestMenu.ITEM;
        TestMenuView testMenuView = new TestMenuView();
        this.mockConsole.when(Console::readline).thenReturn(item.command);
        assertThat(testMenuView.question()).isEqualTo(item);
    }

    @Test
    public void question_CanNotSelectedFunctionException() {
        TestMenu item = TestMenu.ITEM;
        TestMenuView testMenuView = new TestMenuView();
        String message = "선택할 수 없는 기능입니다.";
        this.mockConsole.when(Console::readline).thenReturn("none");
        this.mockConsole.when(Console::readline).thenReturn(item.command);
        testMenuView.question();
        this.mockConsole.verify(() -> {
            Console.println();
            Console.printError(message);
            Console.println();

            Console.println();
        });
    }

    @Test
    public void onEvent() {
        TestMenu item = TestMenu.ITEM;
        AtomicInteger count = new AtomicInteger(0);
        TestMenuView testMenuView = new TestMenuView(
            MenuEventManager.builder().addEventListener(item, count::getAndIncrement));
        testMenuView.onEvent(item);
        assertThat(count.get()).isEqualTo(1);
    }

    @Test
    public void onEvent__CanNotProcessEventHandlerException() {
        TestMenu item = TestMenu.ITEM;
        TestMenuView testMenuView = new TestMenuView();
        String message = "이벤트를 처리할 수 없습니다.";
        assertThatThrownBy(() -> testMenuView.onEvent(null)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
        assertThatThrownBy(() -> testMenuView.onEvent(item)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
    }

    @AfterEach
    public void init() {
        mockConsole.close();
    }
}
```

```java
// MenuView.java

package subway.screen.view;

import java.util.List;

import subway.screen.ui.Console;

public abstract class MenuView implements View {
    private static final String NOT_RECEIVED_EVENT_MANAGER_MESSAGE = "이벤트 관리자를 전달받지 못하였습니다.";
    private static final String MENU_OUTPUT_FORMAT = "%s. %s";
    private static final String CAN_NOT_SELECTED_FUNCTION_MESSAGE = "선택할 수 없는 기능입니다.";
    private static final String CAN_NOT_PROCESS_EVENT_HANDLER_MESSAGE = "이벤트를 처리할 수 없습니다.";

    private final MenuEventManager menuEventManager;

    protected MenuView() {
        this(MenuEventManager.builder());
    }

    protected MenuView(MenuEventManager menuEventManager) {
        if (menuEventManager == null) {
            throw new IllegalArgumentException(NOT_RECEIVED_EVENT_MANAGER_MESSAGE);
        }
        this.menuEventManager = menuEventManager;
    }

    protected abstract Class<? extends Menu> getType();

    @Override
    public void show() {
        Console.printHeader(this.title());
        List<Menu> menuList = Menu.findAll(this.getType());
        for (Menu menu : menuList) {
            Console.println(String.format(MENU_OUTPUT_FORMAT, menu.getCommand(), menu.getName()));
        }
        Console.println();
    }

    public Menu question() {
        do {
            Console.printHeader("원하는 기능을 선택하세요.");
            String command = Console.readline();
            try {
                Menu menu = Menu.findByCommand(this.getType(), command)
                    .orElseThrow(() -> new IllegalArgumentException(CAN_NOT_SELECTED_FUNCTION_MESSAGE));
                Console.println();
                return menu;
            } catch (IllegalArgumentException e) {
                Console.println();
                Console.printError(e.getMessage());
                Console.println();
            }
        } while (true);
    }

    public void onEvent(Menu menu) {
        Runnable handler = this.menuEventManager.select(menu)
            .orElseThrow(() -> new IllegalArgumentException(CAN_NOT_PROCESS_EVENT_HANDLER_MESSAGE));
        handler.run();
    }
}
```

메뉴 화면 공통 기능 구현.

## 9. 경로 기준(화면) 구현

```java
// PathMenu.java

package subway.screen.view.path;

import subway.screen.view.Menu;

public enum PathMenu implements Menu {
    SHORT_DISTANCE("1", "최단 거리"),
    SHORT_TIME("2", "최소 시간"),
    BACK("B", "돌아가기");

    private final String command;
    private final String name;

    PathMenu(String command, String name) {
        this.command = command;
        this.name = name;
    }

    @Override
    public String getCommand() {
        return this.command;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
```

```java
// MainMenuView

package subway.screen.view.path;

import subway.screen.view.Menu;
import subway.screen.view.MenuView;

public class PathMenuView extends MenuView {
    public PathMenuView() {
        super();
    }

    @Override
    public String title() {
        return "경로 기준";
    }

    @Override
    protected Class<? extends Menu> getType() {
        return PathMenu.class;
    }
}
```

경로 기준(화면) 구성.

```java
// ViewController.java

package subway.presentation;

public interface ViewController {
    void execute();
}
```

화면 제어 기본 정의.

```java
// PathViewController.java

package subway.presentation;

import subway.application.section.dto.ShortCostResponse;
import subway.screen.ui.Console;
import subway.screen.view.Menu;
import subway.screen.view.path.PathMenuView;

public class PathViewController implements ViewController {
    private final PathMenuView pathMenuView = new PathMenuView(this);
    private final SectionController sectionController = new SectionController();

    @Override
    public void execute() {
        do {
            pathMenuView.show();
            Menu menu = pathMenuView.question();
            try {
                pathMenuView.onEvent(menu);
                return;
            } catch (IllegalArgumentException e) {
                Console.printError(e.getMessage());
                Console.println();
            }
        } while (true);
    }

    public void handleShortDistance() {
        String sourceName = this.requestSourceName();
        String sinkName = this.requestSinkName();
        ShortCostResponse shortCostResponse = this.sectionController.computeShortDistance(sourceName, sinkName);
        this.printShortCostResponse(shortCostResponse);
    }

    public void handleShortTime() {
        String sourceName = this.requestSourceName();
        String sinkName = this.requestSinkName();
        ShortCostResponse shortCostResponse = this.sectionController.computeShortTime(sourceName, sinkName);
        this.printShortCostResponse(shortCostResponse);
    }

    private String requestSourceName() {
        Console.printHeader("출발역을 입력하세요");
        String sourceName = Console.readline();
        Console.println();
        return sourceName;
    }

    private String requestSinkName() {
        Console.printHeader("도착역을 입력하세요");
        String sinkName = Console.readline();
        Console.println();
        return sinkName;
    }

    private void printShortCostResponse(ShortCostResponse shortCostResponse) {
        Console.printHeader("조회 결과");
        Console.printInfo("---");
        Console.printInfo(String.format("총 거리 : %dkm", shortCostResponse.getTotalDistance()));
        Console.printInfo(String.format("총 소요 시간 : %d분", shortCostResponse.getTotalTime()));
        Console.printInfo("---");
        for (String stationName : shortCostResponse.getStationNameList()) {
            Console.printInfo(stationName);
        }
        Console.println();
    }
}
```

경로 기준(화면) 제어 구현.

메뉴 선택 이벤트 처리 구현.

```java
// MainMenuView

package subway.screen.view.path;

import subway.presentation.PathViewController;
import subway.screen.view.Menu;
import subway.screen.view.MenuEventManager;
import subway.screen.view.MenuView;

public class PathMenuView extends MenuView {
    public PathMenuView(PathViewController pathViewController) {
        super(MenuEventManager.builder()
            .addEventListener(PathMenu.SHORT_DISTANCE, pathViewController::handleShortDistance)
            .addEventListener(PathMenu.SHORT_TIME, pathViewController::handleShortTime)
            .addEventListener(PathMenu.BACK));
    }
}
```

이벤트 처리 매핑.

## 10. 메인 화면 구현

```java
// MainMenu.java

package subway.screen.view.main;

import subway.screen.view.Menu;

public enum MainMenu implements Menu {
    PATH_SEARCH("1", "경로 조회"), END("Q", "종료");

    private final String command;
    private final String name;

    MainMenu(String command, String name) {
        this.command = command;
        this.name = name;
    }

    @Override
    public String getCommand() {
        return this.command;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
```

```java
// MainMenuView.java

package subway.screen.view.main;

import subway.screen.view.Menu;
import subway.screen.view.MenuView;

public class MainMenuView extends MenuView {
    public MainMenuView() {
        super();
    }

    @Override
    public String title() {
        return "메인 화면";
    }

    @Override
    protected Class<? extends Menu> getType() {
        return MainMenu.class;
    }
}
```

메인 화면 구성.

```java
// MainViewController.java

package subway.presentation;

import subway.screen.ui.Console;
import subway.screen.view.Menu;
import subway.screen.view.main.MainMenuView;

public class MainViewController implements ViewController {
    private final MainMenuView mainMenuView = new MainMenuView(this);

    private boolean end;

    @Override
    public void execute() {
        this.end = false;
        do {
            mainMenuView.show();
            Menu menu = mainMenuView.question();
            try {
                mainMenuView.onEvent(menu);
            } catch (IllegalArgumentException e) {
                Console.printError(e.getMessage());
                Console.println();
            }
        } while (!this.end);
    }

    public void handlePathSearch() {
        PathViewController pathViewController = new PathViewController();
        pathViewController.execute();
    }

    public void handleEnd() {
        this.end = true;
    }
}
```

메인 화면 제어 구현.

메뉴 선택 이벤트 처리 구현.

```java
// MainMenuView.java

package subway.screen.view.main;

import subway.presentation.MainViewController;
import subway.screen.view.Menu;
import subway.screen.view.MenuEventManager;
import subway.screen.view.MenuView;

public class MainMenuView extends MenuView {
    public MainMenuView(MainViewController mainViewController) {
        super(MenuEventManager.builder()
            .addEventListener(MainMenu.PATH_SEARCH, mainViewController::handlePathSearch)
            .addEventListener(MainMenu.END, mainViewController::handleEnd));
    }
}
```

이벤트 처리 매핑.

## 11. 파일 검증

```java
// FileParserTest.java

package subway.infrastructure;

import static org.assertj.core.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FileParserTest {
    private File file;
    private File directory;

    @BeforeEach
    public void setup() {
        this.directory = new File("./dummy");
        this.file = new File("./dummy.txt");
        try {
            this.directory.mkdir();
            this.file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static class TestFileParser extends FileParser {
        public TestFileParser(File file) {
            super(file);
        }

        @Override
        public boolean allowExtension(String extension) {
            return "java".equals(extension);
        }

        @Override
        public List<Map<String, Object>> parser() {
            return null;
        }
    }

    @Test
    public void constructor__NotExistsFileException() {
        File none = new File("./none.txt");
        String message = "파일이 존재하지 않습니다.";
        assertThatThrownBy(() -> new TestFileParser(null)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
        assertThatThrownBy(() -> new TestFileParser(none)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
    }

    @Test
    public void constructor__NotReceivedFileTypeException() {
        String message = "파일 유형이 아닙니다.";
        assertThatThrownBy(() -> new TestFileParser(this.directory)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
    }

    @Test
    public void constructor__NotAllowedFileExtensionException() {
        String message = "허용된 파일 확장자가 아닙니다.";
        assertThatThrownBy(() -> new TestFileParser(this.file)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
    }

    @AfterEach
    public void init() {
        this.file.delete();
        this.directory.delete();
    }
}
```

```java
// FileParser.java

package subway.infrastructure;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public abstract class FileParser {
    private static final String NOT_EXISTS_FILE_MESSAGE = "파일이 존재하지 않습니다.";
    private static final String NOT_FILE_TYPE_MESSAGE = "파일 유형이 아닙니다.";
    private static final String NOT_ALLOWED_FILE_EXTENSION_MESSAGE = "허용된 파일 확장자가 아닙니다.";

    protected final File file;

    public FileParser(String fileName) {
        this(new File(Objects.requireNonNull(FileParser.class.getClassLoader().getResource(fileName)).getPath()));
    }

    public FileParser(File file) {
        this.validate(file);
        this.file = file;
    }

    private void validate(File file) {
        if (file == null || !file.exists()) {
            throw new IllegalArgumentException(NOT_EXISTS_FILE_MESSAGE);
        }
        if (!file.isFile()) {
            throw new IllegalArgumentException(NOT_FILE_TYPE_MESSAGE);
        }
        if (!this.allowExtension(this.extractExtension(file.getName()))) {
            throw new IllegalArgumentException(NOT_ALLOWED_FILE_EXTENSION_MESSAGE);
        }
    }

    private String extractExtension(String fileName) {
        int index = fileName.lastIndexOf(".");
        if (index > 0) {
            return fileName.substring(index + 1);
        }
        return "";
    }

    public abstract boolean allowExtension(String extension);

    public abstract List<Map<String, Object>> parser();
}
```

파일 검증 공통 기능 구현.

## 12. Xml Parser

```java
// XmlFileParserTest.java

package subway.infrastructure;

import static org.assertj.core.api.Assertions.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class XmlFileParserTest {
    private static final String content = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
        + "<root>\n"
        + " <object>\n"
        + "     <name>name</name>\n"
        + "     <job>\n"
        + "         <name>name</name>\n"
        + "     </job>\n"
        + " </object>\n"
        + "</root>\n";
    private static File file;

    @BeforeAll
    public static void setup() {
        file = new File("file.xml");
        try {
            file.createNewFile();
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
                bufferedWriter.write(content);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void parser() {
        XmlFileParser xmlFileParser = new XmlFileParser(file);
        List<Map<String, Object>> dataList = xmlFileParser.parser();
        assertThat(dataList).hasSize(1);
        Map<String, Object> data = dataList.get(0);
        assertThat(data.get("name")).isInstanceOf(String.class).isEqualTo("name");
        assertThat(data.get("job")).isInstanceOf(Map.class);
        Map<String, Object> job = (Map<String, Object>)data.get("job");
        assertThat(job.get("name")).isInstanceOf(String.class).isEqualTo("name");
    }

    @AfterAll
    public static void init() {
        file.delete();
    }
}
```

```java
// XmlFileParser.java

package subway.infrastructure;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlFileParser extends FileParser {
    private static final int UNKNOWN_NODE_LIST = 0;
    private static final int HAS_ELEMENT_NODE_LIST = 1;
    private static final int HAS_TEXT_NODE_LIST = 2;

    private final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

    public XmlFileParser(String fileName) {
        super(fileName);
    }

    public XmlFileParser(File file) {
        super(file);
    }

    @Override
    public boolean allowExtension(String extension) {
        return "xml".equals(extension);
    }

    @Override
    public List<Map<String, Object>> parser() {
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            document.getDocumentElement().normalize();
            Element root = document.getDocumentElement();
            return this.find(root);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private List<Map<String, Object>> find(Element root) {
        List<Map<String, Object>> data = new ArrayList<>();
        NodeList nodeList = root.getChildNodes();
        for (int index = 0; index < nodeList.getLength(); index++) {
            Node node = nodeList.item(index);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                data.add(this.serialize(node.getChildNodes()));
            }
        }
        return data;
    }

    private Map<String, Object> serialize(NodeList parentNodeList) {
        Map<String, Object> data = new HashMap<>();
        for (int index = 0; index < parentNodeList.getLength(); index++) {
            Node child = parentNodeList.item(index);
            int childType = child.getNodeType();
            String childName = child.getNodeName();
            if (childType == Node.ELEMENT_NODE) {
                data.put(childName, this.getNodeData(child));
            }
        }
        return data;
    }

    private Object getNodeData(Node node) {
        NodeList nodeList = node.getChildNodes();
        int nodeListType = this.getNodeListType(nodeList);
        if (nodeListType == HAS_ELEMENT_NODE_LIST) {
            return this.serialize(nodeList);
        } else if (nodeListType == HAS_TEXT_NODE_LIST) {
            return this.getTextValue(node);
        }
        return null;
    }

    private int getNodeListType(NodeList nodeList) {
        for (int index = 0; index < nodeList.getLength(); index++) {
            Node node = nodeList.item(index);
            int nodeType = node.getNodeType();
            String _nodeValue = node.getNodeValue();
            if (nodeType == Node.ELEMENT_NODE) {
                return HAS_ELEMENT_NODE_LIST;
            } else if (nodeType == Node.TEXT_NODE && this.hasTextValue(_nodeValue)) {
                return HAS_TEXT_NODE_LIST;
            }
        }
        return UNKNOWN_NODE_LIST;
    }

    private String getTextValue(Node node) {
        NodeList nodeList = node.getChildNodes();
        for (int index = 0; index < nodeList.getLength(); index++) {
            Node child = nodeList.item(index);
            String _childValue = child.getNodeValue();
            if (child.getNodeType() == Node.TEXT_NODE && this.hasTextValue(_childValue)) {
                return _childValue.trim();
            }
        }
        return "";
    }

    private boolean hasTextValue(String value) {
        return value != null && !value.trim().isEmpty();
    }
}
```

Xml Parser 기능 구현.

## 13. 초기 데이터 정의

```xml
<?xml version="1.0" encoding="UTF-8"?>
<root>
    <line>
        <name>2호선</name>
    </line>
    <line>
        <name>3호선</name>
    </line>
    <line>
        <name>신분당선</name>
    </line>
</root>
```

Line(노선) 데이터 정의.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<root>
    <station>
        <name>교대역</name>
    </station>
    <station>
        <name>강남역</name>
    </station>
    <station>
        <name>역삼역</name>
    </station>
    <station>
        <name>남부터미널역</name>
    </station>
    <station>
        <name>양재역</name>
    </station>
    <station>
        <name>양재시민의숲역</name>
    </station>
    <station>
        <name>매봉역</name>
    </station>
</root>
```

Station(역) 데이터 정의.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<root>
    <!-- 2호선 -->
    <section>
        <line>
            <name>2호선</name>
        </line>
        <source>
            <name>교대역</name>
        </source>
        <sink>
            <name>강남역</name>
        </sink>
        <distance>2</distance>
        <time>3</time>
    </section>
    <section>
        <line>
            <name>2호선</name>
        </line>
        <source>
            <name>강남역</name>
        </source>
        <sink>
            <name>교대역</name>
        </sink>
        <distance>2</distance>
        <time>3</time>
    </section>
    <section>
        <line>
            <name>2호선</name>
        </line>
        <source>
            <name>강남역</name>
        </source>
        <sink>
            <name>역삼역</name>
        </sink>
        <distance>2</distance>
        <time>3</time>
    </section>
    <section>
        <line>
            <name>2호선</name>
        </line>
        <source>
            <name>역삼역</name>
        </source>
        <sink>
            <name>강남역</name>
        </sink>
        <distance>2</distance>
        <time>3</time>
    </section>
    <!-- 3호선 -->
    <section>
        <line>
            <name>3호선</name>
        </line>
        <source>
            <name>교대역</name>
        </source>
        <sink>
            <name>남부터미널역</name>
        </sink>
        <distance>3</distance>
        <time>2</time>
    </section>
    <section>
        <line>
            <name>3호선</name>
        </line>
        <source>
            <name>남부터미널역</name>
        </source>
        <sink>
            <name>교대역</name>
        </sink>
        <distance>3</distance>
        <time>2</time>
    </section>
    <section>
        <line>
            <name>3호선</name>
        </line>
        <source>
            <name>남부터미널역</name>
        </source>
        <sink>
            <name>양재역</name>
        </sink>
        <distance>6</distance>
        <time>5</time>
    </section>
    <section>
        <line>
            <name>3호선</name>
        </line>
        <source>
            <name>양재역</name>
        </source>
        <sink>
            <name>남부터미널역</name>
        </sink>
        <distance>6</distance>
        <time>5</time>
    </section>
    <section>
        <line>
            <name>3호선</name>
        </line>
        <source>
            <name>양재역</name>
        </source>
        <sink>
            <name>매봉역</name>
        </sink>
        <distance>1</distance>
        <time>1</time>
    </section>
    <section>
        <line>
            <name>3호선</name>
        </line>
        <source>
            <name>매봉역</name>
        </source>
        <sink>
            <name>양재역</name>
        </sink>
        <distance>1</distance>
        <time>1</time>
    </section>
    <!-- 신분당선 -->
    <section>
        <line>
            <name>신분당선</name>
        </line>
        <source>
            <name>강남역</name>
        </source>
        <sink>
            <name>양재역</name>
        </sink>
        <distance>2</distance>
        <time>8</time>
    </section>
    <section>
        <line>
            <name>신분당선</name>
        </line>
        <source>
            <name>양재역</name>
        </source>
        <sink>
            <name>강남역</name>
        </sink>
        <distance>2</distance>
        <time>8</time>
    </section>
    <section>
        <line>
            <name>신분당선</name>
        </line>
        <source>
            <name>양재역</name>
        </source>
        <sink>
            <name>양재시민의숲역</name>
        </sink>
        <distance>10</distance>
        <time>3</time>
    </section>
    <section>
        <line>
            <name>신분당선</name>
        </line>
        <source>
            <name>양재시민의숲역</name>
        </source>
        <sink>
            <name>양재역</name>
        </sink>
        <distance>10</distance>
        <time>3</time>
    </section>
</root>
```

Section(구간) 데이터 정의.

## 14. 인트로 화면 구현

```java
// IntroViewController.java

package subway.presentation;

import java.util.List;
import java.util.Map;

import subway.infrastructure.FileParser;
import subway.infrastructure.XmlFileParser;

public class IntroViewController implements ViewController {
    private final MainViewController mainViewController = new MainViewController();
    private final LineController lineController = new LineController();
    private final StationController stationController = new StationController();
    private final SectionController sectionController = new SectionController();

    @Override
    public void execute() {
        this.setup();
        mainViewController.execute();
    }

    private void setup() {
        this.loadLineData();
        this.loadStationData();
        this.loadSectionData();
    }

    private void loadLineData() {
        FileParser fileParser = new XmlFileParser("line.xml");
        List<Map<String, Object>> dataList = fileParser.parser();
        for (Map<String, Object> data : dataList) {
            String lineName = data.get("name").toString();
            this.lineController.addLine(lineName);
        }
    }

    private void loadStationData() {
        FileParser fileParser = new XmlFileParser("station.xml");
        List<Map<String, Object>> dataList = fileParser.parser();
        for (Map<String, Object> data : dataList) {
            String stationName = data.get("name").toString();
            this.stationController.addStation(stationName);
        }
    }

    private void loadSectionData() {
        FileParser fileParser = new XmlFileParser("section.xml");
        List<Map<String, Object>> dataList = fileParser.parser();
        for (Map<String, Object> data : dataList) {
            Map<String, Object> line = (Map<String, Object>)data.get("line");
            String lineName = line.get("name").toString();
            Map<String, Object> source = (Map<String, Object>)data.get("source");
            String sourceName = source.get("name").toString();
            Map<String, Object> sink = (Map<String, Object>)data.get("sink");
            String sinkName = sink.get("name").toString();
            String distance = data.get("distance").toString();
            String time = data.get("time").toString();
            this.sectionController.addSection(lineName, sourceName, sinkName, distance, time);
        }
    }
}
```

인트로 화면 제어 구현.

## 15. 애플리케이션 구현

```java
// Application.java

package subway;

import subway.presentation.IntroViewController;

public class Application {
    public static void main(String[] args) {
        IntroViewController introViewController = new IntroViewController();
        introViewController.execute();
    }
}
```

애플리케이션 실행 시 인트로 화면 호출 구현.
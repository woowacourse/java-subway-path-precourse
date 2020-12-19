# 지하철 노선도 경로 조회 미션
우아한테크코스 웹 백엔드 프리코스 최종 코딩 테스트 미션 프로젝트입니다.

<br>

## 👩‍💻 구현할 기능 목록
### 초기 설정
#### 역
- [x] 교대역, 강남역, 역삼역, 남부터미널역, 양재역, 양재시민의숲역, 매봉역을 등록한다.

#### 노선
- [x] 2호선, 3호선, 신분당선을 등록한다.

#### 구간 정보
- [x] 2호선에는 `상행 종점` 교대역 - ( 2km / 3분 ) - 강남역 - ( 2km / 3분 ) - 역삼역 `하행 종점`을 등록한다.
- [x] 3호선에는 `상행 종점` 교대역 - ( 3km / 2분 ) - 남부터미널역 - ( 6km / 5분 ) - 양재역 - ( 1km / 1분 ) - 매봉역 `하행 종점`을 등록한다.
- [x] 신분당선에는 `상행 종점` 강남역 - ( 2km / 8분 ) - 양재역 - ( 10km / 3분 ) - 양재시민의숲역 `하행 종점`을 등록한다.

### 경로 조회
- [x] 기준은 `최단 거리`와 `최소 시간`이 있다.
- [x] 출발역과 도착역을 입력한다.
    - [x] 출발역과 도착역이 같다면 예외 처리한다.
        - [x] `[ERROR]` 출발역과 도착역이 동일합니다.
    - [ ] 출발역과 도착역이 연결되어 있지 않다면 예외 처리한다.
        - [ ] `[ERROR]` 출발역과 도착역이 연결되어 있지 않습니다.
    - [x] 출발역 또는 도착역에 존재하지 않다면 예외 처리한다.
        - [x] `[ERROR]` 출발역 또는 도착역이 존재하지 않습니다.

### 최단 거리
- [x] 총 거리를 출력한다.
- [ ] 총 소요 시간을 출력한다.
- [x] 최단 거리 경로의 역들을 출력한다.

### 최소 시간
- [ ] 총 거리를 출력한다.
- [x] 총 소요 시간을 출력한다.
- [x] 최소 시간 경로의 역들을 출력한다.

### 입출력
#### 입력
- [x] 메인 화면에서 원하는 기능을 선택한다.
    - [x] 1 또는 Q 외의 기능을 선택한다면 예외 처리한다.
        - [x] `[ERROR]` 화면에 나타난 기능만 선택 가능합니다.
- [x] 경로 기준 화면에서 원하는 기능을 선택한다.
    - [x] 1, 2 또는 B 외의 기능을 선택한다면 예외 처리한다.
        - [x] `[ERROR]` 화면에 나타난 기능만 선택 가능합니다.

#### 출력
- [x] 메인 화면을 출력한다.
- [x] 경로 기준 화면을 출력한다.
- [x] 실행 결과는 `[INFO]`를 붙여서 출력한다.
- [x] 예외 처리는 `[ERROR]`를 붙여서 출력한다.

<br>

## ✅ 확인할 프로그래밍 목록
### 요구사항
- [x] 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - [x] 들여쓰기는 `4 spaces`로 한다.
- [x] (1 <= indent depth) && (indent depth <= 2) 이다.
- [x] 3항 연산자를 쓰지 않는다.
- [x] 함수의 길이는 `15라인`을 넘지 않는다.
    - [x] 함수가 한 가지 일만 하도록 최대한 작게 만든다.
- [x] else 예약어를 쓰지 않는다.
    - [x] `early return`하는 코드를 작성한다.
    - [x] switch/case 문도 사용하지 않는다.
- [x] System.exit 메소드를 사용하지 않는다.
- [x] 비정상적인 입력에 대해 예외를 발생시킨다.

<br>

## 📂 완성된 디렉토리 구조
```
└─java-subway-path-precourse
    │
    ├─docs
    │   └─README.md
    └─src
        └─main
            └─java
                └─subway
                    ├─controller
                    │   ├─validation
                    │   │   └─PathValidation.java
                    │   ├─OptionInterface.java
                    │   ├─PathController.java
                    │   └─SubwayController.java
                    ├─domain
                    │   ├─Line.java
                    │   ├─Station.java
                    │   └─Stations.java
                    ├─repository
                    │   ├─DistanceMapRepository.java
                    │   ├─LineRepository.java
                    │   ├─StationRepository.java
                    │   ├─StationsRepository.java
                    │   └─TimeMapRepository.java
                    ├─service
                    │   ├─initialization
                    │   │   ├─DistanceMapInitialization.java
                    │   │   ├─SubwayInitialization.java
                    │   │   └─TimeMapInitialization.java
                    │   ├─DistanceMapService.java
                    │   ├─PathService.java
                    │   ├─StationService.java
                    │   └─TimeMapService.java
                    ├─type
                    │   ├─DistanceType.java
                    │   ├─ExceptionType.java
                    │   ├─IndexType.java
                    │   ├─InformationType.java
                    │   ├─InputType.java
                    │   ├─LineType.java
                    │   ├─ScreenType.java
                    │   ├─StationType.java
                    │   ├─TextType.java
                    │   ├─TimeType.java
                    ├─view
                    │   ├─InputView.java
                    │   └─OutputView.java
                    └─Application.java
```

<br>

## 📝 License

This project is [MIT](https://github.com/woowacourse/java-subway-path-precourse/blob/master/LICENSE.md) licensed.

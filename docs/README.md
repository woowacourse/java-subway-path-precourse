# Subway Path System
- 본 시스템은 지하철 역간의 경로를 조회하고, 이에 따라서 걸리는 시간 및 거쳐가는 역의 수를 나타내는 프로그램이다.
- 최단 거리와 최단 시간 중 하나를 선택할 수가 있다.
## Entire System
1. 기본 단위인 역을 구현한다.  
a. 역의 이름은 "역"으로 끝나야만 한다.
2. 역 저장소를 구현한다.  
a. 역 이름 사이에는 중복이 있으면 안된다.  
3. 노선을 구현한다.  
a. 노선의 경우, 역과 역사이의 거리 및 시간에 대한 정보를 가지고 있다.  
b. 중복되는 역이 존재해선 안된다.
4. 노선 저장소를 구현한다.  
a. 중복되는 노선의 이름이 있으면 안된다.  
5. 그래프 구조를 가진 시간 중심 자료 저장소를 구현한다.
6. 그래프 구조를 가진 거리 중심 자료 저장소를 구현한다.
7. 입력 값을 위한 InputViewer를 추가 한다.
8. 결과 값 출력을 위한 OutputViewer를 추가 한다.
9. 초창기 값을 입력해주는 Initiator를 추가 한다.
10. 경로 기준 최단 거리를 찾아 주는 Controller를 추가해준다.
11. 경로 기준 최소 시간을 찾아 주는 Controller를 추가해준다.
12. 경로 기준에서 메뉴를 컨트롤 해주는 Controller를 추가 해준다.  
a. 이 때, Input의 처음과 끝이 중복되는지, 해당하는 역이 존재하는 역인지 체크해준다.
b. 환승을 통해서 갈 수 없을 경우에 에러도 생각해준다.
13. 전체적인 경로 시스템을 관리해주는 PathSystem을 구현한다.

### Application
- 전체 시스템을 시동한다.  
### SubwaySystem
- Controller의 PathSystem을 작동시켜 경로를 찾아주는 프로그램을 실행 한다.
### domain
#### Station
- 역 이름 저장
#### StationRepository
- 현재 있는 역에 대한 정보
#### Line
- 노선 이름 저장 및 각 노선들에 저장된 역 정보 출력
#### LineRepository
- 노선들의 이름 저장 및 중복 체크
#### Constants
- domain에서 자주 쓰이는 상수 모음

### View
#### InputView
- 전체적인 인풋 값을 받아오기 위한 Viewer
#### OutputView
- 결과 값을 보여주기 위한 Viewer
#### Constants
- Viewer에서 자수 쓰이는 상수 모음


### Control
#### PathSystem
- 경로 전체 시스템을 관리해주는 Viewer
#### ShortTimeFinder
- 가장 짧은 시간 경로를 계산하는 객체
#### ShortPathFinder
- 가장 짧은 거리 경로를 계산하는 객체
#### Constants
- Controller에서 자주 쓰이는 상수 모음
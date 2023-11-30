package subway.controller;

import subway.view.View;

public class SubwayController {
    private final View view;

    public SubwayController(View view) {
        this.view = view;
    }
    //todo Button 사용 가능할지 고민해 보기

    /*
    경로 기준은 경로 탐색 전략을 결정해 준다.
    이후 시작, 끝 점을 사용해 경로를 탐색한다.


    1. 전략 선택 (최단 거리 / 최단 시간)
    2. 시작 / 끝 역 선택
    3. 경로 구함
    4. 결과 출력
        - 총 거리
        - 총 시간
        - 경로 내 모든 역 (이건 라이브러리의 반환 결과 사용하면 됨)

        -> 총 거리, 총 시간은 라이브러리 반환 결과의 경로를 이용해 구하는 것이 맞는 것 같음
        -> A-B-C-D 경로일 경우
        각 `Line`을 순회하면서 `A-B` 경로가 존재하는지 확인 후 거리와 시간을 가져온다.

        그럼 경로 정보는 `Line`이 가지고 있어야 하겠네

        StationRepository 는 그냥 입력받은 역들이 존재하는 역인지 판단하는 역할 이상은 못할 것 같음

     */


}

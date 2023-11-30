package subway.service;

import subway.repository.SubwayRepository;

public class SubwayService {
    private final SubwayRepository subwayRepository = SubwayRepository.getInstance();

    public void initSubway(){
        subwayRepository.initSubway();
    }
}

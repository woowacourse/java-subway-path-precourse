package subway.service;

import subway.repository.LineRepository;

public class LineService {
    private final LineRepository lineRepository = LineRepository.getInstance();

    public void initLine(){
        lineRepository.initLine();
    }
}

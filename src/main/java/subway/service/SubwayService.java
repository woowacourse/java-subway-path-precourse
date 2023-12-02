package subway.service;

import subway.domain.Station;
import subway.repository.GraphRepository;
import subway.repository.StationRepository;
import subway.repository.SubwayRepository;
import subway.util.exception.SameStationException;

import java.util.ArrayList;
import java.util.List;

import static subway.util.message.ExceptionMessage.SAME_AS;

public class SubwayService {
    private final SubwayRepository subwayRepository = SubwayRepository.getInstance();

    public void initSubway(){
        subwayRepository.initSubway();
    }
}

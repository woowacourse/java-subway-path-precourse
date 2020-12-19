package subway.domain.section;

import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.section.dto.SectionSaveReqDto;
import subway.domain.section.dto.SectionStationAddReqDto;
import subway.domain.section.dto.SectionStationDeleteReqDto;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.domain.station.Stations;
import subway.exception.ErrorCode;
import subway.exception.LineException;
import subway.exception.SectionException;
import subway.exception.StationException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SectionService {
    public static final int CONVERT_SEQUENCE = 1;

    private final SectionRepository sectionRepository;

    public SectionService(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    public Section saveSection(SectionSaveReqDto saveReqDto) {
        Line line = new Line(saveReqDto.getLineName());
        checkAlreadyExist(line.getName());

        Station upwardStation = new Station(saveReqDto.getUpwardStationName());
        checkUpwardNotFound(upwardStation.getName());

        Station downwardStation = new Station(saveReqDto.getDownwardStationName());
        checkDownwardNotFound(downwardStation.getName());
        checkSameName(upwardStation.getName(), downwardStation.getName());

        LineRepository.addLine(line);
        Section section = Section.of(line, new Stations(Arrays.asList(upwardStation, downwardStation)));
        return sectionRepository.addSection(section);
    }

    public void addStation(SectionStationAddReqDto sectionStationAddReqDto) {
        Section section = findByName(sectionStationAddReqDto.getLineName());
        Station station = StationRepository.findByName(sectionStationAddReqDto.getStationName());
        int sequence = sectionStationAddReqDto.getSequence();
        if (sequence > section.getStationsLength()) {
            sequence = section.getStationsLength() + CONVERT_SEQUENCE;
        }
        section.addStation(station, sequence - CONVERT_SEQUENCE);
    }

    public Section findByName(String lineName) {
        Section findSection = sectionRepository.findByName(lineName);
        if (findSection == null) {
            throw new SectionException(ErrorCode.SECTION_NOT_FOUND);
        }
        return findSection;
    }

    private void checkSameName(String upwardStationName, String downwardStationName) {
        if (upwardStationName.equals(downwardStationName)) {
            throw new SectionException(ErrorCode.SECTION_SAME_STATION_NAME);
        }
    }

    public void checkUpwardNotFound(String stationName) {
        try {
            StationRepository.findByName(stationName);
        } catch (StationException stationException) {
            throw new SectionException(ErrorCode.SECTION_NOT_FOUND);
        }
    }

    public void checkDownwardNotFound(String stationName) {
        try {
            StationRepository.findByName(stationName);
        } catch (StationException stationException) {
            throw new SectionException(ErrorCode.SECTION_NOT_FOUND);
        }
    }

    private void checkAlreadyExist(String name) {
        try {
            LineRepository.findByName(name);
        } catch (LineException lineException) {
            return;
        }
        throw new SectionException(ErrorCode.LINE_ALREADY_EXIST);
    }

    public void removeAll() {
        sectionRepository.removeAll();
        LineRepository.deleteAll();
    }
}

package subway.domain.station;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
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
    }

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

    @AfterEach
    public void init() {
        this.stationService.deleteAll();
    }
}

package TrafficMonitor.service;

import TrafficMonitor.dtos.JourneyCreationDto;
import TrafficMonitor.dtos.JourneyDto;

import java.util.List;

public interface JourneyService {

    List<JourneyDto> getJourneys();

    JourneyDto addJourney(JourneyCreationDto creationDto);

    JourneyDto getOne(long id);

    void deleteJourney(long id);
}

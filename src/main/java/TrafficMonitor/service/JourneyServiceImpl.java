package TrafficMonitor.service;

import TrafficMonitor.dtos.JourneyCreationDto;
import TrafficMonitor.dtos.JourneyDto;
import TrafficMonitor.entities.Journey;
import TrafficMonitor.mappers.JourneyMapper;
import TrafficMonitor.repository.JourneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JourneyServiceImpl implements  JourneyService{

    @Autowired
    JourneyRepository repo;

    @Override
    public List<JourneyDto> getJourneys() {
        return repo.findAll()
                .stream()
                .map(JourneyMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public JourneyDto addJourney(JourneyCreationDto creationDto) {
        Journey newJourney = JourneyMapper.toEntity(creationDto);

        return JourneyMapper.toDto(repo.save(newJourney));
    }

    @Override
    public JourneyDto getOne(long id) {
        return JourneyMapper.toDto(repo.getOne(id));
    }

    @Override
    public void deleteJourney(long id) {
        repo.deleteById(id);
    }
}

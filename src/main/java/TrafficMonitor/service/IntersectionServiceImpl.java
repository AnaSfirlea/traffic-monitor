package TrafficMonitor.service;

import TrafficMonitor.dtos.IntersectionCreationDto;
import TrafficMonitor.dtos.IntersectionDto;
import TrafficMonitor.mappers.IntersectionMapper;
import TrafficMonitor.repository.IntersectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IntersectionServiceImpl implements IntersectionService {

    private IntersectionRepository repo;

    public List<IntersectionDto> getIntersections() {
       return repo.findAll()
                .stream()
                .map(IntersectionMapper::toDto)
                .collect(Collectors.toList());

    }

    public IntersectionDto addIntersection(IntersectionCreationDto creationDto) {
        return IntersectionMapper.toDto(repo.save(IntersectionMapper.toEntity(creationDto)));
    }
}

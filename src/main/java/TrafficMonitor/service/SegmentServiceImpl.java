package TrafficMonitor.service;

import TrafficMonitor.dtos.SegmentCreationDto;
import TrafficMonitor.dtos.SegmentDto;
import TrafficMonitor.entities.Segment;
import TrafficMonitor.mappers.SegmentMapper;
import TrafficMonitor.repository.SegmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SegmentServiceImpl {

    @Autowired
    private SegmentRepository repo;

    public SegmentDto addSegment(SegmentCreationDto creationDto) {
        Segment newSegment = SegmentMapper.toEntity(creationDto);

        return SegmentMapper.toDto(repo.save(newSegment));
    }

    public List<SegmentDto> getSegments(){
        return repo.findAll()
                .stream()
                .map(SegmentMapper::toDto)
                .collect(Collectors.toList());
    }

    public SegmentDto getOne(long id) {
        return SegmentMapper.toDto(repo.getOne(id));
    }

}

package TrafficMonitor.service;

import TrafficMonitor.dtos.SegmentCreationDto;
import TrafficMonitor.dtos.SegmentDto;
import TrafficMonitor.entities.Segment;
import TrafficMonitor.generator.SegmentGenerator;
import TrafficMonitor.mappers.SegmentMapper;
import TrafficMonitor.repository.SegmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SegmentServiceImpl implements SegmentService{

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

    public void deleteSegment(long id) {
        repo.deleteById(id);
    }

    @Override
    public void populateRepository() {
        for(int i=0;i<100;i++){
            SegmentCreationDto newSeg = SegmentGenerator.generateSegment();

            repo.save(SegmentMapper.toEntity(newSeg));

        }
    }
}

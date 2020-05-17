package TrafficMonitor.service;

import TrafficMonitor.dtos.SegmentCreationDto;
import TrafficMonitor.dtos.SegmentDto;

import java.util.List;

public interface SegmentService {

    SegmentDto addSegment(SegmentCreationDto creationDto);

    List<SegmentDto> getSegments();

    SegmentDto getOne(long id);

    void deleteSegment(long id);

    void populateRepository();
}

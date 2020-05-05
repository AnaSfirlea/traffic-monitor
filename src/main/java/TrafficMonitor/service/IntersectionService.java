package TrafficMonitor.service;

import TrafficMonitor.dtos.IntersectionCreationDto;
import TrafficMonitor.dtos.IntersectionDto;

import java.util.List;

public interface IntersectionService {

    List<IntersectionDto> getIntersections();

    IntersectionDto addIntersection(IntersectionCreationDto creationDto);
}

package TrafficMonitor.mappers;

import TrafficMonitor.dtos.SegmentCreationDto;
import TrafficMonitor.dtos.SegmentDto;
import TrafficMonitor.entities.Segment;
import org.springframework.stereotype.Component;

@Component
public class SegmentMapper {

    public static SegmentDto toDto(Segment entity) {
        return SegmentDto.builder()
                .id(entity.getId())
                .length(entity.getLength())
                .speedRestriction(entity.getSpeedRestriction())
                .trafficRate(entity.getTrafficRate())
                .build();

    }

    public static Segment toEntity(SegmentCreationDto dto) {
        return Segment.builder()
                .length(dto.getLength())
                .speedRestriction(dto.getSpeedRestriction())
                .trafficRate(dto.getTrafficRate())
                .build();
    }
    public static Segment toEntity(SegmentDto dto) {
        return Segment.builder()
                .id(dto.getId())
                .length(dto.getLength())
                .speedRestriction(dto.getSpeedRestriction())
                .trafficRate(dto.getTrafficRate())
                .build();
    }

}

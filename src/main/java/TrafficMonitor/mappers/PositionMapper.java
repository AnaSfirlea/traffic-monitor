package TrafficMonitor.mappers;

import TrafficMonitor.dtos.PositionDto;
import TrafficMonitor.entities.Position;
import org.springframework.stereotype.Component;

@Component
public class PositionMapper {

    public static PositionDto toDto(Position entity) {
        return PositionDto.builder()
                .timestamp(entity.getTimestamp())
                .segmentDto(SegmentMapper.toDto(entity.getSegment()))
                .latitude(entity.getLatitude())
                .longitude(entity.getLongitude())
                .build();
    }

    public static Position toEntity(PositionDto dto) {
        return Position.builder()
                .timestamp(dto.getTimestamp())
                .segment(SegmentMapper.toEntity(dto.getSegmentDto()))
                .latitude(dto.getLatitude())
                .longitude(dto.getLongitude())
                .build();
    }
}

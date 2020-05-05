package TrafficMonitor.mappers;

import TrafficMonitor.dtos.IntersectionCreationDto;
import TrafficMonitor.dtos.IntersectionDto;
import TrafficMonitor.entities.Intersection;
import org.springframework.stereotype.Component;

@Component
public class IntersectionMapper {

    public static IntersectionDto toDto(Intersection entity) {
        return IntersectionDto.builder()
                .blockingLevel(entity.getBlockingLevel())
                .hasRoundabout(entity.isHasRoundabout())
                .hasSemaphore(entity.isHasSemaphore())
                .build();
    }

    public static Intersection toEntity(IntersectionCreationDto dto) {
        return Intersection.builder()
                .blockingLevel(dto.getBlockingLevel())
                .hasRoundabout(dto.isHasRoundabout())
                .hasSemaphore(dto.isHasSemaphore())
                .build();
    }
}

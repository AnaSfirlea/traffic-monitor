package TrafficMonitor.mappers;

import TrafficMonitor.dtos.SizeAndMeanDto;
import TrafficMonitor.entities.SizeAndMean;
import org.springframework.stereotype.Component;

@Component
public class SizeAndMeanMapper {

    public static SizeAndMeanDto toDto(SizeAndMean entity) {
        return SizeAndMeanDto.builder()
                .size(entity.getSize())
                .mean(entity.getMean())
                .build();
    }

    public static SizeAndMean toEntity(SizeAndMeanDto dto) {
        return SizeAndMean.builder()
                .size(dto.getSize())
                .mean(dto.getMean())
                .build();
    }
}

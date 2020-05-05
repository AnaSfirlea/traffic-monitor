package TrafficMonitor.mappers;

import TrafficMonitor.dtos.SpeedsTsSegCreationDto;
import TrafficMonitor.dtos.SpeedsTsSegDto;
import TrafficMonitor.entities.SpeedsTsSeg;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class SpeedsTsSegMapper {

    public static SpeedsTsSegDto toDto(SpeedsTsSeg entity) {
        return SpeedsTsSegDto.builder()
                .id(entity.getId())
                .segment(SegmentMapper.toDto(entity.getSegment()))
                .timestamp(entity.getTimestamp())
                .timestamp(entity.getTimestamp())
                .speedsList(entity.getSpeedsList())
                .sizeAndMeanDtoList(entity.getSizeAndMeanList()
                        .stream()
                        .map(SizeAndMeanMapper::toDto)
                        .collect(Collectors.toList()))
                .build();
    }

    public static SpeedsTsSeg toEntity(SpeedsTsSegCreationDto dto) {
        return SpeedsTsSeg.builder()
                .segment(SegmentMapper.toEntity(dto.getSegment()))
                .timestamp(dto.getTimestamp())
                .speedsList(dto.getSpeedsList())
                .sizeAndMeanList(dto.getSizeAndMeanDtoList()
                        .stream()
                        .map(SizeAndMeanMapper::toEntity)
                        .collect(Collectors.toList()))
                .build();
    }

    public static SpeedsTsSeg toEntity(SpeedsTsSegDto dto) {
        return SpeedsTsSeg.builder()
                .id(dto.getId())
                .segment(SegmentMapper.toEntity(dto.getSegment()))
                .timestamp(dto.getTimestamp())
                .speedsList(dto.getSpeedsList())
                .sizeAndMeanList(dto.getSizeAndMeanDtoList()
                        .stream()
                        .map(SizeAndMeanMapper::toEntity)
                        .collect(Collectors.toList()))
                .build();
    }
}

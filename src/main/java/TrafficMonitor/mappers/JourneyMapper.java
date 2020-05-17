package TrafficMonitor.mappers;

import TrafficMonitor.dtos.JourneyCreationDto;
import TrafficMonitor.dtos.JourneyDto;
import TrafficMonitor.entities.Journey;
import org.springframework.stereotype.Component;

@Component
public class JourneyMapper {

    public static JourneyDto toDto(Journey entity) {
        return JourneyDto.builder()
                .vehicleDto(VehicleMapper.toDto(entity.getVehicle()))
                .destination(entity.getDestination())
                .estimatedToll(entity.getEstimatedToll())
                .build();
    }
    public static Journey toEntity(JourneyCreationDto dto) {
        return Journey.builder()
                .vehicle(VehicleMapper.toEntity(dto.getVehicleDto()))
                .destination(dto.getDestination())
                .estimatedToll(dto.getEstimatedToll())
                .build();
    }

    public static Journey toEntity(JourneyDto dto) {
        return Journey.builder()
                .vehicle(VehicleMapper.toEntity(dto.getVehicleDto()))
                .destination(dto.getDestination())
                .estimatedToll(dto.getEstimatedToll())
                .build();
    }
}

package TrafficMonitor.mappers;

import TrafficMonitor.dtos.VehicleDto;
import TrafficMonitor.entities.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class VehicleMapper {

    public static VehicleDto toDto(Vehicle entity) {
        return VehicleDto.builder()
                .licencePlate(entity.getLicencePlate())
                .expDateTime(entity.getExpDateTime())
                .speed(entity.getSpeed())
                .dir(entity.getDir())
                .build();
    }

    public static Vehicle toEntity(VehicleDto dto) {
        return Vehicle.builder()
                .licencePlate(dto.getLicencePlate())
                .expDateTime(dto.getExpDateTime())
                .speed(dto.getSpeed())
                .dir(dto.getDir())
                .build();
    }
}

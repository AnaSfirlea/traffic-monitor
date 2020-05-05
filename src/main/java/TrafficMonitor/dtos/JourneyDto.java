package TrafficMonitor.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JourneyDto {
    private long id;

    private VehicleDto vehicleDto;

    private String destination;

    private double estimatedToll;
}

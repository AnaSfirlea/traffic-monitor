package TrafficMonitor.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JourneyCreationDto {

    private VehicleDto vehicleDto;

    private String destination;

    private double estimatedToll;
}

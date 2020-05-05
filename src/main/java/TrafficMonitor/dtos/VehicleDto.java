package TrafficMonitor.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDto {
    private long id;
    private String licencePlate;
    private int speed; //(km/hour)
    private String dir;
    private long expDateTime;
    private PositionDto positionDto;
}

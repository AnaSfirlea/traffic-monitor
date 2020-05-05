package TrafficMonitor.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IntersectionCreationDto {

    private boolean hasSemaphore;
    private boolean hasRoundabout;
    private double blockingLevel;
}

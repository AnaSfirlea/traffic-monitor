package TrafficMonitor.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SegmentCreationDto {

    private float trafficRate; //helps in computing the toll for this segment

    private int length; //expressed in km

    private int speedRestriction; // expressed in km per hour

}

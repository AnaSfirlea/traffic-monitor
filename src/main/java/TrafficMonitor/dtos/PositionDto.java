package TrafficMonitor.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PositionDto {
    private long id;

    private long timestamp;

    private SegmentDto segmentDto;

    private long latitude;

    private long longitude;
}

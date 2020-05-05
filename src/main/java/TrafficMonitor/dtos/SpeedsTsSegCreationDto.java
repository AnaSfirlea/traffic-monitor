package TrafficMonitor.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpeedsTsSegCreationDto {
    private List<Integer> speedsList = new ArrayList<>(); //the list of speeds for a certain segment and timestamp
    private long timestamp;
    private SegmentDto segment;
    private List<SizeAndMeanDto> sizeAndMeanDtoList = new ArrayList<>();
}

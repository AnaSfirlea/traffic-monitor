package TrafficMonitor.generator;

import TrafficMonitor.dtos.PositionCreationDto;
import TrafficMonitor.dtos.PositionDto;
import TrafficMonitor.dtos.SegmentDto;
import TrafficMonitor.entities.Segment;
import TrafficMonitor.mappers.SegmentMapper;
import TrafficMonitor.repository.SegmentRepository;
import TrafficMonitor.utils.Pair;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PositionGenerator {

    public static List<Long> getTimestamps() {
        List<Long> timestamps = new ArrayList<>();
        long current = Timestamp.valueOf("2020-05-15 00:00:00").getTime();
        long end = Timestamp.valueOf("2020-05-29 00:00:00").getTime();

        while(current!=end){
            timestamps.add(current);
            current = current + 60000;
        }

        return timestamps;
    }

    public static List<SegmentDto> getSegments(SegmentRepository segments){
        return segments.findAll()
                .stream()
                .map(SegmentMapper::toDto)
                .collect(Collectors.toList());
    }

    public static Pair<Long,Long> generateLatitudeAndLongitude(SegmentDto segment) {
        long id = segment.getId();

        long latitude = 467667;
        long longitude = 236000;

        return new Pair<>(latitude+id,longitude+id);
    }
    public static PositionCreationDto generatePosition(){
        return null;
    }
}

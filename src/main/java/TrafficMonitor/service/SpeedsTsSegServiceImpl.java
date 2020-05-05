package TrafficMonitor.service;

import TrafficMonitor.dtos.SegmentDto;
import TrafficMonitor.dtos.SizeAndMeanDto;
import TrafficMonitor.dtos.SpeedsTsSegCreationDto;
import TrafficMonitor.dtos.SpeedsTsSegDto;
import TrafficMonitor.entities.Segment;
import TrafficMonitor.entities.SizeAndMean;
import TrafficMonitor.entities.SpeedsTsSeg;
import TrafficMonitor.mappers.SegmentMapper;
import TrafficMonitor.mappers.SizeAndMeanMapper;
import TrafficMonitor.mappers.SpeedsTsSegMapper;
import TrafficMonitor.repository.SpeedsTsSegRepository;
import TrafficMonitor.utils.Pair;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service("SpeedsTsSeg Service")
@AllArgsConstructor
@NoArgsConstructor
public class SpeedsTsSegServiceImpl implements SpeedsTsSegService{

    private SpeedsTsSegRepository repo;

    public List<SpeedsTsSegDto> getAll() {
        return repo.findAll()
                .stream()
                .map(SpeedsTsSegMapper::toDto)
                .collect(Collectors.toList());
    }

    public SpeedsTsSegDto addSpeedsTsSeg(SpeedsTsSegCreationDto s) {
        SpeedsTsSeg speedsTsSeg = SpeedsTsSegMapper.toEntity(s);
        return SpeedsTsSegMapper.toDto(repo.save(speedsTsSeg));
    }

    public SpeedsTsSegDto getOne(long id) {
        return SpeedsTsSegMapper.toDto(repo.getOne(id));
    }

    public void deleteSpeedsTsSeg(long id) {

    }
    public SpeedsTsSegDto getCurrentTsSeg(long currentTimestamp, SegmentDto segmentDto) {
        Segment segment = SegmentMapper.toEntity(segmentDto);
        for (SpeedsTsSeg s : repo.findAll()) {
            //if we found an existing speedList for the currentTimestamp
            if (s.getTimestamp() == currentTimestamp) {
                //if we find an existing speedList for the currentSegment
                if (s.getSegment().getId() == segment.getId()) {
                    return SpeedsTsSegMapper.toDto(s);
                }
            }
        }

        List<Integer> speedsList = new ArrayList<>();
        List<SizeAndMeanDto> sizeAndMeanList = new ArrayList<>();
        SpeedsTsSegCreationDto createdSpeedsTsSegDto = new SpeedsTsSegCreationDto(speedsList ,currentTimestamp,
                segmentDto,sizeAndMeanList);

        return this.addSpeedsTsSeg(createdSpeedsTsSegDto);

    }
    public int getCurrentMean(SpeedsTsSegDto currentSpeedsTsSegDto) {
        SpeedsTsSeg speedsTsSeg = SpeedsTsSegMapper.toEntity(currentSpeedsTsSegDto);
        return speedsTsSeg.calculateMean();
    }
    public int getCurrentSize(SpeedsTsSegDto currentSpeedsTsSegDto) {
        SpeedsTsSeg speedsTsSeg = SpeedsTsSegMapper.toEntity(currentSpeedsTsSegDto);

        return speedsTsSeg.getSpeedsList().size();
    }
    public void addSpeedAndPairSizeMean(SpeedsTsSegDto currentSpeedsTsSegDto, int speed) {
        SpeedsTsSeg speedsTsSeg = SpeedsTsSegMapper.toEntity(currentSpeedsTsSegDto);

        speedsTsSeg.addSpeedAndPairSizeMean(speed);
    }

    public SizeAndMeanDto getCurrentSizeAndMean(SpeedsTsSegDto currentSpeedsTsSegDto) {
        SpeedsTsSeg speedsTsSeg = SpeedsTsSegMapper.toEntity(currentSpeedsTsSegDto);

        return SizeAndMeanMapper.toDto(speedsTsSeg.getSizeAndMean());
    }
    public SizeAndMeanDto getCurrentMaxSizeMaxMean(SpeedsTsSegDto currentSpeedsTsSegDto) {
        SpeedsTsSeg speedsTsSeg = SpeedsTsSegMapper.toEntity(currentSpeedsTsSegDto);

        return SizeAndMeanMapper.toDto(speedsTsSeg.getMaxSizeMaxMean());
    }
    public Pair<Integer, SizeAndMeanDto> getCurrentMaxMarginOfErrorAndSM(SpeedsTsSegDto currentSpeedsTsSegDto) {
        SpeedsTsSeg speedsTsSeg = SpeedsTsSegMapper.toEntity(currentSpeedsTsSegDto);
        Pair<Integer, SizeAndMean> pair = speedsTsSeg.getMaxMarginOfErrorAndSM();

        return new Pair<>(pair.getFirstField(), SizeAndMeanMapper.toDto(pair.getSecondField()));
    }
}

package TrafficMonitor.service;

import TrafficMonitor.dtos.SegmentDto;
import TrafficMonitor.dtos.SizeAndMeanDto;
import TrafficMonitor.dtos.SpeedsTsSegCreationDto;
import TrafficMonitor.dtos.SpeedsTsSegDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SpeedsTsSegService {
    List<SpeedsTsSegDto> getAll();

    SpeedsTsSegDto addSpeedsTsSeg(SpeedsTsSegCreationDto s);

    void deleteSpeedsTsSeg(long id);

    SpeedsTsSegDto getCurrentTsSeg(long currentTimestamp, SegmentDto segmentDto);

    SpeedsTsSegDto getOne(long id);

    int getCurrentMean(SpeedsTsSegDto currentSpeedsTsSegDto);

    int getCurrentSize(SpeedsTsSegDto currentSpeedsTsSegDto);

    void addSpeedAndPairSizeMean(SpeedsTsSegDto currentSpeedsTsSegDto, int speed);

    SizeAndMeanDto getCurrentSizeAndMean(SpeedsTsSegDto currentSpeedsTsSegDto);

    SizeAndMeanDto getCurrentMaxSizeMaxMean(SpeedsTsSegDto currentSpeedsTsSegDto);




}

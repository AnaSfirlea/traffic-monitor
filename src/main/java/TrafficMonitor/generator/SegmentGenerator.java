package TrafficMonitor.generator;

import TrafficMonitor.dtos.SegmentCreationDto;

import java.util.Random;

public class SegmentGenerator {


    private static float generateTrafficRate(){
        return (float) (1 + Math.random() * 9);
    }

    private static int generateLength(){
        Random rand = new Random();

        // generates random int between 1 and 20
        return rand.nextInt(20) + 1;
    }
    private static int generateSpeedRestriction(){
        Random rand = new Random();

        // generates random int between 20 and 70
        return (rand.nextInt(7-2) + 1)*10;
    }

    public static SegmentCreationDto generateSegment(){
        float trafficRate = generateTrafficRate();
        int length = generateLength();
        int speedRestriction = generateSpeedRestriction();


        return new SegmentCreationDto(trafficRate,length,speedRestriction);
    }
}

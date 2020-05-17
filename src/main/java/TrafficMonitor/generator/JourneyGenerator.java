package TrafficMonitor.generator;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class JourneyGenerator {

    private static String generateDestination(){
        List<String> destinations = Arrays.asList("Main Street", "Downtown", "Second Street");
        Random rand = new Random();

        return destinations.get(rand.nextInt(destinations.size()));

    }

    public static void generateJourney(){

        String dest = generateDestination();



    }
}

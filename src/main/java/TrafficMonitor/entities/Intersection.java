package TrafficMonitor.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

import static java.lang.Math.sqrt;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Intersection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private boolean hasSemaphore;

    private boolean hasRoundabout;

    private double blockingLevel; //calculated in terms of number of streets

    @ManyToMany(mappedBy = "intersections")
    private List<Segment> segments;


    @Builder(builderMethodName = "Builder")
    public Intersection(boolean hasSemaphore, boolean hasRoundabout, double blockingLevel) {
        this.hasRoundabout = hasRoundabout;
        this.hasSemaphore = hasSemaphore;
        this.blockingLevel = blockingLevel;
    }

    //poate ar trebui mutata logica asta sau adaugata si in dto??
    public double calculateDefaultBlockingLevel() {
        int nrIntersections = segments.size();

        this.blockingLevel = nrIntersections*10;

        if(hasSemaphore) {
            this.blockingLevel = this.blockingLevel*this.blockingLevel;
        }

        if(hasRoundabout) {
            this.blockingLevel = this.blockingLevel* sqrt(this.blockingLevel);
        }
        return this.blockingLevel;
    }
}

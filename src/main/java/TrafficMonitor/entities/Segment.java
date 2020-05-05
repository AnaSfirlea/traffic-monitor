package TrafficMonitor.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Segment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private float trafficRate; //helps in computing the toll for this segment

    private int length; //expressed in km

    private int speedRestriction; // expressed in km per hour

    @ManyToMany
    @JoinTable(
            name = "segments_intersections",
            joinColumns = @JoinColumn(name = "segment_id"),
            inverseJoinColumns = @JoinColumn(name = "intersection_id"))
    private List<Intersection> intersections;

    @OneToMany(
            mappedBy = "segment",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<SpeedsTsSeg> speedsTsSegList;

    @OneToMany(
            mappedBy = "segment",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Position> positionsList;
}
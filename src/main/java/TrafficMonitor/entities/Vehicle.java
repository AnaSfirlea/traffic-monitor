package TrafficMonitor.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String licencePlate;

    private int speed; //(km/hour)

    @NotBlank
    private String dir;

    private long expDateTime;

    @OneToMany(
            mappedBy = "vehicle",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Journey> journeys;

    @ManyToOne(fetch = FetchType.LAZY)
    private Position currentPosition;
}

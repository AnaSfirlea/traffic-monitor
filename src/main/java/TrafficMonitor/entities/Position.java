package TrafficMonitor.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long timestamp;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Segment segment;

    @NotNull
    private long latitude;

    @NotNull
    private long longitude;

    @OneToMany(
            mappedBy = "currentPosition",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Vehicle> vehicles;
}

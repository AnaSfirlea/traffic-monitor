package TrafficMonitor.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Journey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "vehicle")
    private Vehicle vehicle;

    private String destination;

    private double estimatedToll;


}

package TrafficMonitor.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class SizeAndMean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int size;

    private int mean;

    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name="speeds_ts_seg")
    private SpeedsTsSeg speedsTsSeg;
}

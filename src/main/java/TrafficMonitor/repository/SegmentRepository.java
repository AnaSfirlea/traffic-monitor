package TrafficMonitor.repository;

import TrafficMonitor.entities.Segment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SegmentRepository extends JpaRepository<Segment,Long> {
}

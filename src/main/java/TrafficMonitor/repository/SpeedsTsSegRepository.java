package TrafficMonitor.repository;

import TrafficMonitor.entities.SpeedsTsSeg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeedsTsSegRepository extends JpaRepository<SpeedsTsSeg, Long> {
}

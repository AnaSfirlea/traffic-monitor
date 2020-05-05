package TrafficMonitor.repository;

import TrafficMonitor.entities.Journey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JourneyRepository extends JpaRepository<Journey,Long> {
}

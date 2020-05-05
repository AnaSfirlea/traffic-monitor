package TrafficMonitor.repository;

import TrafficMonitor.entities.SizeAndMean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeAndMeanRepository extends JpaRepository<SizeAndMean,Long> {
}

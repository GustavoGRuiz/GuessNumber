package scaffolding.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import scaffolding.demo.entities.MatchEntity;

@Repository
public interface MatchRepository extends JpaRepository<MatchEntity, Long> {


}

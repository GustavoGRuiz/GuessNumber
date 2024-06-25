package scaffolding.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import scaffolding.demo.entities.DummyEntity;

@Repository

public interface DummyRepository extends JpaRepository<DummyEntity, Long> {


}

package dislog.cs.cs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dislog.cs.cs.model.Modele;

@Repository
public interface ModeleRepository extends JpaRepository<Modele, Long> {
}

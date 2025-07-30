package dislog.cs.cs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dislog.cs.cs.model.Activite;
import dislog.cs.cs.model.Energie;

public interface EnergieRepo extends JpaRepository<Energie, Long> {
      @Query("SELECT e FROM Energie e WHERE e.isActive = ?1")
    List<Energie> findByActive(boolean active);
}

package dislog.cs.cs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dislog.cs.cs.model.Remorque;
import dislog.cs.cs.model.utils.GenreRemorque;
import dislog.cs.cs.model.utils.MarqueRemorque;
import dislog.cs.cs.model.utils.ProprieteRemorque;
import dislog.cs.cs.model.utils.TonnageRemorque;

public interface RemorqueRepo extends JpaRepository<Remorque, Long> {
    List<Remorque> findByIsActiveTrue();

    @Query("""
                SELECT r FROM Remorque r
                WHERE r.isActive = true AND (
                    LOWER(r.matricule) LIKE LOWER(CONCAT('%', :keyword, '%')) OR
                    STR(r.marque) LIKE CONCAT('%', :keyword, '%') OR
                    STR(r.genre) LIKE CONCAT('%', :keyword, '%') OR
                    STR(r.tonnage) LIKE CONCAT('%', :keyword, '%') OR
                    STR(r.propriete) LIKE CONCAT('%', :keyword, '%')
                )
            """)
    List<Remorque> search(@Param("keyword") String keyword);

}

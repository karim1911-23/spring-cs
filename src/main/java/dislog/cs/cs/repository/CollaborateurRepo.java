package dislog.cs.cs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dislog.cs.cs.model.Collaborateur;

public interface CollaborateurRepo extends JpaRepository<Collaborateur, Long> {
    List<Collaborateur> findByIsActiveTrue();

    @Query("""
                SELECT c FROM Collaborateur c
                WHERE c.isActive = true AND (
                    LOWER(c.nom) LIKE LOWER(CONCAT('%', :keyword, '%')) OR
                    LOWER(c.prenom) LIKE LOWER(CONCAT('%', :keyword, '%')) OR
                    LOWER(c.cin) LIKE LOWER(CONCAT('%', :keyword, '%')) OR
                    LOWER(c.cnss) LIKE LOWER(CONCAT('%', :keyword, '%')) OR
                    LOWER(c.ctr) LIKE LOWER(CONCAT('%', :keyword, '%')) OR
                    LOWER(c.poste.poste) LIKE LOWER(CONCAT('%', :keyword, '%')) OR
                    LOWER(c.service.service) LIKE LOWER(CONCAT('%', :keyword, '%')) OR
                    LOWER(c.categorie.categorie) LIKE LOWER(CONCAT('%', :keyword, '%')) OR
                    LOWER(c.departement.departement) LIKE LOWER(CONCAT('%', :keyword, '%')) OR
                    LOWER(c.activite.activite) LIKE LOWER(CONCAT('%', :keyword, '%')) OR
                    LOWER(c.site.site) LIKE LOWER(CONCAT('%', :keyword, '%'))
                )
            """)
    List<Collaborateur> search(@Param("keyword") String keyword);

}

package dislog.cs.cs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dislog.cs.cs.model.Superviseur;

public interface SuperviseurRepo extends JpaRepository<Superviseur, Object> {

        // Trouver tous les superviseurs actifs
        List<Superviseur> findByIsActiveTrue();

        Superviseur findByEmail(String email);
}

package dislog.cs.cs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dislog.cs.cs.model.Vehicule;

public interface VehiculeRepo extends JpaRepository<Vehicule, Long> {
    List<Vehicule> findByIsActiveTrue();
    @Query("""
        SELECT v FROM Vehicule v
        WHERE
            (:search IS NULL OR
                LOWER(v.matricule) LIKE LOWER(CONCAT('%', :search, '%')) OR
                LOWER(v.matAX) LIKE LOWER(CONCAT('%', :search, '%')) OR
                LOWER(v.numeroChasse) LIKE LOWER(CONCAT('%', :search, '%')) OR
                LOWER(v.ww) LIKE LOWER(CONCAT('%', :search, '%')) OR
                LOWER(CAST(v.typeVehicule AS string)) LIKE LOWER(CONCAT('%', :search, '%')) 
            )
            AND (:typeVehicule IS NULL OR v.typeVehicule = :typeVehicule)
            AND (:clientId IS NULL OR v.client.id = :clientId)
            AND (:remorqueId IS NULL OR v.remorque.id = :remorqueId)
            AND (:energieId IS NULL OR v.energie.id = :energieId)
            AND (:marqueId IS NULL OR v.marque.id = :marqueId)
            AND (:tonnageId IS NULL OR v.tonnage.id = :tonnageId)
            AND (:modeleId IS NULL OR v.modele.id = :modeleId)
            AND (:proprieteId IS NULL OR v.proprieteCarteGrise.id = :proprieteId)
            AND (:typeId IS NULL OR v.type.id = :typeId)
            AND (:isActive IS NULL OR v.isActive = :isActive)
            AND (:habillage IS NULL OR v.habillage = :habillage)
    """)
    List<Vehicule> searchAdvanced(
        @Param("search") String search,
        @Param("typeVehicule") dislog.cs.cs.model.utils.TypeVehicule typeVehicule,
        @Param("clientId") Long clientId,
        @Param("remorqueId") Long remorqueId,
        @Param("energieId") Long energieId,
        @Param("marqueId") Long marqueId,
        @Param("tonnageId") Long tonnageId,
        @Param("modeleId") Long modeleId,
        @Param("proprieteId") Long proprieteId,
        @Param("typeId") Long typeId,
        @Param("isActive") Boolean isActive,
        @Param("habillage") Boolean habillage
    );

}

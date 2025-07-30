package dislog.cs.cs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dislog.cs.cs.model.Vehicule;
import dislog.cs.cs.model.utils.TypeVehicule;
import dislog.cs.cs.repository.VehiculeRepo;

@Service
public class VehiculeService {

    @Autowired
    private VehiculeRepo vehiculeRepo;

    public Vehicule create(Vehicule vehicule) {
        return vehiculeRepo.save(vehicule);
    }

    public Vehicule update(Vehicule vehicule) {
        return vehiculeRepo.save(vehicule);
    }

    public Vehicule getById(Long id) {
        Optional<Vehicule> optional = vehiculeRepo.findById(id);
        return optional.orElse(null);
    }

    public List<Vehicule> getAll() {
        return vehiculeRepo.findByIsActiveTrue();
    }

    public void delete(Long id) {
        Optional<Vehicule> optional = vehiculeRepo.findById(id);
        if (optional.isPresent()) {
            Vehicule vehicule = optional.get();
            vehicule.setActive(false);
            vehiculeRepo.save(vehicule);
        }
    }

    
    public List<Vehicule> searchVehicules(
        String search,
        TypeVehicule typeVehicule,
        Long clientId,
        Long remorqueId,
        Long energieId,
        Long marqueId,
        Long tonnageId,
        Long modeleId,
        Long proprieteId,
        Long typeId,
        Boolean isActive,
        Boolean habillage
    ) {
        return vehiculeRepo.searchAdvanced(
            search,
            typeVehicule,
            clientId,
            remorqueId,
            energieId,
            marqueId,
            tonnageId,
            modeleId,
            proprieteId,
            typeId,
            isActive,
            habillage
        );
    }
}

package dislog.cs.cs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dislog.cs.cs.model.Vehicule;
import dislog.cs.cs.model.utils.TypeVehicule;
import dislog.cs.cs.service.VehiculeService;

@RestController
@RequestMapping("/api/admin/vehicule")
public class VehiculeController {

    @Autowired
    private VehiculeService vehiculeService;

    @PostMapping("/create")
    public Vehicule create(@RequestBody Vehicule vehicule) {
        return vehiculeService.create(vehicule);
    }

    @PutMapping("/update")
    public Vehicule update(@RequestBody Vehicule vehicule) {
        return vehiculeService.update(vehicule);
    }

    @GetMapping("/{id}")
    public Vehicule getById(@PathVariable Long id) {
        return vehiculeService.getById(id);
    }

    @GetMapping("/all")
    public List<Vehicule> getAll() {
        return vehiculeService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        vehiculeService.delete(id);
    }

    @GetMapping("/search")
    public List<Vehicule> search(
            @RequestParam(required = false) String search,
            @RequestParam(required = false) TypeVehicule typeVehicule,
            @RequestParam(required = false) Long clientId,
            @RequestParam(required = false) Long remorqueId,
            @RequestParam(required = false) Long energieId,
            @RequestParam(required = false) Long marqueId,
            @RequestParam(required = false) Long tonnageId,
            @RequestParam(required = false) Long modeleId,
            @RequestParam(required = false) Long proprieteId,
            @RequestParam(required = false) Long typeId,
            @RequestParam(required = false) Boolean isActive,
            @RequestParam(required = false) Boolean habillage) {
        return vehiculeService.searchVehicules(
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
                habillage);
    }
}

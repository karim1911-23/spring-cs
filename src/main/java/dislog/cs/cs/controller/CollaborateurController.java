package dislog.cs.cs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import dislog.cs.cs.model.Collaborateur;
import dislog.cs.cs.service.CollaborateurService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin/api/collaborateur")
@Validated
public class CollaborateurController {

    @Autowired
    private CollaborateurService collaborateurService;

    @PostMapping("/create")
    public ResponseEntity<Collaborateur> create(@Valid @RequestBody Collaborateur collaborateur) {
        Collaborateur saved = collaborateurService.save(collaborateur);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/update")
    public ResponseEntity<Collaborateur> update(@Valid @RequestBody Collaborateur collaborateur) {
        Collaborateur updated = collaborateurService.save(collaborateur);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Collaborateur>> getAll() {
        List<Collaborateur> collaborateurs = collaborateurService.getAll();
        return ResponseEntity.ok(collaborateurs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Collaborateur> getById(@PathVariable Long id) {
        Collaborateur collaborateur = collaborateurService.getById(id);
        return ResponseEntity.ok(collaborateur);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        collaborateurService.delete(id);
        return ResponseEntity.ok("Collaborateur désactivé avec succès");
    }

    @GetMapping("/search")
    public ResponseEntity<List<Collaborateur>> search(@RequestParam String keyword) {
        List<Collaborateur> result = collaborateurService.searchCollaborateurs(keyword);
        return ResponseEntity.ok(result);
    }

}

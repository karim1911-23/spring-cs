package dislog.cs.cs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dislog.cs.cs.exception.UserNotFoundException;
import dislog.cs.cs.model.Collaborateur;
import dislog.cs.cs.repository.CollaborateurRepo;

@Service
public class CollaborateurService {

    @Autowired
    private CollaborateurRepo collaborateurRepo;

    // Création ou mise à jour
    public Collaborateur save(Collaborateur collaborateur) {
        return collaborateurRepo.save(collaborateur);
    }

    // Récupérer tous les collaborateurs actifs
    public List<Collaborateur> getAll() {
        return collaborateurRepo.findByIsActiveTrue();
    }

    // Récupérer un collaborateur actif par id
    public Collaborateur getById(Long id) {
        return collaborateurRepo.findById(id)
                .filter(Collaborateur::getIsActive)
                .orElseThrow(() -> new UserNotFoundException("Collaborateur id : " + id + " introuvable"));
    }

    // Suppression soft : désactive le collaborateur
    public void delete(Long id) {
        Collaborateur collaborateur = getById(id);
        collaborateur.setIsActive(false);
        collaborateurRepo.save(collaborateur);
    }
    
    public List<Collaborateur> searchCollaborateurs(String keyword) {
        return collaborateurRepo.search(keyword);
    }

}

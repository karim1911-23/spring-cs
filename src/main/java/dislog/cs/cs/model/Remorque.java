package dislog.cs.cs.model;

import dislog.cs.cs.model.utils.GenreRemorque;
import dislog.cs.cs.model.utils.MarqueRemorque;
import dislog.cs.cs.model.utils.ProprieteRemorque;
import dislog.cs.cs.model.utils.TonnageRemorque;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Remorque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String matricule;
    private boolean isActive=true;

    @Enumerated(EnumType.STRING)
    @Column(name = "marque")
    private MarqueRemorque marque;

    @Enumerated(EnumType.STRING)
    @Column(name = "genre")
    private GenreRemorque genre;

    @Enumerated(EnumType.STRING)
    @Column(name = "tonnage")
    private TonnageRemorque tonnage;

    @Enumerated(EnumType.STRING)
    @Column(name = "propriete")
    private ProprieteRemorque propriete;

}

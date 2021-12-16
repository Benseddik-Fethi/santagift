package fr.santa.santagift.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PereNoel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pere_noel")
    private Long id;
    private String nom;
    private String prenom;
    @OneToMany
    private List<Souhait> souhaitList ;
}

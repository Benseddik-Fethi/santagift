package fr.santa.santagift.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Enfant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_enfant")
    private Long id;
    private String nom;
    private String prenom;
    @OneToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<Souhait> souhaitList;
    @OneToMany
    private List<Cadeau> cadeauList;
}

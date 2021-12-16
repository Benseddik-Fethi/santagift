package fr.santa.santagift.model;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
@Builder
public class Cadeau {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cadeau")
    private Long id;
    @Column(name = "nom_cadeau")
    private String nom;
    @Column(name = "image_cadeau")
    private String image;
    @Column(name = "url_cadeau")
    private String url;

}

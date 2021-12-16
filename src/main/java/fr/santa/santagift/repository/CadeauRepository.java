package fr.santa.santagift.repository;

import fr.santa.santagift.model.Cadeau;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CadeauRepository extends JpaRepository<Cadeau, Long> {
}

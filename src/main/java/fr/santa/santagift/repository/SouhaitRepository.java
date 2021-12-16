package fr.santa.santagift.repository;

import fr.santa.santagift.model.Souhait;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SouhaitRepository extends JpaRepository<Souhait, Long> {
}

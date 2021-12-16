package fr.santa.santagift.repository;

import fr.santa.santagift.model.Enfant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnfantRepository extends JpaRepository<Enfant, Long> {

}

package fr.santa.santagift.repository;

import fr.santa.santagift.SantagiftApplication;
import fr.santa.santagift.model.Enfant;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;



@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EnfantRepositoryTest {


    @Autowired
    private EnfantRepository enfantRepository;

    Enfant enfant = Enfant.builder().nom("John").prenom("Doe").build();

    @Test
    @Order(1)
    void saveEnfant() {
        enfantRepository.save(enfant);
        assertNotNull(enfant.getId());
    }

    @Test
    @Order(2)
    void findById() {
        Enfant enfant = Enfant.builder().nom("John").prenom("Doe").build();
        enfantRepository.save(enfant);
        Enfant found = enfantRepository.findById(enfant.getId()).get();
        assertEquals(enfant.getId(), found.getId());
    }
    @Test
    @Order(3)
    void deleteById() {
        Enfant enfant = Enfant.builder().nom("John").prenom("Doe").build();
        enfantRepository.save(enfant);
        enfantRepository.deleteById(enfant.getId());
        assertEquals(5, enfantRepository.findAll().size());
    }

    @Test
    @Order(4)
    void updateEnfant() {
        Enfant enfant = Enfant.builder().nom("Doe").prenom("John").build();
        enfantRepository.save(enfant);
        Enfant found = enfantRepository.findById(enfant.getId()).get();
        found.setNom("John");
        enfantRepository.save(found);
        assertEquals(found.getNom(), enfantRepository.findById(enfant.getId()).get().getNom());
    }

}
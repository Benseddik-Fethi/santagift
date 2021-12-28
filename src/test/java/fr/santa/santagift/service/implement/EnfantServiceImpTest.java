package fr.santa.santagift.service.implement;

import fr.santa.santagift.dto.EnfantDto;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EnfantServiceImpTest {

    @Autowired
    EnfantServiceImp enfantServiceImp;

    @Test
    @Order(1)
    void getEnfantById() {
        assertEquals("test", enfantServiceImp.findById(1L).get().getNom());
    }

    @Test
    @Order(2)
    void saveEnfant() {
        EnfantDto enfantDto = EnfantDto.builder().nom("John").prenom("Doe").build();
        assertEquals("John", enfantServiceImp.save(enfantDto).get().getNom());
    }

    @Test
    @Order(3)
    void getEnfants() {
        assertFalse(enfantServiceImp.findAll().isEmpty());
    }

    @Test
    @Order(4)
    void deleteEnfant() {
        enfantServiceImp.delete(1L);
        assertFalse(enfantServiceImp.findById(1L).isPresent());
    }
}

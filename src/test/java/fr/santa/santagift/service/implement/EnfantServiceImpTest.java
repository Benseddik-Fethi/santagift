package fr.santa.santagift.service.implement;

import fr.santa.santagift.SantagiftApplication;
import fr.santa.santagift.dto.EnfantDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SantagiftApplication.class)
class EnfantServiceImpTest {

    @Autowired
    EnfantServiceImp enfantServiceImp;

    @Test
    void test1GetEnfantById() {
        assertEquals("test",enfantServiceImp.findById(1L).get().getNom());
    }

    @Test
    void test2SaveEnfant() {
        EnfantDto enfantDto = EnfantDto.builder().nom("John").prenom("Doe").build();
        assertEquals("John",enfantServiceImp.save(enfantDto).get().getNom());
    }
@Test
    void test3GetEnfants(){
    assertFalse(enfantServiceImp.findAll().isEmpty());
    }
    @Test
    void test4DeleteEnfant(){

    }
}

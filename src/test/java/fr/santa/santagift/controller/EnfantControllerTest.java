package fr.santa.santagift.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.santa.santagift.dto.EnfantDto;
import fr.santa.santagift.service.IEnfantService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EnfantControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    IEnfantService enfantService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @Order(1)
    void givenEnfant_whenGetEnfant_thenStatus200() throws Exception {
        mockMvc.perform(get("/enfant")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].nom").value("test"));

    }

    @Test
    @Order(2)
    void givenEnfant_whenGetEnfantById_thenStatus200() throws Exception {
        mockMvc.perform(get("/enfant/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nom").value("test"));

    }

    @Test
    @Order(3)
    void givenEnfant_whenGetEnfantById_thenStatus404() throws Exception {
        mockMvc.perform(get("/enfant/4")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

    }

    @Test
    @Order(4)
    void givenEnfant_whenDeleteEnfantById_thenStatus200() throws Exception {
        mockMvc.perform(delete("/enfant/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    @Test
    @Order(5)
    void givenEnfant_whenCreateEnfant_thenStatus200() throws Exception {
        EnfantDto enfantDto = EnfantDto.builder().nom("test").prenom("test").build();
        mockMvc.perform(post("/enfant")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(enfantDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("test"))
                .andExpect(jsonPath("$.prenom").value("test"));
    }

}
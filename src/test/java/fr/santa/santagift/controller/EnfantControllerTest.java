package fr.santa.santagift.controller;

import fr.santa.santagift.SantagiftApplication;
import fr.santa.santagift.service.IEnfantService;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SantagiftApplication.class)
@AutoConfigureMockMvc
class EnfantControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    IEnfantService enfantService;

    @Test
    void Test1GivenEnfant_whenGetEnfant_thenStatus200() throws Exception {
        mockMvc.perform(get("/enfant")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].nom").value("test"));

    }

    @Test
    void test2GivenEnfant_whenGetEnfantById_thenStatus200() throws Exception {
        mockMvc.perform(get("/enfant/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nom").value("test"));

    }

    @Test
    void test3GivenEnfant_whenGetEnfantById_thenStatus404() throws Exception {
        mockMvc.perform(get("/enfant/4")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

    }
    @Test
    void test4GivenEnfant_whenDeleteEnfantById_thenStatus200() throws Exception {
        mockMvc.perform(delete("/enfant/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
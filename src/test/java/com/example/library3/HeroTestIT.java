package com.example.library3;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HeroTestIT {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void createAHero() throws Exception {
        HeroDto heroDto = new HeroDto("Zach", "Zachkry Neagley","Dummy Image","6","200","JavaBeans",
                "10","500","60","6","Test Desc","Zach Story","Story2");

        mockMvc.perform(post("/hero")
            .content(objectMapper.writeValueAsString(heroDto))
            .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());
        mockMvc.perform(get("/hero")
        ).andExpect(status().isOk())
        .andExpect(jsonPath("length()").value(1));
    }

    @Test
    public void updateAHero() throws Exception {

        HeroDto heroDto = new HeroDto("Zach", "Zachkry Neagley","Dummy Image","6","200","JavaBeans",
                "10","500","60","6","Test Desc","Zach Story","Story2");

        mockMvc.perform(post("/hero")
                        .content(objectMapper.writeValueAsString(heroDto))
                        .contentType(MediaType.APPLICATION_JSON));

        HeroDto heroDto2 = new HeroDto("Zach", "Zachkry Neagley","Dummy Image3","6","200","JavaBeans",
                "10","500","60","6","Test Desc","Zach Story","Story2");

        mockMvc.perform(put("/hero")
                .content(objectMapper.writeValueAsString(heroDto2))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());
        mockMvc.perform(get("/hero")
        ).andExpect(status().isOk());
                //.andExpect(jsonPath("length()").value(1));
    }

    @Test
    public void GetAllHeros() throws Exception {
        HeroDto heroDto1 = new HeroDto("Zach", "Zachkry Neagley","Dummy Image","6","200","JavaBeans",
                "10","500","60","6","Test Desc","Zach Story","Story2");
        HeroDto heroDto2 = new HeroDto("Zach", "Zachkry Neagley","Dummy Image","6","200","JavaBeans",
                "10","500","60","6","Test Desc","Zach Story","Story2");
        HeroDto heroDto3 = new HeroDto("Zach", "Zachkry Neagley","Dummy Image","6","200","JavaBeans",
                "10","500","60","6","Test Desc","Zach Story","Story2");

        mockMvc.perform(post("/hero")
                .content(objectMapper.writeValueAsString(heroDto1))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());
        mockMvc.perform(post("/hero")
                .content(objectMapper.writeValueAsString(heroDto2))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());
        mockMvc.perform(post("/hero")
                .content(objectMapper.writeValueAsString(heroDto3))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());

        mockMvc.perform(get("/hero")
        ).andExpect(status().isOk())
                .andExpect(jsonPath("length()").value(3));
    }

}

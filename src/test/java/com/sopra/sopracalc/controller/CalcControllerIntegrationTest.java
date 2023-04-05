package com.sopra.sopracalc.controller;

import com.sopra.sopracalc.SopraCalcApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SopraCalcApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CalcControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void calcTest() throws Exception {

        assertEquals("20",mockMvc.perform(get("/sopracalc/operation/sum/10/10"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andReturn().getResponse().getContentAsString()
        );
    }

}
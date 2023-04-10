package com.sopra.sopracalc.controller;

import com.sopra.sopracalc.SopraCalcApplication;
import com.sopra.sopracalc.exception.CalcException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.stream.Stream;

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

    private static Stream<Arguments> urlArguments() {
        return Stream.of(
                Arguments.of("/sopracalc/operation/sum/10/10", "20"),
                Arguments.of("/sopracalc/operation/sub/300/150", "150"),
                Arguments.of("/sopracalc/operation/div/300/150", CalcException
                        .OPERATION_NOT_FOUND.getBusinessError()));
    }

    @ParameterizedTest
    @MethodSource("urlArguments")
    void calcTest(String url, String res) throws Exception {

        assertEquals(res,mockMvc.perform(get(url))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andReturn().getResponse().getContentAsString()
        );

    }

}
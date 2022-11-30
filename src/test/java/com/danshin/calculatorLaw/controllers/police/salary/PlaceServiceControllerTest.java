package com.danshin.calculatorLaw.controllers.police.salary;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class PlaceServiceControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAll() throws Exception {
        mockMvc.perform(get("/police/salary/place-services"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("police_salary_place_service_name_1"))
                .andExpect(jsonPath("$[0].percent").value(20))
                .andExpect(jsonPath("$[2].id").value(5))
                .andExpect(jsonPath("$[2].name").value("police_salary_place_service_name_5"))
                .andExpect(jsonPath("$[2].percent").value(75))
                .andExpect(jsonPath("$.size()").value(3));

        mockMvc.perform(get("/police/salary/place-services?date=2015-09-03"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("police_salary_place_service_name_1"))
                .andExpect(jsonPath("$[0].percent").value(20))
                .andExpect(jsonPath("$[1].id").value(4))
                .andExpect(jsonPath("$[1].name").value("police_salary_place_service_name_4"))
                .andExpect(jsonPath("$[1].percent").value(80))
                .andExpect(jsonPath("$.size()").value(2));
    }

    @Test
    void getById200() throws Exception {
        mockMvc.perform(get("/police/salary/place-services/id"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(0));
        mockMvc.perform(get("/police/salary/place-services/id?id=1&id=4"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("police_salary_place_service_name_1"))
                .andExpect(jsonPath("$[0].percent").value(20))
                .andExpect(jsonPath("$[1].id").value(4))
                .andExpect(jsonPath("$[1].name").value("police_salary_place_service_name_4"))
                .andExpect(jsonPath("$[1].percent").value(80))
                .andExpect(jsonPath("$.size()").value(2));
    }
}

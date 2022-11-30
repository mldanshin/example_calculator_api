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
public class SeniorityControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAll() throws Exception {
        mockMvc.perform(get("/police/salary/seniority"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("police_salary_seniority_name_1"))
                .andExpect(jsonPath("$[0].percent").value(5))
                .andExpect(jsonPath("$[4].id").value(6))
                .andExpect(jsonPath("$[4].name").value("police_salary_seniority_name_6"))
                .andExpect(jsonPath("$[4].percent").value(90))
                .andExpect(jsonPath("$.size()").value(5));

        mockMvc.perform(get("/police/salary/seniority?date=2015-03-02"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(2))
                .andExpect(jsonPath("$[0].name").value("police_salary_seniority_name_2"))
                .andExpect(jsonPath("$[0].percent").value(15))
                .andExpect(jsonPath("$[3].id").value(6))
                .andExpect(jsonPath("$[3].name").value("police_salary_seniority_name_6"))
                .andExpect(jsonPath("$[3].percent").value(90))
                .andExpect(jsonPath("$.size()").value(4));
    }

    @Test
    void getById200() throws Exception {
        mockMvc.perform(get("/police/salary/seniority/6"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(6))
                .andExpect(jsonPath("$.name").value("police_salary_seniority_name_6"))
                .andExpect(jsonPath("$.percent").value(90));
    }

    @Test
    void getById400() throws Exception {
        mockMvc.perform(get("/police/salary/seniority/fake"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getById404() throws Exception {
        mockMvc.perform(get("/police/salary/seniority/0"))
                .andExpect(status().isNotFound());
        mockMvc.perform(get("/police/salary/seniority/9999"))
                .andExpect(status().isNotFound());
    }
}

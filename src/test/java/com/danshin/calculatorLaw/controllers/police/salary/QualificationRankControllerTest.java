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
public class QualificationRankControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAll() throws Exception {
        mockMvc.perform(get("/police/salary/qualification-ranks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("police_salary_qualification_rank_name_1"))
                .andExpect(jsonPath("$[0].percent").value(25))
                .andExpect(jsonPath("$[3].id").value(6))
                .andExpect(jsonPath("$[3].name").value("police_salary_qualification_rank_name_6"))
                .andExpect(jsonPath("$[3].percent").value(5))
                .andExpect(jsonPath("$.size()").value(4));

        mockMvc.perform(get("/police/salary/qualification-ranks?date=2015-09-03"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("police_salary_qualification_rank_name_1"))
                .andExpect(jsonPath("$[0].percent").value(25))
                .andExpect(jsonPath("$[2].id").value(5))
                .andExpect(jsonPath("$[2].name").value("police_salary_qualification_rank_name_5"))
                .andExpect(jsonPath("$[2].percent").value(85))
                .andExpect(jsonPath("$.size()").value(3));

    }

    @Test
    void getById200() throws Exception {
        mockMvc.perform(get("/police/salary/qualification-ranks/3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(3))
                .andExpect(jsonPath("$.name").value("police_salary_qualification_rank_name_3"))
                .andExpect(jsonPath("$.percent").value(20));
    }

    @Test
    void getById400() throws Exception {
        mockMvc.perform(get("/police/salary/qualification-ranks/fake"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getById404() throws Exception {
        mockMvc.perform(get("/police/salary/qualification-ranks/0"))
                .andExpect(status().isNotFound());
        mockMvc.perform(get("/police/salary/qualification-ranks/9999"))
                .andExpect(status().isNotFound());
    }
}

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
public class BonusAnnualControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAll() throws Exception {
        mockMvc.perform(get("/police/salary/bonus-annuals"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("police_salary_bonus_annual_name_1"))
                .andExpect(jsonPath("$[0].nameShort").value("police_salary_bonus_annual_name_short_1"))
                .andExpect(jsonPath("$[0].percent").value(34))
                .andExpect(jsonPath("$[1].id").value(3))
                .andExpect(jsonPath("$[1].name").value("police_salary_bonus_annual_name_3"))
                .andExpect(jsonPath("$[1].nameShort").value("police_salary_bonus_annual_name_short_3"))
                .andExpect(jsonPath("$[1].percent").value(15))
                .andExpect(jsonPath("$.size()").value(2));

        mockMvc.perform(get("/police/salary/bonus-annuals?date=2021-11-03"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("police_salary_bonus_annual_name_1"))
                .andExpect(jsonPath("$[0].nameShort").value("police_salary_bonus_annual_name_short_1"))
                .andExpect(jsonPath("$[0].percent").value(34))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("police_salary_bonus_annual_name_2"))
                .andExpect(jsonPath("$[1].nameShort").value("police_salary_bonus_annual_name_short_2"))
                .andExpect(jsonPath("$[1].percent").value(13))
                .andExpect(jsonPath("$.size()").value(2));
    }

    @Test
    void getById200() throws Exception {
        mockMvc.perform(get("/police/salary/bonus-annuals/id"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(0));
        mockMvc.perform(get("/police/salary/bonus-annuals/id?id=1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("police_salary_bonus_annual_name_1"))
                .andExpect(jsonPath("$[0].nameShort").value("police_salary_bonus_annual_name_short_1"))
                .andExpect(jsonPath("$[0].percent").value(34))
                .andExpect(jsonPath("$.size()").value(1));
        mockMvc.perform(get("/police/salary/bonus-annuals/id?id=2&id=3&id=4"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(2))
                .andExpect(jsonPath("$[0].name").value("police_salary_bonus_annual_name_2"))
                .andExpect(jsonPath("$[0].nameShort").value("police_salary_bonus_annual_name_short_2"))
                .andExpect(jsonPath("$[0].percent").value(13))
                .andExpect(jsonPath("$[1].id").value(3))
                .andExpect(jsonPath("$[1].name").value("police_salary_bonus_annual_name_3"))
                .andExpect(jsonPath("$[1].nameShort").value("police_salary_bonus_annual_name_short_3"))
                .andExpect(jsonPath("$[1].percent").value(15))
                .andExpect(jsonPath("$.size()").value(2));
    }
}

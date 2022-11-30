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
public class SpecialConditionsControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAll() throws Exception {
        mockMvc.perform(get("/police/salary/special-conditions"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("police_salary_special_conditions_name_1"))
                .andExpect(jsonPath("$[0].nameShort").value("police_salary_special_conditions_name_short_1"))
                .andExpect(jsonPath("$[0].percentMin").value(0))
                .andExpect(jsonPath("$[0].percentMax").value(25))
                .andExpect(jsonPath("$[5].id").value(7))
                .andExpect(jsonPath("$[5].name").value("police_salary_special_conditions_name_7"))
                .andExpect(jsonPath("$[5].nameShort").value("police_salary_special_conditions_name_short_7"))
                .andExpect(jsonPath("$[5].percentMin").value(0))
                .andExpect(jsonPath("$[5].percentMax").value(10))
                .andExpect(jsonPath("$.size()").value(6));

        mockMvc.perform(get("/police/salary/special-conditions?date=2014-03-02"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("police_salary_special_conditions_name_1"))
                .andExpect(jsonPath("$[0].nameShort").value("police_salary_special_conditions_name_short_1"))
                .andExpect(jsonPath("$[0].percentMin").value(0))
                .andExpect(jsonPath("$[0].percentMax").value(25))
                .andExpect(jsonPath("$[3].id").value(6))
                .andExpect(jsonPath("$[3].name").value("police_salary_special_conditions_name_6"))
                .andExpect(jsonPath("$[3].nameShort").value("police_salary_special_conditions_name_short_6"))
                .andExpect(jsonPath("$[3].percentMin").value(0))
                .andExpect(jsonPath("$[3].percentMax").value(25))
                .andExpect(jsonPath("$.size()").value(4));
    }

    @Test
    void getById200() throws Exception {
        mockMvc.perform(get("/police/salary/special-conditions/id"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(0));
        mockMvc.perform(get("/police/salary/special-conditions/id?id=1&id=7"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("police_salary_special_conditions_name_1"))
                .andExpect(jsonPath("$[0].nameShort").value("police_salary_special_conditions_name_short_1"))
                .andExpect(jsonPath("$[0].percentMin").value(0))
                .andExpect(jsonPath("$[0].percentMax").value(25))
                .andExpect(jsonPath("$[1].id").value(7))
                .andExpect(jsonPath("$[1].name").value("police_salary_special_conditions_name_7"))
                .andExpect(jsonPath("$[1].nameShort").value("police_salary_special_conditions_name_short_7"))
                .andExpect(jsonPath("$[1].percentMin").value(0))
                .andExpect(jsonPath("$[1].percentMax").value(10))
                .andExpect(jsonPath("$.size()").value(2));
    }
}

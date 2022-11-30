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
public class StateSecretControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAll() throws Exception {
        mockMvc.perform(get("/police/salary/state-secrets"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("police_salary_state_secret_name_1"))
                .andExpect(jsonPath("$[0].percentMin").value(0))
                .andExpect(jsonPath("$[0].percentMax").value(35))
                .andExpect(jsonPath("$[3].id").value(6))
                .andExpect(jsonPath("$[3].name").value("police_salary_state_secret_name_6"))
                .andExpect(jsonPath("$[3].percentMin").value(0))
                .andExpect(jsonPath("$[3].percentMax").value(90))
                .andExpect(jsonPath("$.size()").value(4));

        mockMvc.perform(get("/police/salary/state-secrets?date=2015-09-03"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("police_salary_state_secret_name_1"))
                .andExpect(jsonPath("$[0].percentMin").value(0))
                .andExpect(jsonPath("$[0].percentMax").value(35))
                .andExpect(jsonPath("$[1].id").value(4))
                .andExpect(jsonPath("$[1].name").value("police_salary_state_secret_name_4"))
                .andExpect(jsonPath("$[1].percentMin").value(0))
                .andExpect(jsonPath("$[1].percentMax").value(30))
                .andExpect(jsonPath("$.size()").value(2));
    }

    @Test
    void getById200() throws Exception {
        mockMvc.perform(get("/police/salary/state-secrets/id"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(0));
        mockMvc.perform(get("/police/salary/state-secrets/id?id=2&id=3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(2))
                .andExpect(jsonPath("$[0].name").value("police_salary_state_secret_name_2"))
                .andExpect(jsonPath("$[0].percentMin").value(0))
                .andExpect(jsonPath("$[0].percentMax").value(3))
                .andExpect(jsonPath("$[1].id").value(3))
                .andExpect(jsonPath("$[1].name").value("police_salary_state_secret_name_3"))
                .andExpect(jsonPath("$[1].percentMin").value(0))
                .andExpect(jsonPath("$[1].percentMax").value(5))
                .andExpect(jsonPath("$.size()").value(2));
    }
}

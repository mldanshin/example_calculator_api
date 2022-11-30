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
public class LawControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAll() throws Exception {
        mockMvc.perform(get("/police/salary/laws"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].type").value("constitution"))
                .andExpect(jsonPath("$[0].importance").value(1))
                .andExpect(jsonPath("$[0].number").value(34))
                .andExpect(jsonPath("$[0].name").value("fake_content_1"))
                .andExpect(jsonPath("$[1].type").value("law"))
                .andExpect(jsonPath("$[1].importance").value(2))
                .andExpect(jsonPath("$[1].number").value(98))
                .andExpect(jsonPath("$[1].name").value("fake_content_3"))
                .andExpect(jsonPath("$.size()").value(2));

        mockMvc.perform(get("/police/salary/laws?date=2011-01-01"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(0));

        mockMvc.perform(get("/police/salary/laws?date=2018-01-02"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(0));

        mockMvc.perform(get("/police/salary/laws?date=2017-01-03"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].type").value("constitution"))
                .andExpect(jsonPath("$[0].importance").value(1))
                .andExpect(jsonPath("$[0].number").value(16))
                .andExpect(jsonPath("$[0].name").value("fake_content_5"))
                .andExpect(jsonPath("$.size()").value(1));
    }
}

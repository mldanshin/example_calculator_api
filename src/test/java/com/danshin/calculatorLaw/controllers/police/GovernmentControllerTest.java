package com.danshin.calculatorLaw.controllers.police;

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
public class GovernmentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAll() throws Exception {
        mockMvc.perform(get("/police/governments"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("police_government_name_1"))
                .andExpect(jsonPath("$[0].nameShort").value("police_government_name_short_1"))
                .andExpect(jsonPath("$[3].id").value(6))
                .andExpect(jsonPath("$[3].name").value("police_government_name_6"))
                .andExpect(jsonPath("$[3].nameShort").value("police_government_name_short_6"))
                .andExpect(jsonPath("$.size()").value(4));

        mockMvc.perform(get("/police/governments?date=2013-01-01"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("police_government_name_1"))
                .andExpect(jsonPath("$[0].nameShort").value("police_government_name_short_1"))
                .andExpect(jsonPath("$[1].id").value(3))
                .andExpect(jsonPath("$[1].name").value("police_government_name_3"))
                .andExpect(jsonPath("$[1].nameShort").value("police_government_name_short_3"))
                .andExpect(jsonPath("$.size()").value(2));

        mockMvc.perform(get("/police/governments?date=2019-09-11"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("police_government_name_1"))
                .andExpect(jsonPath("$[0].nameShort").value("police_government_name_short_1"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("police_government_name_2"))
                .andExpect(jsonPath("$[1].nameShort").value("police_government_name_short_2"))
                .andExpect(jsonPath("$.size()").value(5));
    }
}

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
public class RankControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAll() throws Exception {
        mockMvc.perform(get("/police/ranks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(2))
                .andExpect(jsonPath("$[0].name").value("police_rank_name_2"))
                .andExpect(jsonPath("$[0].salary").value(18000))
                .andExpect(jsonPath("$[3].id").value(6))
                .andExpect(jsonPath("$[3].name").value("police_rank_name_6"))
                .andExpect(jsonPath("$[3].salary").value(66000))
                .andExpect(jsonPath("$.size()").value(4));

        mockMvc.perform(get("/police/ranks?post_type=1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(4))
                .andExpect(jsonPath("$[0].name").value("police_rank_name_4"))
                .andExpect(jsonPath("$[0].salary").value(31000))
                .andExpect(jsonPath("$[1].id").value(6))
                .andExpect(jsonPath("$[1].name").value("police_rank_name_6"))
                .andExpect(jsonPath("$[1].salary").value(66000))
                .andExpect(jsonPath("$.size()").value(2));

        mockMvc.perform(get("/police/ranks?date=2018-09-09"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("police_rank_name_1"))
                .andExpect(jsonPath("$[0].salary").value(12000))
                .andExpect(jsonPath("$[3].id").value(6))
                .andExpect(jsonPath("$[3].name").value("police_rank_name_6"))
                .andExpect(jsonPath("$[3].salary").value(66000))
                .andExpect(jsonPath("$.size()").value(4));

        mockMvc.perform(get("/police/ranks?date=2018-09-09&post_type=2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(3))
                .andExpect(jsonPath("$[0].name").value("police_rank_name_3"))
                .andExpect(jsonPath("$[0].salary").value(29000))
                .andExpect(jsonPath("$.size()").value(1));
    }

    @Test
    void getById200() throws Exception {
        mockMvc.perform(get("/police/ranks/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("police_rank_name_1"))
                .andExpect(jsonPath("$.salary").value(12000));
        mockMvc.perform(get("/police/ranks/4"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(4))
                .andExpect(jsonPath("$.name").value("police_rank_name_4"))
                .andExpect(jsonPath("$.salary").value(31000));
    }

    @Test
    void getById400() throws Exception {
        mockMvc.perform(get("/police/ranks/fake"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getById404() throws Exception {
        mockMvc.perform(get("/police/ranks/0"))
                .andExpect(status().isNotFound());
        mockMvc.perform(get("/police/ranks/9999"))
                .andExpect(status().isNotFound());
    }
}

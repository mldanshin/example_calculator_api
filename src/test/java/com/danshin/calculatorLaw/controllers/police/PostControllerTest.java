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
public class PostControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAll() throws Exception {
        mockMvc.perform(get("/police/posts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("police_name_1"))
                .andExpect(jsonPath("$[0].nameShort").value("police_name_short_1"))
                .andExpect(jsonPath("$[0].salary").value(23000))
                .andExpect(jsonPath("$[3].id").value(6))
                .andExpect(jsonPath("$[3].name").value("police_name_6"))
                .andExpect(jsonPath("$[3].nameShort").value("police_name_short_6"))
                .andExpect(jsonPath("$[3].salary").value(10000))
                .andExpect(jsonPath("$.size()").value(4));
        mockMvc.perform(get("/police/posts?type=1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(2))
                .andExpect(jsonPath("$[0].name").value("police_name_2"))
                .andExpect(jsonPath("$[0].nameShort").value("police_name_short_2"))
                .andExpect(jsonPath("$[0].salary").value(34000))
                .andExpect(jsonPath("$[1].id").value(6))
                .andExpect(jsonPath("$[1].name").value("police_name_6"))
                .andExpect(jsonPath("$[1].nameShort").value("police_name_short_6"))
                .andExpect(jsonPath("$[1].salary").value(10000));
        mockMvc.perform(get("/police/posts?government=2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(2))
                .andExpect(jsonPath("$[0].name").value("police_name_2"))
                .andExpect(jsonPath("$[0].nameShort").value("police_name_short_2"))
                .andExpect(jsonPath("$[0].salary").value(34000))
                .andExpect(jsonPath("$[1].id").value(3))
                .andExpect(jsonPath("$[1].name").value("police_name_3"))
                .andExpect(jsonPath("$[1].nameShort").value("police_name_short_3"))
                .andExpect(jsonPath("$[1].salary").value(11000))
                .andExpect(jsonPath("$.size()").value(2));
        mockMvc.perform(get("/police/posts?government=4&type=3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(0));
        mockMvc.perform(get("/police/posts?date=2019-11-04"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[2].id").value(4))
                .andExpect(jsonPath("$[2].name").value("police_name_4"))
                .andExpect(jsonPath("$[2].nameShort").value("police_name_short_4"))
                .andExpect(jsonPath("$[2].salary").value(34000))
                .andExpect(jsonPath("$.size()").value(3));
        mockMvc.perform(get("/police/posts?government=4&type=3&date=2019-11-04"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(4))
                .andExpect(jsonPath("$[0].name").value("police_name_4"))
                .andExpect(jsonPath("$[0].nameShort").value("police_name_short_4"))
                .andExpect(jsonPath("$[0].salary").value(34000))
                .andExpect(jsonPath("$.size()").value(1));
    }

    @Test
    void getById200() throws Exception {
        mockMvc.perform(get("/police/posts/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("police_name_1"))
                .andExpect(jsonPath("$.nameShort").value("police_name_short_1"))
                .andExpect(jsonPath("$.salary").value(23000));
        mockMvc.perform(get("/police/posts/4"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(4))
                .andExpect(jsonPath("$.name").value("police_name_4"))
                .andExpect(jsonPath("$.nameShort").value("police_name_short_4"))
                .andExpect(jsonPath("$.salary").value(34000));
    }

    @Test
    void getById400() throws Exception {
        mockMvc.perform(get("/police/posts/fake"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getById404() throws Exception {
        mockMvc.perform(get("/police/posts/0"))
                .andExpect(status().isNotFound());
        mockMvc.perform(get("/police/posts/9999"))
                .andExpect(status().isNotFound());
    }
}

package com.danshin.calculatorLaw.controllers.police.salary;

import com.danshin.calculatorLaw.models.Pair;
import com.danshin.calculatorLaw.requests.police.salary.CalculationRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.stream.Stream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class CalculationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    public static Stream<CalculationRequestDto> getCalculation200Provider() {
        return Stream.of(
                CalculationRequestDto.builder()
                        .post(1)
                        .rank(1)
                        .seniority(1)
                        .regionalCoefficient((short) 0)
                        .build(),
                CalculationRequestDto.builder()
                        .post(1)
                        .rank(1)
                        .seniority(1)
                        .qualificationRank(1)
                        .stateSecret(new Pair(2, (short) 23))
                        .specialConditions(List.of(
                                new Pair(4, (short) 55)
                        ))
                        .specialAchievement(List.of(3))
                        .danger(List.of(2))
                        .bonusAnnual(List.of(5))
                        .placeService(List.of(1))
                        .regionalCoefficient((short) 0)
                        .bonusOneTime(List.of(3))
                        .build()
        );
    }

    public static Stream<CalculationRequestDto> getCalculation400Provider() {
        return Stream.of(
                CalculationRequestDto.builder()
                        .rank(1)
                        .seniority(1)
                        .regionalCoefficient((short) 0)
                        .build(),
                CalculationRequestDto.builder()
                        .post(1)
                        .seniority(1)
                        .regionalCoefficient((short) 0)
                        .build(),
                CalculationRequestDto.builder()
                        .post(1)
                        .rank(1)
                        .regionalCoefficient((short) 0)
                        .build(),
                CalculationRequestDto.builder()
                        .post(1)
                        .rank(1)
                        .seniority(1)
                        .build(),
                CalculationRequestDto.builder()
                        .post(999)
                        .rank(1)
                        .seniority(1)
                        .regionalCoefficient((short) 0)
                        .build(),
                CalculationRequestDto.builder()
                        .post(1)
                        .rank(999)
                        .seniority(1)
                        .regionalCoefficient((short) 0)
                        .build(),
                CalculationRequestDto.builder()
                        .post(1)
                        .rank(1)
                        .seniority(999)
                        .regionalCoefficient((short) 0)
                        .build(),
                CalculationRequestDto.builder()
                        .post(1)
                        .rank(1)
                        .seniority(1)
                        .qualificationRank(999)
                        .regionalCoefficient((short) 0)
                        .build()
        );
    }

    @ParameterizedTest
    @MethodSource("getCalculation200Provider")
    void getCalculation200(CalculationRequestDto dto) throws Exception {
        String url = "/police/salary/calculation";

        mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk());
    }

    @ParameterizedTest
    @MethodSource("getCalculation400Provider")
    void getCalculation400(CalculationRequestDto dto) throws Exception {
        String url = "/police/salary/calculation";

        mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isBadRequest());
    }
}

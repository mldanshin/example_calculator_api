package com.danshin.calculatorLaw.models.police;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:lang/label.prop", encoding = "UTF-8")
@Getter
public class Label {
    @Value("${government}")
    private String government;

    @Value("${post_type}")
    private String postType;

    @Value("${post}")
    private String post;

    @Value("${rank}")
    private String rank;

    @Value("${seniority}")
    private String seniority;

    @Value("${qualification_rank}")
    private String qualificationRank;

    @Value("${state_secret}")
    private String stateSecret;

    @Value("${special_conditions}")
    private String specialConditions;

    @Value("${special_achievement}")
    private String specialAchievement;

    @Value("${danger}")
    private String danger;

    @Value("${bonus_annual}")
    private String bonusAnnual;

    @Value("${bonus_one_time}")
    private String bonusOneTime;

    @Value("${regional_coefficient}")
    private String regionalCoefficient;

    @Value("${place_service}")
    private String placeService;
}

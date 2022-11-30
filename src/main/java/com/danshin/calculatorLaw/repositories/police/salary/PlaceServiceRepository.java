package com.danshin.calculatorLaw.repositories.police.salary;

import com.danshin.calculatorLaw.models.dto.police.salary.PlaceServiceDto;
import com.danshin.calculatorLaw.models.police.salary.PlaceService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface PlaceServiceRepository extends JpaRepository<PlaceService, Integer> {
    @Query("SELECT NEW com.danshin.calculatorLaw.models.dto.police.salary.PlaceServiceDto(" +
            "p.id," +
            "p.name," +
            "p.percent" +
            ") " +
            "FROM PlaceService p " +
            "WHERE p.dateStart <= :date AND (p.dateEnd IS NULL OR :date <= p.dateEnd)")
    List<PlaceServiceDto> getAll(@NotNull @Param("date") LocalDate date);

    @Query("SELECT NEW com.danshin.calculatorLaw.models.dto.police.salary.PlaceServiceDto(" +
            "p.id," +
            "p.name," +
            "p.percent" +
            ") " +
            "FROM PlaceService p " +
            "WHERE p.id IN (:id)")
    List<PlaceServiceDto> getById(@NotNull @Param("id") List<Integer> id);
}

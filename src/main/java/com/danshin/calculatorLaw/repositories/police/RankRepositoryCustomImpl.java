package com.danshin.calculatorLaw.repositories.police;

import com.danshin.calculatorLaw.models.dto.police.RankDto;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public class RankRepositoryCustomImpl implements RankRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<RankDto> getAll(
            @NotNull Integer postTypeId,
            @NotNull LocalDate date
    ) {
        String s = "SELECT NEW com.danshin.calculatorLaw.models.dto.police.RankDto(" +
                "r.id," +
                "r.name," +
                "r.salary" +
                ") " +
                "FROM Rank r " +
                "WHERE (r.dateStart <= '" + date + "' AND (r.dateEnd IS NULL OR '" + date + "' <= r.dateEnd)) " +
                (postTypeId != null ? (" AND r.postType.id = " + postTypeId) : "");
        return entityManager.createQuery(s, RankDto.class).getResultList();
    }

    @Override
    public RankDto getById(int id) {
        String s = "SELECT NEW com.danshin.calculatorLaw.models.dto.police.RankDto(" +
                "r.id," +
                "r.name," +
                "r.salary" +
                ") " +
                "FROM Rank r " +
                "WHERE r.id = :id";
        TypedQuery<RankDto> typedQuery = entityManager.createQuery(s, RankDto.class).setParameter("id", id);
        try {
            return typedQuery.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}

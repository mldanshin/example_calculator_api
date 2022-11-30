package com.danshin.calculatorLaw.repositories.police;

import com.danshin.calculatorLaw.models.dto.police.PostDto;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public class PostRepositoryCustomImpl implements PostRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<PostDto> getAll(
            @NotNull Integer governmentId,
            @NotNull Integer typeId,
            @NotNull LocalDate date
    ) {
        String s = "SELECT NEW com.danshin.calculatorLaw.models.dto.police.PostDto(" +
                "p.id," +
                "p.name," +
                "p.nameShort," +
                "p.salary" +
                ") " +
                "FROM Post p " +
                "WHERE (p.dateStart <= '" + date + "' AND (p.dateEnd IS NULL OR '" + date + "' <= p.dateEnd)) " +
                ((governmentId != null || typeId != null) ? " AND " : "") +
                (governmentId != null ? (" p.government.id = " + governmentId) : "") +
                ((governmentId != null && typeId != null) ? " AND " : "") +
                (typeId != null ? (" p.postType.id = " + typeId) : "");
        return entityManager.createQuery(s, PostDto.class).getResultList();
    }

    public PostDto getById(int id) {
        String s = "SELECT NEW com.danshin.calculatorLaw.models.dto.police.PostDto(" +
                "p.id," +
                "p.name," +
                "p.nameShort," +
                "p.salary" +
                ") " +
                "FROM Post p " +
                "WHERE p.id = :id";
        TypedQuery<PostDto> typedQuery = entityManager.createQuery(s, PostDto.class).setParameter("id", id);

        try {
            return typedQuery.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}

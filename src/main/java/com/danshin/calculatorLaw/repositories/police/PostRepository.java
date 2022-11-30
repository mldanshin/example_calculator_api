package com.danshin.calculatorLaw.repositories.police;

import com.danshin.calculatorLaw.models.police.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>, PostRepositoryCustom {
}

package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sigep.gbc.entity.DecisionSarticle;

public interface DecisionSArticleRepository extends JpaRepository<DecisionSarticle, Integer>{
	
	@Modifying
	@Query(value = """ 
			UPDATE DecisionSArticle SET
			numArticle = :newNumArticle,
			IntituleArticle = :intituleArticle,
			IntituleArticleReam = :intituleArticleReam
			WHERE numArticle = :oldNumArticle
			""", nativeQuery = true)
	public void update(
			@Param("newNumArticle") int newNumArticle,
			@Param("oldNumArticle") int oldNumArticle,
			@Param("intituleArticle") String intituleArticle,
			@Param("intituleArticleReam") String intituleArticleReam
		);
}

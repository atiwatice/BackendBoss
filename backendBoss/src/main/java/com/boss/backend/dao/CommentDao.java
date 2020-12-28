package com.boss.backend.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boss.backend.model.DAOComment;

@Repository
public interface CommentDao extends CrudRepository<DAOComment, Integer> {
	@Query("select m from DAOComment m where m.subTaskId.subTaskId = ?1")
	List<DAOComment> findAllSubTaskBySubTaskId(int subTaskId);

	@Transactional
	void deleteByCommentId(int commentId);

	DAOComment findByCommentId(int commentId);
}

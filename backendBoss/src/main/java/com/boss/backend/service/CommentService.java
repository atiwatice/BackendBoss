package com.boss.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boss.backend.dao.CommentDao;
import com.boss.backend.model.CommentDTO;
import com.boss.backend.model.DAOComment;

@Service
public class CommentService {
	@Autowired
	CommentDao commentDao;

	// Add comment
	public DAOComment save(CommentDTO comment) throws Exception {

		DAOComment newComment = new DAOComment();

		newComment.setCommentDetail(comment.getCommentDetail());
		newComment.setCommentOwner(comment.getCommentOwner());
		newComment.setSubTaskId(comment.getSubTaskId());

		return commentDao.save(newComment);
	}

	// update comment
	public DAOComment updateComment(int id, CommentDTO comment) throws Exception {
		DAOComment commentId = commentDao.findByCommentId(id);

		if (commentId == null) {
			return commentId;
		}

		if (comment.getCommentDetail() != null)
			commentId.setCommentDetail(comment.getCommentDetail());

		return commentDao.save(commentId);
	}

	public void deleteComment(int id) {
		commentDao.deleteByCommentId(id);
	}

	public List<DAOComment> findAllComment(int comment) {
		return (List<DAOComment>) commentDao.findAllSubTaskBySubTaskId(comment);
	}
	
	public Optional<DAOComment> findCommentById(int commentId) {
		return  Optional.ofNullable(commentDao.findByCommentId(commentId));
	}

}

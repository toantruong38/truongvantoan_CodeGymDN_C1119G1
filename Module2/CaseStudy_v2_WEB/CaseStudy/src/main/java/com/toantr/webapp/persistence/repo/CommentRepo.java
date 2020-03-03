package com.toantr.webapp.persistence.repo;

import com.toantr.webapp.persistence.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment,Integer>
{
}

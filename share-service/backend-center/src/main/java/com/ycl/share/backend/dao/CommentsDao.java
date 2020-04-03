package com.ycl.share.backend.dao;

import com.ycl.share.backend.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 评论dao
 */
public interface CommentsDao extends JpaRepository<Comments, Long> {
    List<Comments> findByDynamicId(Long id);
}

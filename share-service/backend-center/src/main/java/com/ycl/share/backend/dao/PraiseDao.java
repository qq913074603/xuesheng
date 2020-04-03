package com.ycl.share.backend.dao;

import com.ycl.share.backend.model.Praise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 点赞dao
 */
public interface PraiseDao extends JpaRepository<Praise, Long> {

    List<Praise> findByDynamicId(Long id);

    Praise findByDynamicIdAndCreateBy(Long dynamicId, String loginName);
}

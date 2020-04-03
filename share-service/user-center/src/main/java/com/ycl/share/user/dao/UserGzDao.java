package com.ycl.share.user.dao;

import com.ycl.share.user.model.UserGz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 用户关注dao
 */
public interface UserGzDao extends JpaRepository<UserGz, Long> {

    List<UserGz> findByUserId(Long userId);

    UserGz findByUserIdAndGzUserId(Long userId, Long id);
}

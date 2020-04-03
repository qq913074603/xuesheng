package com.ycl.share.user.dao;

import com.ycl.share.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * user查询
 */
public interface UserDao extends JpaRepository<User, Long> {

    /**
     * 用户名密码查询
     * @param loginName
     * @param password
     * @return
     */
    User findByLoginNameAndPassword(String loginName, String password);

    /**
     * 用户查询
     * @param loginName
     * @param loginName
     * @return
     */
    User findByLoginName(String loginName);
}

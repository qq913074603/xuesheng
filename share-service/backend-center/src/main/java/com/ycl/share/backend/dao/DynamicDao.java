package com.ycl.share.backend.dao;

import com.ycl.share.backend.model.Dynamic;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 数据层
 */
public interface DynamicDao extends JpaRepository<Dynamic, Long> {

//    @Query(
//            "select * from t_dynamic where " +
//                    " if(:query.createBy != '', create_by = :query.createBy, 1 = 1) " +
//                    " order by create_time desc"
//    )
//    Page<Dynamic> pageDynamic(@Param("query") DynamicReq req, Pageable pageable);

//    @Query(
//            "Dynamic t where " +
//                    " if(:createBy != '', create_by = :createBy, 1 = 1) " +
//                    " order by create_time desc"
//    )
//    Page<Dynamic> pageDynamic(@Param("createBy") String createBy, Pageable pageable);
}

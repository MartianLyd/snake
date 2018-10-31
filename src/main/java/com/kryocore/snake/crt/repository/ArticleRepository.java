package com.kryocore.snake.crt.repository;

import com.kryocore.snake.crt.entity.ArticleBean;
import com.kryocore.snake.crt.entity.NewsDetail;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ArticleRepository extends CrudRepository<ArticleBean, Long> {

    @Query(value = "select * from EN_ZN_SOURCE_DATA where mask=?1 ", nativeQuery = true)
    ArticleBean findByNewsMark(String newsMark);


    @Query(value="select * from EN_ZN_SOURCE_DATA where id>?1 limit ?2",nativeQuery=true)
    List<ArticleBean> from(int start, int pageSize);


}

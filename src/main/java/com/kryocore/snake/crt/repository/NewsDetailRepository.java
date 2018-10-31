package com.kryocore.snake.crt.repository;

import com.kryocore.snake.crt.entity.NewsDetail;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface NewsDetailRepository extends CrudRepository<NewsDetail, Long> {

    @Query(value = "select * from NEWS where news_mark=?1 ", nativeQuery = true)
    NewsDetail findByNewsMark(String newsMark);


    @Query(value="select * from APP_SOURCE_DATA_NEWS_CN where id>?1 limit ?2",nativeQuery=true)
    List<NewsDetail> from(int start, int pageSize);

    @Query(value="select * from APP_SOURCE_DATA_NEWS_CN where keyword='' ",nativeQuery=true)
    List<NewsDetail> findEmptyKeywordNews();

    @Query(value = "select count(*) from APP_SOURCE_DATA_NEWS_CN where APP_SOURCE_DATA_NEWS_CN.add_time like ?1 and APP_SOURCE_DATA_NEWS_CN.source_id in (select APP_NEWS_SOURCE_CN.id from APP_NEWS_SOURCE_CN where name=?2) ",nativeQuery=true)
    int countByDateAndSource(String date, String name);



}

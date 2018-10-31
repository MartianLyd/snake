package com.kryocore.snake.crt.repository;

import com.kryocore.snake.crt.entity.CorpusBean;
import com.kryocore.snake.crt.entity.NewsDetail;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface CorpusRepository extends CrudRepository<CorpusBean, Long> {

    @Query(value = "select * from EN_ZN where news_mark=?1 ", nativeQuery = true)
    CorpusBean findByNewsMark(String newsMark);



}

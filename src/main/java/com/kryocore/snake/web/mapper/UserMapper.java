package com.kryocore.snake.web.mapper;

import com.kryocore.snake.web.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper extends CrudRepository<Person,Long> {

    @Query(value="select * from Person where id=?1 ",nativeQuery=true)
    Person findByPersonId(Long id);
}

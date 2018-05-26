package io.jetbrains.springbooster.user;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public interface UserRepository extends CrudRepository<User,Integer>{

    @Query(value = "select * from User u",nativeQuery = true)
    List<User> getAll();

    @Query(value = "select * from User u where user_id = user_id",nativeQuery = true)
    User getUser(int user_id);

}


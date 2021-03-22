package com.proiectPS.demo.repository;

import com.proiectPS.demo.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    User findFirstById(Long id);

    List<User> findAllByNickname(String nickname);

    List<User> findByNickname(String nickname);

    User findFirstByNickname(String nickanme);

    User findFirstByEmail(String email);



}

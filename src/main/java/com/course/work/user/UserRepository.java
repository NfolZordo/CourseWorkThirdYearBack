package com.course.work.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findByEmail(String email);

  @Query(value =
          "select * from all_user_info " +
                  "where email like :email", nativeQuery = true)
  Object[] getUserInfo(
          @Param("email") String email
  );
}

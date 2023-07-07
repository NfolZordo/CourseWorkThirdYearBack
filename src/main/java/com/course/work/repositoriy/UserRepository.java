package com.course.work.repositoriy;

import com.course.work.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findByEmail(String email);
  Optional<User> findById(Integer Id);

  @Query(value =
          "select * from all_user_info " +
                  "where email like :email", nativeQuery = true)
  Object[] getUserInfo(
          @Param("email") String email
  );

  @Query(value =
          "CALL add_client(:first_name,:last_name,:phone_number,:email,:password,1)", nativeQuery = true)
  Integer addClient(
          @Param("first_name") String first_name,
          @Param("last_name") String last_name,
          @Param("phone_number") int phone_number,
          @Param("email") String email,
          @Param("password") String password
  );
}

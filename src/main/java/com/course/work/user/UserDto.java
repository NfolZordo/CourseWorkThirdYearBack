package com.course.work.user;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Integer id;
    @Column(name = "first_name")
    private String firstname;
    @Column(name = "last_name")

    private String lastname;
    private String email;
    private Role role;
    @Column(name = "phone_number")

    private Integer phoneNumber;

    // Конструктори, геттери та сеттери
    public UserDto(String error) {
        this.firstname = error;
        this.lastname = error;
        this.email = error;
        this.role = null;
    }

}
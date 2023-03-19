package com.course.work.user;

public class UserDto {
    private String firstname;
    private String lastname;
    private String email;
    private Role role;

    // Конструктори, геттери та сеттери
    public UserDto() {}

    public UserDto(String firstname, String lastname, String email, Role role) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.role = role;
    }
    public UserDto(String error) {
        this.firstname = error;
        this.lastname = error;
        this.email = error;
        this.role = null;
    }
    public UserDto(User user) {
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.email = user.getEmail();
        this.role = user.getRole();

    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
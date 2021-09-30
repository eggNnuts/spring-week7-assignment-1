package com.codesoom.assignment.user.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Getter
@Entity
@Builder
public class User {
    @Id
    @GeneratedValue
    Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @Builder.Default
    private boolean deleted = false;

    public User() {
    }

    public User(Long id, String name, String email, String password, boolean deleted) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.deleted = deleted;
    }

    public void change(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }

    public boolean authenticate(String password) {
        return !deleted && password.equals(this.password);
    }
}

package ru.itis.project.models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode(exclude = "hashPassword")
@Builder
public class User {
    private Long id;
    private String login;
    private String firstName;
    private String lastName;
    private String email;
    private String git;

    private String hashPassword;

    private List<Product> orders;
}

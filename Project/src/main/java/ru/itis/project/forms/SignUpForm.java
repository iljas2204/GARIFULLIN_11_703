package ru.itis.project.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpForm {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String git;
}

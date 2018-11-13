package ru.itis.project.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SettingsUserForm {
    private Long id;
    private String login;
    private String firstName;
    private String lastName;
    private String email;
    private String git;
}

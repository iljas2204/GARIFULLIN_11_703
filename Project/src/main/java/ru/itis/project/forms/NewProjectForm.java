package ru.itis.project.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NewProjectForm {
    private String smallInfo;
    private String fullInfo;
    private String name;
    private Long userId;
}

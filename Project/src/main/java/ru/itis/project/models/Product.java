package ru.itis.project.models;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class Product {
    private Long id;
    private Long userId;
    private String info;
}

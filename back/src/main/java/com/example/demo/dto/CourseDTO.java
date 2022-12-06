package com.example.demo.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CourseDTO {
    private String type;
    private String name;
    private String picture;
    private String url;
    private String desc;
    private String address;
}

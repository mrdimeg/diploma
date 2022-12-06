package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Course extends GeneralEntity {
    @ManyToOne
    private CourseType courseType;
    @EqualsAndHashCode.Include
    private String name;
    private String picture;
    private String url;
    private String description;
    @ManyToOne
//    @JoinTable(name="courses_addresses",
//            joinColumns= @JoinColumn(name="course_id"),
//            inverseJoinColumns= @JoinColumn(name="address_id"))
    @EqualsAndHashCode.Include
    private Address address;
}

package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class CourseType extends GeneralEntity {
    @EqualsAndHashCode.Include
    private String name;
    @OneToMany(mappedBy = "courseType")
    private Set<Course> course;
}

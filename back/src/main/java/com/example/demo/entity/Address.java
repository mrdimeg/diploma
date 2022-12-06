package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@EqualsAndHashCode(exclude = { "courses" }, callSuper = false)
public class Address extends GeneralEntity {
    private String country;
    private String city;
    private String street;
    private String house;
    @OneToMany(mappedBy = "address")
    private Set<Course> courses;
}

package com.example.demo.mapper;

import com.example.demo.dto.CourseDTO;
import com.example.demo.entity.Course;
import org.mapstruct.Mapper;

@Mapper
public interface CourseMapper {

    default CourseDTO fromCourse(Course course) {
        if (course == null) {
            return null;
        } else {
            return CourseDTO.builder()
                    .type(course.getCourseType().getName())
                    .name(course.getName())
                    .picture(course.getPicture())
                    .url(course.getUrl())
                    .desc(course.getDescription())
                    .address(String.format("%s, %s", course.getAddress().getStreet(), course.getAddress().getHouse()))
                    .build();
        }
    }
}

package com.example.demo.mapper;

import com.example.demo.dto.AnswerDTO;
import com.example.demo.entity.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AnswerMapper {

    @Mapping(target = "text", source = "answerBody")
    @Mapping(target = "correct", source = "correctAnswer")
    AnswerDTO answerToAnswerDTO(Answer answer);
}

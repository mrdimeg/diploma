package com.example.demo.mapper;

import com.example.demo.dto.QuestionDTO;
import com.example.demo.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(uses = AnswerMapper.class)
public interface QuestionMapper {

    @Mapping(target = "question", source = "questionBody")
    QuestionDTO questionToQuestionDTO(Question question);

    Set<QuestionDTO> questionsToQuestionDTOs(List<Question> question);
}

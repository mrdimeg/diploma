package com.example.demo.mapper;

import com.example.demo.dto.AnswerDTO;
import com.example.demo.dto.QuestionDTO;
import com.example.demo.entity.Answer;
import com.example.demo.entity.Question;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-03T15:54:45+0300",
    comments = "version: 1.5.2.Final, compiler: Eclipse JDT (IDE) 1.4.200.v20220719-0747, environment: Java 17.0.4 (Eclipse Adoptium)"
)
@Component
public class QuestionMapperImpl implements QuestionMapper {

    @Autowired
    private AnswerMapper answerMapper;

    @Override
    public QuestionDTO questionToQuestionDTO(Question question) {
        if ( question == null ) {
            return null;
        }

        QuestionDTO.QuestionDTOBuilder questionDTO = QuestionDTO.builder();

        questionDTO.question( question.getQuestionBody() );
        questionDTO.answers( answerSetToAnswerDTOList( question.getAnswers() ) );
        questionDTO.id( question.getId() );

        return questionDTO.build();
    }

    @Override
    public Set<QuestionDTO> questionsToQuestionDTOs(List<Question> question) {
        if ( question == null ) {
            return null;
        }

        Set<QuestionDTO> set = new LinkedHashSet<QuestionDTO>( Math.max( (int) ( question.size() / .75f ) + 1, 16 ) );
        for ( Question question1 : question ) {
            set.add( questionToQuestionDTO( question1 ) );
        }

        return set;
    }

    protected List<AnswerDTO> answerSetToAnswerDTOList(Set<Answer> set) {
        if ( set == null ) {
            return null;
        }

        List<AnswerDTO> list = new ArrayList<AnswerDTO>( set.size() );
        for ( Answer answer : set ) {
            list.add( answerMapper.answerToAnswerDTO( answer ) );
        }

        return list;
    }
}

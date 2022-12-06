package com.example.demo.mapper;

import com.example.demo.dto.AnswerDTO;
import com.example.demo.entity.Answer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-06T11:04:23+0300",
    comments = "version: 1.5.2.Final, compiler: Eclipse JDT (IDE) 1.4.200.v20221012-0724, environment: Java 17.0.5 (Eclipse Adoptium)"
)
@Component
public class AnswerMapperImpl implements AnswerMapper {

    @Override
    public AnswerDTO answerToAnswerDTO(Answer answer) {
        if ( answer == null ) {
            return null;
        }

        AnswerDTO.AnswerDTOBuilder answerDTO = AnswerDTO.builder();

        answerDTO.text( answer.getAnswerBody() );
        answerDTO.correct( answer.getCorrectAnswer() );

        return answerDTO.build();
    }
}

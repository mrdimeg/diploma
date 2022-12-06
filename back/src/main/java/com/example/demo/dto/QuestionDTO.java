package com.example.demo.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class QuestionDTO {
    private long id;
    private String question;
    private List<AnswerDTO> answers;
}

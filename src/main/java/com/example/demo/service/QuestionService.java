package com.example.demo.service;

import com.example.demo.dto.QuestionDTO;
import com.example.demo.mapper.QuestionMapper;
import com.example.demo.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;

    public QuestionService(QuestionRepository questionRepository, QuestionMapper questionMapper) {
        this.questionRepository = questionRepository;
        this.questionMapper = questionMapper;
    }

    public Set<QuestionDTO> findAll() {
        return questionMapper.questionsToQuestionDTOs(questionRepository.findAll());
    }
}

package com.example.demo.controller;

import com.example.demo.dto.QuestionDTO;
import com.example.demo.service.QuestionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/questions")
@CrossOrigin
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    @ApiOperation(value = "Method allows a user to get all test questions")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "")
    })
    public ResponseEntity<Set<QuestionDTO>> getAllQuestions() {
        return ResponseEntity.ok(questionService.findAll());
    }
}

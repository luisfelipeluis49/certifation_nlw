package com.luisfelipeluis49.certifation_nlw.modules.questions.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luisfelipeluis49.certifation_nlw.modules.questions.dto.AlternativeResultDTO;
import com.luisfelipeluis49.certifation_nlw.modules.questions.dto.QuestionResultDTO;
import com.luisfelipeluis49.certifation_nlw.modules.questions.entities.AlternativesEntity;
import com.luisfelipeluis49.certifation_nlw.modules.questions.entities.QuestionEntity;
import com.luisfelipeluis49.certifation_nlw.modules.questions.repositories.QuestionRepository;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;
    
    @GetMapping("/technology/{technology}")
    public List<QuestionResultDTO> findByTechnology(@PathVariable String technology) {
        var result = this.questionRepository.findByTechnology(technology);

        var toMap = result.stream().map(question -> mapQuestionToDTO(question))
        .collect(Collectors.toList());
        return toMap;
    }



    static QuestionResultDTO mapQuestionToDTO(QuestionEntity questions) {
        var questionResultDTO = QuestionResultDTO.builder()
        .id(questions.getId())
        .technology(questions.getTechnology())
        .description(questions.getDescription()).build();

        List<AlternativeResultDTO> alternativeResultDTOs = 
        questions.getAlternatives()
        .stream().map(alternative -> mapAlternativeDTO(alternative))
        .collect(Collectors.toList());

        questionResultDTO.setAlternatives(alternativeResultDTOs);
        return questionResultDTO;
    }    

    static AlternativeResultDTO mapAlternativeDTO(AlternativesEntity alternativesResultDTO) {
        return AlternativeResultDTO.builder()
                .id(alternativesResultDTO.getId())
                .description(alternativesResultDTO.getDescription()).build();
        
    }
}

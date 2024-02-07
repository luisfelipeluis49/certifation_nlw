package com.luisfelipeluis49.certifation_nlw.modules.questions.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luisfelipeluis49.certifation_nlw.modules.questions.entities.AlternativesEntity;

public interface AlternativeRepository extends JpaRepository<AlternativesEntity, UUID> {
    
}

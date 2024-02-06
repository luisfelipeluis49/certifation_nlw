package com.luisfelipeluis49.certifation_nlw.modules.students.useCases;

import org.springframework.stereotype.Service;

import com.luisfelipeluis49.certifation_nlw.modules.students.dto.VerifyHasCertificationDTO;

@Service
public class VerifyIfHasCertificationUseCase {
    

    public boolean execute( VerifyHasCertificationDTO dto ) {
        if(dto.getEmail().equals("luis.mail@sionmid.com") && dto.getTechnology().equals("Java")) {
            return true;
        }
        else return false;
    }
}

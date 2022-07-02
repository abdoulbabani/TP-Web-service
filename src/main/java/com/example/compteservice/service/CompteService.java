package com.example.compteservice.service;

import org.springframework.stereotype.Service;


public interface CompteService {
    void virement (Long codeSourece ,Long codeDestination, double montant);
}

package com.example.compteservice.service;


import com.example.compteservice.entities.Compte;
import com.example.compteservice.repositories.CompteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CompteServiceImpl  implements  CompteService{
    private final CompteRepository compteRepository;

    @Override
    public void virement(Long codeSourece, Long codeDestination, double montant) {
        Compte c1=compteRepository.getById(codeSourece);
        Compte c2=compteRepository.getById(codeDestination);
        c1.setSolde(c1.getSolde()-montant);
        c2.setSolde(c2.getSolde()+montant);
        compteRepository.save(c1);
        compteRepository.save(c2);

    }
}

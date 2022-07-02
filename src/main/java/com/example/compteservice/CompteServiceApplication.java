package com.example.compteservice;

import com.example.compteservice.entities.Compte;
import com.example.compteservice.enums.TypeCompte;
import com.example.compteservice.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class CompteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompteServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner start (CompteRepository compteRepository){
        return args -> {
            compteRepository.save(Compte.builder().code(null).solde(9800).dateCreation(new Date()).type(TypeCompte.COURANT).build());
            compteRepository.save(Compte.builder().code(null).solde(1200).dateCreation(new Date()).type(TypeCompte.COURANT).build());
            compteRepository.save(Compte.builder().code(null).solde(23526).dateCreation(new Date()).type(TypeCompte.COURANT).build());
            compteRepository.save(Compte.builder().code(null).solde(23400).dateCreation(new Date()).type(TypeCompte.COURANT).build());

            compteRepository.findAll().forEach(cp->{
                System.out.println(cp.getCode());
                System.out.println(cp.getType());
                System.out.println(cp.getSolde());

            });
        };
    }

}

package com.example.compteservice.web;

import com.example.compteservice.entities.Compte;
import com.example.compteservice.repositories.CompteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CompteRestController {
    private final CompteRepository compteRepository;


    @GetMapping("/Comptes")
    public List<Compte> compteList(){
        return compteRepository.findAll();
    }

    @GetMapping("/Comptes/{id}")
    public Compte getCompte (@PathVariable (name = "id") Long code){
        return compteRepository.findById(code).get();
    }

    @PostMapping("/Comptes")
    public Compte AddCompte(@RequestBody Compte compte){
        return compteRepository.save(compte);
    }

    @PutMapping("/Comptes/{id}")
    public  Compte updateCompte(@PathVariable Long id ,@RequestBody Compte compte){
        compte.setCode(id);
        return compteRepository.save(compte);
    }


    @DeleteMapping ("/Comptes/{code}")
    public  void updateCompte(@PathVariable Long code){
        compteRepository.deleteById(code);
    }




}

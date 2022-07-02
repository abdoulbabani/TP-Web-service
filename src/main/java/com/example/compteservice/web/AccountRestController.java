package com.example.compteservice.web;

import com.example.compteservice.dto.VirementrequestDTO;
import com.example.compteservice.service.CompteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountRestController {
     private  final CompteService compteService;


     @PutMapping("/comptes/virement")
     public  void virement(VirementrequestDTO virementrequestDTO){
          compteService.virement(virementrequestDTO.getCodeSource(), virementrequestDTO.getCodedestination(), virementrequestDTO.getMontant());

     }
}

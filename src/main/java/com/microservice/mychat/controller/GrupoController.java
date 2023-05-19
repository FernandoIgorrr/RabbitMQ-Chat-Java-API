package com.microservice.mychat.controller;

import com.microservice.mychat.dto.GrupoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="grupos")
public class GrupoController {
    private ResponseEntity alteraGrupos(@RequestBody GrupoDTO grupoDTO){
        return new ResponseEntity(HttpStatus.OK);
    }
}

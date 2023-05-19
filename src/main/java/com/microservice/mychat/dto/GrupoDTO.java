package com.microservice.mychat.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class GrupoDTO implements Serializable {
    private String nome;
    private Set<String> clients;

    public GrupoDTO(String nome, HashSet<String> clients){
        this.nome       = nome;
        this.clients    = new HashSet<String>(clients);
    }
}

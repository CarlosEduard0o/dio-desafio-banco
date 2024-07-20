package com.example.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cliente {
    private Agencia agencia;
    private String nome;
    private int idade;
    private String sexo;
}

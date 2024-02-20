package br.com.teste.infosys.domain;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Pessoa {
    private String nome;
    private LocalDate dataNasc;
    private String cpf;
    private List<Apolice> apolices;
}

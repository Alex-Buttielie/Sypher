package com.example.algamoney.api.service;

import com.example.algamoney.api.model.Pessoa;

import java.util.Optional;

public interface PessoaService {

    Optional<Pessoa> getPessoaById(Long codigo);
}

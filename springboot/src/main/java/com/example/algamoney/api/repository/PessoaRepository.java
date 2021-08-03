package com.example.algamoney.api.repository;

import com.example.algamoney.api.model.Categoria;
import com.example.algamoney.api.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository <Pessoa, Long> {

}

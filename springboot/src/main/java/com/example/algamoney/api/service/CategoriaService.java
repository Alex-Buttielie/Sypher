package com.example.algamoney.api.service;

import com.example.algamoney.api.model.Categoria;

import java.util.Optional;

public interface CategoriaService {

    Optional<Categoria> getCategoriaById(Long codigo);
}

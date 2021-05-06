package com.example.algamoney.api.resources;

import com.example.algamoney.api.model.Categoria;
import com.example.algamoney.api.repository.CategoriaRepository;
import com.example.algamoney.api.service.CategoriaService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

    private final CategoriaService categoriaService = null;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping()
    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }

    @PostMapping
    public  ResponseEntity<Categoria> criar (@RequestBody Categoria categoria, HttpServletResponse response){
        Categoria categoriaSalva = categoriaRepository.save(categoria);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
                .buildAndExpand(categoriaSalva.getCodigo()).toUri();
        response.setHeader("Location", uri.toASCIIString());

        return ResponseEntity.created(uri).body(categoriaSalva);

    }

    @GetMapping("/{codigo}")
    public ResponseEntity<?> buscarPeloCodigo(@PathVariable("codigo") Long codigo){
        Categoria categoria = null;
        Integer teste = 0;
        try {
            categoria = categoriaRepository.getOne(codigo);
            categoria.getCodigo();
        }
        catch (EntityNotFoundException e){
            teste = null;
        }

        return teste == null ?  ResponseEntity.notFound().build() :ResponseEntity.ok(Categoria.converter(categoria));
    }


}

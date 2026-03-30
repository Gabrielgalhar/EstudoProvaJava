package com.galhardone.galhardone.controllers;


import com.galhardone.galhardone.entities.Categoria;
import com.galhardone.galhardone.entities.Produto;
import com.galhardone.galhardone.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService productService;

    @PostMapping
    public Categoria create(@RequestBody Categoria categoria) {
        return CategoriaService.create(new Produto());
    }

    @GetMapping
    public List<Categoria> getAll() {
        return CategoriaService.getAll();
    }

    @GetMapping("/{id}")
    public Categoria getById(@PathVariable Long id) {
        return CategoriaService.getById(id);
    }

    @PutMapping("/{id}")
    public Categoria update(@PathVariable Long id, @RequestBody Categoria categoria) {
        return CategoriaService.update(id,categoria);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

}

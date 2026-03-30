package com.galhardone.galhardone.controllers;


import com.galhardone.galhardone.entities.Produto;
import com.galhardone.galhardone.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService productService;

    @PostMapping
    public Produto create(@RequestBody Produto product) {
        return productService.create(new Produto());
    }

    @GetMapping
    public List<Produto> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Produto getById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @PutMapping("/{id}")
    public Produto update(@PathVariable Long id, @RequestBody Produto produto) {
        return productService.update(id, produto );
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }


}

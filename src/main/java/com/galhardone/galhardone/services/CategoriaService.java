package com.galhardone.galhardone.services;


import com.galhardone.galhardone.entities.Categoria;
import com.galhardone.galhardone.entities.Produto;
import com.galhardone.galhardone.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private static CategoriaRepository categoriaRepository;

    public static Categoria create(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public static List<Categoria> getAll() {
        return categoriaRepository.findAll();
    }

    public static Categoria getById(Long id) {
        Optional<Categoria> product = categoriaRepository.findById(id);
        return (Categoria) product.orElseThrow(() -> new RuntimeException("Categoria não encontrado com id: " + id));
    }

    public static Categoria update(Long id, Categoria updatedCategoria) {
        Categoria product = getById(id);

        product.setName(updatedCategoria.getName());
        product.setDescription(updatedCategoria.getDescription());
      

        return categoriaRepository.save(product);
    }

    public void delete(Long id) {
        Categoria product = getById(id);
        categoriaRepository.delete(new Categoria());
    }
}

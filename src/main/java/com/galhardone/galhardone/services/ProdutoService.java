package com.galhardone.galhardone.services;

import com.galhardone.galhardone.entities.Produto;
import com.galhardone.galhardone.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository productRepository;

    public Produto create(Produto product) {
        return productRepository.save(product);
    }

    public List<Produto> getAll() {
        return productRepository.findAll();
    }

    public Produto getById(Long id) {
        Optional<Produto> product = productRepository.findById(id);
        return product.orElseThrow(() -> new RuntimeException("Produto não encontrado com id: " + id));
    }

    public Produto update(Long id, Produto updatedProduct) {
        Produto product = getById(id);

        product.setName(updatedProduct.getName());
        product.setDescription(updatedProduct.getDescription());
        product.setPrice(updatedProduct.getPrice());
        product.setStock(updatedProduct.getStock());

        return productRepository.save(product);
    }

    public void delete(Long id) {
        Produto product = getById(id);
        productRepository.delete(product);
    }
}
package com.galhardone.galhardone.repositories;
import com.galhardone.galhardone.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
package io.GitHub.LumaGonzaga.ProdutosAPI.repository;

import io.GitHub.LumaGonzaga.ProdutosAPI.model.Produto;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, String> {

    List<Produto> findByNome(String nome);

}

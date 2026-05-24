package io.GitHub.LumaGonzaga.ProdutosAPI.repository;

import io.GitHub.LumaGonzaga.ProdutosAPI.model.Produto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, String> {


}

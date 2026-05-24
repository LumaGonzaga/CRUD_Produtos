package io.GitHub.LumaGonzaga.ProdutosAPI.controller;

import io.GitHub.LumaGonzaga.ProdutosAPI.model.Produto;
import io.GitHub.LumaGonzaga.ProdutosAPI.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController// Mostra que a classe é um controlador Rest
@RequestMapping("produtos")// Diz qual é a URL base desse controller
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {

        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto){//Vai pegar as informações que foram enviadas por requisição em formato Json pelo Postman e jogar os valores nas variáveis respectivas.
        System.out.println("produto Recebido: " + produto);
        var id = UUID.randomUUID().toString();/*Classe do java - Universe Unic Id com metodo radom para gerar um ID random*/
        produto.setId(id);//Coloca o ID random no id
        produtoRepository.save(produto);//Recebe uma entidade
        return produto;/* faz aparecer o retorno no PostMan

        EX:

        {
        "descricao": "Computador Móvel",
        "id": null,
        "nome": "Notebook",
        "preco": 5000.0
        }
        */

    }
}

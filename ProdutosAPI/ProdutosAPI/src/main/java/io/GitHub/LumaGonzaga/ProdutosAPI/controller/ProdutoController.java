package io.GitHub.LumaGonzaga.ProdutosAPI.controller;

import io.GitHub.LumaGonzaga.ProdutosAPI.model.Produto;
import io.GitHub.LumaGonzaga.ProdutosAPI.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
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
    @GetMapping("/{id}")
    public Produto salvar(@PathVariable("id") String id){

        ///Optional<Produto> produto = produtoRepository.findById(id);//procura no repository(Banco de dados) o ID, o Optional é porque pode ser que venha vazio
        //return produto.isPresent() ? produto.get() : null; //Verifica se o produto está presente, se não estiver, retorna null
        // Ou
        return produtoRepository.findById(id).orElse(null); //juntou os dois acima nesse
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable("id") String id){

        produtoRepository.deleteById(id);

    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable("id") String id,
                          @RequestBody Produto produto ) {
        produto.setId(id);
        produtoRepository.save(produto);
    }
    @GetMapping
    public List<Produto> buscar(@RequestParam("nome") String nome) {


        return produtoRepository.findByNome(nome);

    }




}
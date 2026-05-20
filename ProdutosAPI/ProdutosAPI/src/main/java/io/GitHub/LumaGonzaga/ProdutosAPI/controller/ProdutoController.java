package io.GitHub.LumaGonzaga.ProdutosAPI.controller;

import io.GitHub.LumaGonzaga.ProdutosAPI.model.Produto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController// Mostra que a classe é um controlador Rest
@RequestMapping("produtos")// Diz qual é a URL base desse controller
public class ProdutoController {

    @PostMapping
    public Produto salvar(@RequestBody Produto produto){//Vai pegar as informações que foram enviadas por requisição em formato Json pelo Postman e jogar os valores nas variáveis respectivas.
        System.out.println("produto Recebido: " + produto);
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

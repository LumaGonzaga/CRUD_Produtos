package io.GitHub.LumaGonzaga.ProdutosAPI.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity; // demonstrar que a classe produto é uma entidade JPA//  Antigo import javax.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// POJO -> Plain Old Java Object
@Entity//mapeia uma classe para uma tabela de banco de dados.
@Table// Mesma coisa que para coluna, mas agora para o nome da tabela, nesse caso, o nome da tabela é o mesmo da classe, então não era necessário.
public class Produto {

    @Id// Usado para mostrar que o id é a chave primária da tabela. Que é uma coluna ou conjunto de colunas que identifica de forma única cada linha (ou registro) em uma tabela de banco de dados. Ela impede que duas linhas tenham os mesmos dados nesse campo e não permite valores em branco (nulos)
    @Column// Serve para mapear as colunas no banco de dados. É usado passando o nome da variável que repesenta essa variável no banco de dados.
    // EX: @Column(name = "código"), além disso podemos colocar "," depois de código e crtl + p, conseguimos ver outras propriedades que podemos aplicar ao valor dessa coluna . Não é obrigatório colocar o @Column para as variáveis que tem o mesmo nome no banco de dados, então nesse caso não precisaria
    private String id;

    @Column
    private String nome;

    @Column
    private String descricao;

    @Column
    private Double preco;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                '}';
    }
}

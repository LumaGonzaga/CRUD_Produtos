# ProdutosAPI

API simples de CRUD para produtos construída com Spring Boot.

Principais arquivos:
- Controller: [`io.GitHub.LumaGonzaga.ProdutosAPI.controller.ProdutoController`](ProdutosAPI/ProdutosAPI/src/main/java/io/GitHub/LumaGonzaga/ProdutosAPI/controller/ProdutoController.java)  
- Entidade: [`io.GitHub.LumaGonzaga.ProdutosAPI.model.Produto`](ProdutosAPI/ProdutosAPI/src/main/java/io/GitHub/LumaGonzaga/ProdutosAPI/model/Produto.java)  
- Repositório: [`io.GitHub.LumaGonzaga.ProdutosAPI.repository.ProdutoRepository`](ProdutosAPI/ProdutosAPI/src/main/java/io/GitHub/LumaGonzaga/ProdutosAPI/repository/ProdutoRepository.java)  
- Classe principal: [`io.GitHub.LumaGonzaga.ProdutosAPI.ProdutosApiApplication`](ProdutosAPI/ProdutosAPI/src/main/java/io/GitHub/LumaGonzaga/ProdutosAPI/ProdutosApiApplication.java)  
- Config: [src/main/resources/application.yml](ProdutosAPI/ProdutosAPI/src/main/resources/application.yml)  
- Script de criação da tabela: [src/main/resources/data.sql](ProdutosAPI/ProdutosAPI/src/main/resources/data.sql)  
- Build: [pom.xml](ProdutosAPI/ProdutosAPI/pom.xml)

Postman — requisições para cada método
- Observação: use header "Content-Type: application/json" para POST e PUT.

1) Salvar (POST)
- URL: POST http://localhost:8080/produtos
- Body (raw JSON):
{
    "id" : "01",
    "nome" : "Pendrive",
    "descricao" : "Pen drive Sandisk 64GB",
    "preco" : 40
}

2) Obter por ID (GET)
- URL: GET http://localhost:8080/produtos/:id
- Exemplo: GET http://localhost:8080/produtos/01

3) Deletar (DELETE)
- URL: DELETE http://localhost:8080/produtos/:id
- Exemplo: DELETE http://localhost:8080/produtos/01

4) Atualizar (PUT)
- URL: PUT http://localhost:8080/produtos/:id
- Body (raw JSON):
{
    "descricao": "PC branco 500GB 5 coolers placa de vídeo RTX500",
    "nome": "PC",
    "preco": 5000
}
- Observação: o ID é passado na URL; o body substitui os campos (o controller faz produto.setId(id) antes de salvar).

5) Buscar por nome (GET)
- URL: GET http://localhost:8080/produtos?nome=VALOR
- Exemplo: GET http://localhost:8080/produtos?nome=Pendrive
- Implementação: usa [`ProdutoRepository.findByNome`](ProdutosAPI/ProdutosAPI/src/main/java/io/GitHub/LumaGonzaga/ProdutosAPI/repository/ProdutoRepository.java)

Testes e execução
- Rodar em desenvolvimento:
  - Linux / macOS: ./mvnw spring-boot:run
  - Windows: mvnw.cmd spring-boot:run

  Formato do recurso Produto
- Campos disponíveis (classe: [`io.GitHub.LumaGonzaga.ProdutosAPI.model.Produto`](ProdutosAPI/ProdutosAPI/src/main/java/io/GitHub/LumaGonzaga/ProdutosAPI/model/Produto.java)):
  - id: String
  - nome: String
  - descricao: String
  - preco: Double

Testes
- Executar testes unitários/integrados:
  ./mvnw test  
  (exemplo de teste de contexto: [`ProdutosApiApplicationTests`](ProdutosAPI/ProdutosAPI/src/test/java/io/GitHub/LumaGonzaga/ProdutosAPI/ProdutosApiApplicationTests.java))

Observações e dicas
- A aplicação usa Spring Data JPA com H2 para facilitar desenvolvimento local.  
- Alterar configurações de datasource em [src/main/resources/application.yml](ProdutosAPI/ProdutosAPI/src/main/resources/application.yml).  
- Para inspecionar base H2, habilite/acesse o console em /h2-console conforme [application.yml](ProdutosAPI/ProdutosAPI/src/main/resources/application.yml).

Contribuição
- Abrir issues e pull requests. Mantenha o estilo e minimalidade do projeto.

Licença
- Adicionar arquivo LICENSE conforme necessário.

OverDrive - Backend

Este é o backend do projeto OverDrive, um sistema para gerenciamento de oficinas mecânicas, feito com Spring Boot.

 Tecnologias

- Java 17
- Spring Boot 3
- Spring Data JPA (Hibernate)
- Banco de dados H2 (em memória)

 Como rodar o projeto

1. Clone o repositório:
   
   git clone https://github.com/seu-usuario/seu-repo-backend.git
   

2. Acesse a pasta do projeto:
   
   cd seu-repo-backend
   

3. Execute o projeto:
  
  Rodar No AutogynApplication 
  Apertar Play
  
  

4. A API estará disponível em:
   
   http://localhost:8080
  

 Estrutura

src/
├── main/java/...     → Código-fonte
├── resources/        → application.properties
pom.xml               → Dependências e build com Maven


 Testes de API

Você pode testar os endpoints usando:

- Postman
- Swagger 

 Contribuição

1. Crie uma branch:
   
   git checkout -b feature/nome-da-feature
   
2. Commit e push:
   
   git add .
   git commit -m "Descrição da feature"
   git push origin feature/nome-da-feature
   
3. Crie um Pull Request para a branch `main`.
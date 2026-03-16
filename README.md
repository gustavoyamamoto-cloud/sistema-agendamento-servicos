# Sistema de Agendamento de Serviços

API REST desenvolvida com **Spring Boot** para gerenciamento de agendamentos entre clientes e profissionais.

O sistema permite cadastrar clientes e profissionais, criar agendamentos, cancelar serviços e garantir que um profissional não tenha dois atendimentos no mesmo horário.

---

## Tecnologias utilizadas

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- Jakarta Validation
- Maven
- Banco de dados relacional (H2/MySQL)

---

## Arquitetura do projeto

O projeto foi estruturado seguindo o padrão de **arquitetura em camadas**:

controller → recebe as requisições da API  
service → contém as regras de negócio  
repository → acesso ao banco de dados  
entity → entidades do sistema  
dto → objetos de transferência de dados  
exceptions → tratamento global de erros  

---

## Entidades do sistema

### Cliente
- id
- nome
- telefone
- email

### Profissional
- id
- nome
- especialidade

### Agendamento
- id
- data
- hora
- status
- cliente
- profissional

Status possíveis do agendamento:

- AGENDADO
- CANCELADO
- CONCLUIDA

---

## Funcionalidades

### Clientes
- Cadastrar cliente
- Listar clientes

### Profissionais
- Cadastrar profissional
- Listar profissionais

### Agendamentos
- Criar agendamento
- Listar agendamentos
- Cancelar agendamento
- Deletar agendamento
- Validação para evitar conflito de horários do profissional

---

## Endpoints da API

### Clientes

POST /clientes  
Cadastrar cliente

GET /clientes  
Listar clientes

---

### Profissionais

POST /profissionais  
Cadastrar profissional

GET /profissionais  
Listar profissionais

---

### Agendamentos

POST /agendamentos  
Criar agendamento

GET /agendamentos  
Listar agendamentos

PUT /agendamentos/{id}  
Cancelar agendamento

DELETE /agendamentos/{id}  
Deletar agendamento

---

## Exemplo de requisição

Criar cliente:

```json
POST /clientes

{
  "nome": "João Silva",
  "telefone": "99999-9999",
  "email": "joao@email.com"
}

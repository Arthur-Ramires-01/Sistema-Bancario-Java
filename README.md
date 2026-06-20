# Sistema Bancário em Java

Sistema de gerenciamento bancário com funcionalidades básicas de conta corrente e poupança,
autenticação por senha e persistência de dados em SQLite.

> ⚠️ Projeto finalizado, porém pode sofrer alterações futuras.

---

## 🛠️ Tecnologias Utilizadas

- **Java** — Linguagem principal do projeto
- **SQLite** — Banco de dados para persistência dos dados
- **JDBC** — Conexão entre Java e o banco de dados
- **sqlite-jdbc 3.53.2.0** — Driver SQLite para Java

---

## ✅ Funcionalidades

### Clientes
- Cadastro de cliente com validações (nome, CPF, email e senha)
- Busca de cliente por ID
- Atualização de dados do cliente
- Remoção de cliente

### Contas
- Abertura de conta corrente ou poupança
- Saldo inicial padrão de R$ 1.500,00

### Operações Financeiras
- Saque com autenticação por senha
- Depósito com autenticação por senha
- Transferência entre contas com autenticação por senha
- Consulta de saldo

### Segurança
- Autenticação por senha em todas as operações financeiras
- Validações de cadastro:
  - Nome não pode conter números
  - CPF aceita apenas números
  - Email precisa conter @
  - Senha precisa ter mínimo 8 caracteres, 1 letra maiúscula e 1 número

---

## ▶️ Como Rodar o Projeto

### Pré-requisitos
- JDK 21 instalado — [Download aqui](https://www.oracle.com/java/technologies/downloads/#java21)
- Driver SQLite — já incluído na pasta `lib`

### Passo a passo

**1. Clone ou baixe o projeto**

**2. Abra o cmd e navegue até a pasta do projeto:**
```cmd
cd C:\caminho\para\Downloads\Java
```

**3. Compile o projeto:**
```cmd
"C:\Program Files\Java\jdk-21.0.11\bin\javac" -cp ".;Java\lib\sqlite-jdbc-3.53.2.0.jar" -d out SistemaBancario\model\Banco.java SistemaBancario\model\BancoDB.java SistemaBancario\model\Cliente.java SistemaBancario\model\ClienteDAO.java SistemaBancario\model\ConexaoDB.java SistemaBancario\model\Conta.java SistemaBancario\model\ContaCorrente.java SistemaBancario\model\ContaDAO.java SistemaBancario\model\ContaPoupanca.java SistemaBancario\controller\ClienteController.java SistemaBancario\controller\ContaController.java SistemaBancario\view\Menu.java
```

**4. Execute o projeto:**
```cmd
"C:\Program Files\Java\jdk-21.0.11\bin\java" -cp ".;out;Java\lib\sqlite-jdbc-3.53.2.0.jar" SistemaBancario.view.Menu
```

**5. O banco de dados `banco.db` será criado automaticamente na primeira execução!**

---

## 📁 Estrutura do Projeto

```
Java/
├── Java/
│   ├── .vscode/
│   │   └── settings.json
│   └── lib/
│       └── sqlite-jdbc-3.53.2.0.jar
├── SistemaBancario/
│   ├── model/
│   │   ├── Banco.java
│   │   ├── BancoDB.java
│   │   ├── Cliente.java
│   │   ├── ClienteDAO.java
│   │   ├── ConexaoDB.java
│   │   ├── Conta.java
│   │   ├── ContaCorrente.java
│   │   ├── ContaDAO.java
│   │   └── ContaPoupanca.java
│   ├── controller/
│   │   ├── ClienteController.java
│   │   └── ContaController.java
│   └── view/
│       └── Menu.java
├── out/
└── banco.db
```

### O que é cada camada?
- **model** → Dados e regras de negócio
- **controller** → Intermediário entre model e view
- **view** → Interface com o usuário
- **out** → Arquivos compilados gerados automaticamente
- **banco.db** → Banco de dados SQLite gerado automaticamente

---

## 👨‍💻 Autor

**Arthur Ramires**

Estudante de Análise e Desenvolvimento de Sistemas — UNICSUL

[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/Arthur-Ramires-01)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://linkedin.com/in/arthur-ramires)
"# Sistema-Bancario-em-Java" 

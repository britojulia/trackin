# TrackIn 🏍️

**TrackIn** é uma aplicação para **gerenciamento e monitoramento de motos em pátios**, permitindo o controle de veículos, zonas de estacionamento e eventos associados às motos. O sistema é ideal para organizar operações de forma eficiente, com rastreabilidade e controle de manutenção.

---

## 📌Funcionalidades Principais

- **Gerenciamento de Pátios**: Cadastro de pátios com endereço, capacidade máxima e dimensões.  
- **Gestão de Zonas**: Definição de áreas dentro dos pátios (estacionamento, manutenção, lavagem) com coordenadas e cores.  
- **CGerenciamento de Motos**: Gestão completa de motos,lidando com dados incluindo placa, modelo, ano, status, RFID, data de aquisição, última manutenção e características visuais.  
- **Registro de Eventos**: Controle de eventos das motos (entrada, saída, manutenção) com timestamp e origem do registro (manual ou automático).  
- **Rastreamento Visual**: Possibilidade de associar imagens de referência e detalhes visuais das motos.  
- **Controle de Status Automático**: Na página inicial (dashboard), botões permitem **alterar automaticamente o status das motos** (como ATIVA, EM_MANUTENCAO, SAIDA) com um clique, facilitando o gerenciamento em tempo real.
- 
**Segurança**:
- Autenticação via login e logout.
- Diferenciação de perfis de usuário (administrador e usuário padrão).
- Proteção de rotas com base no perfil do usuário.
  
---

## 🛠 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Spring Security com oAuth2**
- **Thymeleaf**
- **Tailwind CSS + DaisyUI**
- **Flyway**
- **PostgreSQL (via Docker)**

---

## 🚀 Execução do Projeto (IntelliJ + Docker)

### 1. Clone o repositório
```bash
git clone https://github.com/britojulia/trackin.git
cd trackin
```

### 2. Abra o Docker Desktop

### 3. Crie a conexão com o banco de dados

No canto superior direito → clique no botão Database → clique no + → Datasource.
Selecione PostgreSQL.
Insira usuário, senha e nome do database conforme definido no compose.yaml.
Clique em Test Connection e depois em Apply.
Rode o banco de dados

### 4. Crie as variáveis de ambiente
crie e configure as variavies de ambiente >
```bash
GITHUB_ID = Ov23liYsKeiZN36Bhaw5
GITHUB_SECRET = 4efe01a01be1f6d6b49b750021c74a52694e0875
GOOGLE_ID = 616835644379-nd1mk6sivs9jtbv1j9i4sk8aoanajajc.apps.googleusercontent.com
GOOGLE_SECRET = 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
````

### 5. Rode e acesse a aplicação
 1- Abra o projeto no IntelliJ.

 2- Run → TrackInApplication.

 3- Acesse no navegador: http://localhost:8080/login

## 🎥 Pitch e Demonstração da Solução

* 🔗 Pitch: https://youtu.be/PCHSHT0CuMA
* 🎮 Vídeo da solução completa: 

##  Desenvolvido por:
Julia Brito, Leandro Correia, Victor Antonopoulos - 2TDSPG

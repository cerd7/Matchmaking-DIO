# Matchmaking System
Este repositório implementa um sistema de matchmaking que gerencia jogadores, suas estatísticas, e a criação de partidas. Ele utiliza uma estrutura modular para organizar as responsabilidades, incluindo pacotes bem definidos para controle, modelos, repositório de dados e serviços. Abaixo está a descrição detalhada do fluxo do programa.
---
## Estrutura do Projeto e funcionalidades:

O projeto está organizado nos seguintes pacotes principais:

- **`crontoller`** (Controlador): Gerencia as interações do usuário com o programa.
- **`models`** (Modelos): Representa os dados do domínio, como Jogadores e Status dos Jogadores.
- **`repository`** (Repositório): Manipula a persistência de dados em um arquivo JSON.
- **`service`** (Serviços): Implementa a lógica principal de negócios, como calcular classificação (ELO) e criar jogadores.

---

## Fluxo do Programa

### 1. **Início do Programa**
O programa começa na classe `Main.java`, que instancia o controlador `MatchController`. Este controlador é responsável por gerenciar todas as interações com o usuário.

### 2. **Menu de Interação**
Após o início, o programa exibe um menu interativo com as seguintes opções:
1. **Limpar arquivo e adicionar novos jogadores**:
   - Remove todos os jogadores do arquivo JSON.
   - Permite ao usuário adicionar novos jogadores.
2. **Criar partidas com jogadores existentes**:
   - Gera partidas entre jogadores na fila, considerando país e classificação (ELO).
3. **Exibir lista de jogadores**:
   - Mostra todos os jogadores e suas classificações.
4. **Adicionar um novo jogador**:
   - Permite criar um jogador com informações como nome, país, partidas jogadas e vitórias.

### 3. **Criação de Jogadores**
Ao criar um novo jogador, o programa:
- Coleta informações do usuário, como nome, país, status na fila, partidas jogadas e vitórias.
- Calcula automaticamente o ELO e a taxa de vitória do jogador.
- Salva o jogador no arquivo JSON através da classe `PlayerRepository`.

### 4. **Criação de Partidas**
A funcionalidade de criação de partidas:
- Lê todos os jogadores do arquivo JSON.
- Filtra os jogadores disponíveis na fila para matchmaking.
- Combina jogadores do mesmo país e com ELO semelhante em partidas.
- Atualiza o status dos jogadores no arquivo JSON.

---

## Classes e Responsabilidades

### `crontoller.MatchController`
- **Responsável por**: Gerenciar o menu e as interações do usuário.
- **Métodos principais**:
  - `startInteraction`: Exibe o menu e processa as opções do usuário.
  - `interactionCreatePlayer`: Coleta os dados do usuário para criar um novo jogador.
  - `interactionClearFile`: Limpa o arquivo de jogadores e permite adicionar novos.

### `models.Player`
- **Representa**: Um jogador no sistema.
- **Atributos principais**:
  - `nickname`: Nome do jogador.
  - `country`: País de origem.
  - `inQueue`: Indica se o jogador está na fila.
  - `playerStatus`: Estatísticas do jogador.

### `models.PlayerStatus`
- **Representa**: Estatísticas do jogador.
- **Atributos principais**:
  - `winRate`: Taxa de vitória.
  - `qtyGamePlayed`: Partidas jogadas.
  - `victory`: Vitórias.
  - `elo`: Classificação de habilidade.

### `repository.PlayerRepository`
- **Responsável por**: Manipular dados persistentes (arquivo JSON).
- **Métodos principais**:
  - `readPlayers`: Exibe todos os jogadores e suas classificações.
  - `clearFile`: Limpa o arquivo JSON.
  - `createPlayers`: Adiciona novos jogadores ao arquivo.
  - `createMatches`: Cria partidas com base nos jogadores disponíveis na fila.

### `service.MatchService`
- **Interface para lógica de negócios**:
  - `createPlayer`: Cria um jogador com base nos dados fornecidos.
  - `clearFile`: Limpa o arquivo de jogadores.
  - `calculateElo`: Calcula a classificação ELO.
  - `calculateWinRate`: Calcula a taxa de vitória.

---

## Fluxograma Simplificado

```plaintext
Main.java
   ↓
MatchController
   ↓
[ Menu Interativo ]
   ├── Limpar Arquivo
   ├── Criar Partidas
   ├── Exibir Jogadores
   └── Adicionar Jogador

## Tecnologias Utilizadas

- Java

## Como Executar o Projeto

1. Clone este repositório:

   ```bash
   git clone https://github.com/cerd7/Matchmaking-DIO.git
   ```

2. Navegue até o diretório do projeto:

   ```bash
   cd Matchmaking-DIO
   ```

3. Compile o projeto:

   ```bash
   javac src/main/java/com/dio/matchmaking/*.java
   ```

4. Execute o projeto:

   ```bash
   java -cp src/main/java com.dio.matchmaking.Main
   ```

<<<<<<< HEAD
=======
## Estrutura do Projeto

O projeto está organizado da seguinte forma:

+-------------------+
|        Main       |
+-------------------+
          |
          v
+------------------------+
|   MatchController      | <----------------------------+
+------------------------+                              |
| - service: MatchServiceImpl                           |
| +startInteraction()                                   |
| +interactionCreatePlayer()                            |
| +interactionClearFile()                               |
+------------------------+                              |
          |                                             |
          v                                             |
+------------------------+                              |
|   MatchServiceImpl      |  <---------------------+    |
+------------------------+  |  usa                 |    |
| - repository: PlayerRepository                   |    |
| +createPlayer()                                  |    |
| +clearFile()                                     |    |
| +calculateElo()                                  |    |
| +calculateWinRate()                              |    |
+------------------------+                         |    |
          |                                        |    |
          v                                        |    |
+------------------------+                         |    |
|   PlayerRepository     |   <---------------------+    |
+------------------------+
| +createPlayers()       |
| +readPlayers()         |
| +clearFile()           |
| +createMatches()       |
+------------------------+

Entidades:
+----------------+      +----------------------+
|    Player      |<>----|    PlayerStatus      |
+----------------+      +----------------------+
| - nickname     |      | - winRate            |
| - country      |      | - qtyGamePlayed      |
| - inQueue      |      | - victory            |
| - playerStatus |      | - elo                |
+----------------+      +----------------------+

>>>>>>> 3b6d8d7290a9452aefb3fdfd2285900f97f6ec32
## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests.

## Licença

Este projeto está licenciado sob a Licença MIT.

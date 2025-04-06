
# Matchmaking-DIO

Este projeto demonstra, de forma simplificada, o funcionamento de uma fila de matchmaking, onde as informações de cada jogador são consideradas para cruzar pontuações similares e formar partidas no formato 1v1. Desenvolvido como parte do curso de lógica de programação na plataforma DIO.

## Funcionalidades

- Adicionar jogadores à fila de matchmaking com ID e pontuação específicos.
- Emparelhar jogadores com pontuações similares para formar partidas 1v1.
- Exibir no console os resultados dos emparelhamentos realizados.

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

## Estrutura do Projeto

O projeto está organizado da seguinte forma:

- `src/main/java/com/dio/matchmaking/`
  - `Player.java`: Classe que representa um jogador, contendo ID e pontuação.
  - `MatchmakingQueue.java`: Classe que gerencia a fila de matchmaking, adicionando e emparelhando jogadores com base em suas pontuações.
  - `Main.java`: Classe principal que demonstra o funcionamento do sistema de matchmaking.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests.

## Licença

Este projeto está licenciado sob a Licença MIT.

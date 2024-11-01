# Java Streams

- **O que são Streams**: Introduzidos no Java 8 dentro do subpacote `java.util.stream`, os `Streams` representam uma sequência de elementos que podem ser processados de forma declarativa e funcional.
  
- **Propósito**: Os `Streams` foram projetados para facilitar operações em coleções de dados de maneira funcional, permitindo manipulações complexas, como filtragem, mapeamento e redução, de forma simples e eficiente.

- **Operações de Pipeline**: Uma das principais características dos `Streams` é a possibilidade de encadear operações, formando um *pipeline*. Esse pipeline permite executar operações em uma sequência lógica, simplificando o processamento em etapas e reduzindo a necessidade de loops explícitos.

- **Operações Intermediárias (não-terminais)**: Essas operações produzem novos `Streams` e possibilitam o encadeamento contínuo no pipeline. Exemplos incluem `filter`, `map`, `flatMap`, e `sorted`. Elas são executadas de forma *lazy*, ou seja, são processadas apenas quando uma operação terminal é invocada, otimizando o processamento.

- **Operações Terminais**: Operações terminais consomem o `Stream` e produzem um resultado final, como uma coleção, um valor único, ou um efeito colateral. Exemplos incluem `collect`, `forEach`, `reduce`, e `count`. Ao serem invocadas, elas acionam a execução do pipeline e fecham o `Stream`, tornando-o inutilizável após essa operação.

- **Lazy Evaluation**: Uma característica essencial dos `Streams` é a avaliação "preguiçosa" (*lazy*), onde as operações intermediárias não são executadas até que uma operação terminal seja chamada. Isso permite ao Java otimizar o processamento e até "pular" operações desnecessárias em certas circunstâncias.

- **Paralelismo**: O Java 8 introduziu a possibilidade de trabalhar com `Streams` de forma paralela usando `parallelStream`. Com essa opção, as operações no `Stream` podem ser executadas em paralelo, distribuindo a carga de trabalho para melhorar o desempenho em conjuntos de dados grandes.

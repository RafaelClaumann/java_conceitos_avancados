# Expressões Lambda no Java 8

Este módulo explora o conceito e a implementação de expressões lambda no Java 8, uma funcionalidade que traz flexibilidade e concisão para o desenvolvimento de código funcional. As expressões lambda são funções anônimas que não possuem nome e não estão associadas a nenhuma classe. São particularmente úteis para simplificar a implementação de interfaces funcionais, que possuem apenas um método abstrato, também conhecidas como SAM Interfaces (Single Abstract Method Interface), identificadas pela anotação `@FunctionalInterface`.

As lambdas tornam o código mais enxuto e são amplamente utilizadas para operações de extração, filtragem e mapeamento de dados em coleções. A estrutura de uma expressão lambda inclui a definição dos parâmetros à esquerda do operador (`→`) e a ação a ser executada à direita.

### Exemplo 01: Threads com Runnable
Demonstra como criar uma thread em Java, com um comparativo entre o código escrito antes e depois da introdução de expressões lambda no Java 8. Aqui, utilizamos a interface `Runnable` para ilustrar a simplificação trazida pela lambda.

### Exemplo 02: Criação de uma Interface Funcional
Explica como criar uma `@FunctionalInterface` personalizada para deixar claras as intenções do código. O exemplo faz um paralelo entre as abordagens antes e depois do Java 8, destacando a clareza proporcionada pela anotação `@FunctionalInterface`.

### Exemplo 03: Listas e o Uso de Foreach
Mostra o uso do método `foreach` associado a listas e explora a passagem de um `Consumer<T>` como parâmetro, demonstrando que isso equivale a fornecer diretamente uma expressão lambda.

### Exemplo 04: Comparação com Comparator
Apresenta o uso do `Comparator<T>` com o método `int compare(T v1, T v2)`, primeiro com uma implementação manual e, em seguida, com uma expressão lambda. Esse exemplo destaca a simplicidade das funções anônimas para implementar comparações customizadas.

## Conceitos Fundamentais

- **Interfaces Funcionais:** Interfaces com um único método abstrato, permitindo a implementação simplificada via lambdas.
- **Expressões Lambda em Coleções:** Lambdas são amplamente utilizadas em operações de listas e coleções para transformações e processamento de dados.
- **Comparação com Sintaxe Pré-Java 8:** O uso de lambdas substitui o código verboso com uma abordagem mais concisa e funcional.

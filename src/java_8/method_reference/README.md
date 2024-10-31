# Method Reference

O *Method Reference* no Java 8 é uma maneira simplificada e legível de expressar uma *lambda expression* que apenas invoca um método específico. Ele permite a substituição de uma expressão lambda por uma referência direta a um método, quando essa expressão executa unicamente a chamada de um método.

Para utilizar o *Method Reference*, o operador `::` é empregado para separar a classe ou o objeto do método referenciado.

### Tipos de Referências de Método

O *Method Reference* pode ser utilizado para referenciar diferentes tipos de métodos, incluindo:

- **Um método de instância específico de um objeto.** Esse tipo de Method Reference é usado quando você quer invocar um método de instância para um objeto específico, ou seja, um objeto que já existe e foi criado. Ele é como uma substituição para uma chamada de método desse objeto específico.
```java
public void print(String message) { System.out.println(message); }
    
Example example = new Example();
Consumer<String> printer = example::print; // Referência a um método de instância de um objeto específico
printer.accept("Hello, Method Reference!");
```
- **Um método estático de uma classe.** Esse tipo de Method Reference é usado para referenciar um método estático de uma classe. Como métodos estáticos não pertencem a uma instância específica de um objeto, eles podem ser chamados diretamente pelo nome da classe, o que torna essa referência bem direta.
```java
public static void print(String message) { System.out.println(message); }

Consumer<String> printer = Example::print; // Referência a um método estático
printer.accept("Hello, Static Method Reference!");
```
- **Um método de instância de um objeto arbitrário de um tipo específico (como de uma classe em geral).** Esse tipo de Method Reference é usado quando você não está focado em um objeto específico, mas em qualquer objeto de um determinado tipo. Ele é útil, por exemplo, em uma operação com coleções, onde você quer que um método seja chamado em cada objeto de uma lista de objetos, sem precisar se referir a um objeto específico.
```java
List<String> words = Arrays.asList("apple", "banana", "cherry");
words.forEach(String::toUpperCase); // Referência a um método de instância de um objeto do tipo String
words.forEach(System.out::println); // Imprime as palavras em maiúsculas
```
- **Um construtor de uma classe.** Esse tipo de Method Reference é utilizado para referenciar um construtor de uma classe. Ele permite a criação de novos objetos de forma simplificada, especialmente útil em operações como map, onde você deseja transformar elementos em novas instâncias de uma classe.
```java
public Example() { System.out.println("New Example created!"); }

Supplier<Example> exampleSupplier = Example::new; // Referência a um construtor
Example example = exampleSupplier.get();
```

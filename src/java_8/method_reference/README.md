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

### Exemplo 01: método de instância específico de um objeto

O uso de *Method Reference* em Java 8 está diretamente relacionado ao conceito de interfaces funcionais, anotadas com `@FunctionalInterface`.

Neste exemplo, vamos criar uma interface funcional chamada `Figura2D`, que inclui o método `desenha()`. Esse método aceita dois parâmetros `Double`: `altura` e `largura`, representando as dimensões de uma figura bidimensional.

Como a interface `Figura2D` possui apenas um método abstrato, podemos implementá-la usando expressões lambda. Um exemplo de implementação seria:

```java
Figura2D figura = (altura, largura) -> System.out.println("Desenhando Figura. Altura: " + altura + ", e Largura: " + largura);
```

Esse tipo de interface é semelhante à interface funcional `BiConsumer<T, U>`, que contém o método `accept(T var1, U var2)`, usado para operações com dois argumentos, embora o nome do método (`accept`) não seja o mesmo de `desenha()`.

Em seguida, criamos uma classe concreta chamada `Retangulo`, que possui um método `desenhaRetangulo()`, semelhante ao `desenha()` da interface `Figura2D`.

Para substituir a expressão lambda por uma *Method Reference* associada a um objeto específico, fazemos o seguinte:

1. Criamos um objeto `Retangulo`.
2. Substituímos a expressão lambda `Figura2D figura = (altura, largura) -> retangulo.desenhaRetangulo(altura, largura);` por uma *Method Reference* que faz uso direto do método: `Figura2D figura = retangulo::desenhaRetangulo;`.

Isso simplifica o código e melhora sua legibilidade, destacando o uso de *Method References* como uma maneira de evitar duplicidade e promover clareza.

Também podemos usar a interface `BiConsumer<Double, Double>`, apesar de seu método `accept` não estar diretamente relacionado ao método `desenha()` de `Figura2D`. Um exemplo seria:

```java
BiConsumer<Double, Double> desenhaRetangulo1 = retangulo::desenhaRetangulo;
```

### Exemplo 02: método estático de uma classe

Neste exemplo, vamos substituir a expressão lambda que imprime as informações do produto por uma referência a método (`Method Reference`), simplificando ainda mais o código.

A expressão lambda original é:

```java
produto -> System.out.println("Nome: " + produto.getNome() + ", Preço: " + produto.getPreco())
```

Para substituir essa expressão, crie uma classe chamada `Impressora` com um método `static void imprime(Produto p)`, que receberá um objeto `Produto` e imprimirá suas informações. A assinatura do método deve ser:

```java
public class Impressora {
    public static void imprime(Produto p) {
        System.out.println("Nome: " + p.getNome() + ", Preço: " + p.getPreco());
    }
}
```

Com o método `imprime` pronto, você poderá usar uma `Method Reference` para simplificar a impressão dos produtos na lista:

```java
produtos.forEach(Impressora::imprime);
```

Essa abordagem é útil para tornar o código mais legível e compacto, evitando a necessidade de expressões lambda quando um método existente pode realizar a tarefa de maneira direta.

### Exemplo 03: método de instância de um objeto arbitrário

Este exemplo aborda Method Reference para um método de instância de um objeto arbitrário de um tipo específico.

Esse tipo de Method Reference é semelhante ao exemplo anterior (Exemplo02), em que utilizamos a notação `NomeDaClasse::nomeDoMetodo`.
No entanto, enquanto a referência estática (`static`) invoca o método diretamente a partir da classe, a referência a partir de um objeto arbitrário invoca o método a partir de uma instância "corrente" de um tipo específico de objeto.

A diferença entre esses dois tipos de referência é sutil: 

1. **Referência estática**: invoca o método diretamente na classe (`Classe::metodo`).
2. **Referência de instância de um objeto arbitrário**: invoca o método a partir de uma instância de uma classe específica, sem a necessidade de especificar um objeto concreto.

Neste exemplo, vamos implementar o método `imprime` na classe `Produto`. Esse método será semelhante ao `imprime` do Example02, porém, desta vez, ele não será `static`, e não precisará do parâmetro `Produto`, pois acessará os atributos diretamente na instância corrente.

Exemplo do método:

```java
public void imprime() {
    System.out.println("Nome: " + this.getNome() + ", Preço: " + this.getPreco());
}
```

### Exemplo 04: usando construtor

O tipo de retorno do método na interface funcional precisa ser compatível com o tipo da classe que terá seu construtor referenciado.

O método `desenha()` deve retornar um objeto do tipo `Retangulo`.

Inclui uma classe concreta chamada `Retangulo`, que possui um construtor definido e será utilizada na referência ao construtor.

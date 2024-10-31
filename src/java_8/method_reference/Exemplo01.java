package java_8.method_reference;

import java.util.function.BiConsumer;

// Criando uma interface funcional e usando a anotação @FunctionalInterface
// Veja que este tipo de interface exige uma expressão lambda com dois argumentos (x, y) -> x + y
// Essa interface é um BiConsumer<T, U> e seu metodo void accept(T var1, U var2)
@FunctionalInterface
interface Figura2D {
    void desenha(Double altura, Double largura);
}

// Classe concreta Retangulo
class Retangulo {
    public void desenhaRetangulo(Double altura, Double largura) {
        System.out.println("Desenhando Retangulo. Altura: " + altura + ", e Largura: " + largura);
    }
}

public class Exemplo01 {

    public static void main(String[] args) {
        // Implementando a @FunctionalInterface usando funções anonimas (Expressões Lambda)
        Figura2D figura = (altura, largura) -> System.out.println("Desenhando Figura. Altura: " + altura + ", e Largura: " + largura);
        figura.desenha(2.5, 3.0);

        // Objeto Específico
        // Substituindo a expressão lambda por Method Reference
        // É preciso uma classe que possua um metodo desenha() semelhante ao metodo abstrato de Figura2D
        Retangulo retangulo = new Retangulo();

        // Exemplo usando a Figura2D que é basicamente um BiConsumer
        Figura2D desenhaRetangulo = retangulo::desenhaRetangulo;
        desenhaRetangulo.desenha(4.7, 3.0);

        // Exemplo usando o próprio BiConsumer<Double, Double> e seu metodo void accept(Double T, Double U)
        // Veja que o nome do metodo de BiConsumer não tem nada a ver com desenha() de Figura2D
        // Mas o mesmo resultado é obtido
        BiConsumer<Double, Double> desenhaRetangulo1 = retangulo::desenhaRetangulo;
        desenhaRetangulo1.accept(4.6, 3.0);
    }

}

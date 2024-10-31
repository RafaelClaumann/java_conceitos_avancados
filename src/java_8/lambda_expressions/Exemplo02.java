package java_8.lambda_expressions;

// Lembrando que 'void desenha();' é 'public abstract void desenha();'
// A anotação @FunctionalInterface é opcional, mas serve como uma segurança indicando que a interface não mudará
@FunctionalInterface
interface Figura {
    void desenha();
}

public class Exemplo02 {

    public static void main(String[] args) {
        // Desenhando Figura sem usar lambda expressions
        Figura figura1 = new Figura() {
            @Override
            public void desenha() {
                System.out.println("Criando Figura sem expressão lambda mesmo sabendo que Figura é uma @FunctionalInterface");
            }
        };
        figura1.desenha();

        // Desenhando Figura usando lambda expressions
        // Implementação de expressão lambda sem argumentos
        Figura figura2 = () -> System.out.println("Criando Figura usando expressão lambda");
        figura2.desenha();
    }

}

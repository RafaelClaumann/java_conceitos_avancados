package java_8.method_reference;

// O metodo da interface funcional deve retornar o tipo da classe cujo construtor será referenciado
@FunctionalInterface
interface Figura2D1 {
    Retangulo1 desenha(Double altura, Double largura);
}

// Classe concreta Retangulo com construtor definido
class Retangulo1 {
    public Retangulo1(Double altura, Double largura) {
        System.out.println("Desenhando Retangulo. Altura: " + altura + ", e Largura: " + largura);
    }
}

public class Exemplo04 {

    public static void main(String[] args) {
        // Method reference com construtor
        Figura2D1 figura2D1 = Retangulo1::new;
        figura2D1.desenha(5.5, 6.0);
    }

}
